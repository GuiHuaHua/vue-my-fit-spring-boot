package com.gyt.fittrainer.controllers;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.Event;
import com.gyt.fittrainer.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/03/25 16:04
 */
@RequestMapping(value = "/event")
@Controller
public class EventController {

    @Autowired
    private IEventService eventService;

    @ResponseBody
    @RequestMapping("/selectByUser")
    public List<Event> selectByUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        return eventService.selectByUserId(userId, request);
    }

    @ResponseBody
    @RequestMapping("/checkIfOccupied")
    public MyResult checkIfOccupied(HttpServletRequest request, String start, String end) throws ParseException {
        MyResult result = new MyResult();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Event event = Event.builder().start(sdf.parse(start)).end(sdf.parse(end)).build();
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        event.setUserId(userId);
        int num = eventService.checkIfOccupied(event, request);
        int code = num == 0 ? 0 : -1;
        result.setCode(code);
        return result;
    }

    @ResponseBody
    @RequestMapping("/insertEvent")
    public Event insertEvent(HttpServletRequest request, String start, String end,String title) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Event event = Event.builder().start(sdf.parse(start)).end(sdf.parse(end)).title(title).build();
        return eventService.insertEvent(event, request);
    }

}
