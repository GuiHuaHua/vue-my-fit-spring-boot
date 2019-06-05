package com.gyt.fittrainer.service.impl;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.Event;
import com.gyt.fittrainer.dto.User;
import com.gyt.fittrainer.mapper.EventMapper;
import com.gyt.fittrainer.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/04/10 16:29
 */
@Service(value = "eventService")
public class EventServiceImpl implements IEventService {

    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<Event> selectByUserId(Long userId, HttpServletRequest request) {
        return eventMapper.selectByUserId(userId);
    }

    @Override
    public int checkIfOccupied(Event event, HttpServletRequest request) {
        return eventMapper.checkIfOccupied(event);
    }

    @Override
    public Event insertEvent(Event event, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        event.setUserId(userId);
        eventMapper.insertSelective(event);
        return event;
    }

    @Override
    public void updateEvent(Event event, HttpServletRequest request) {

    }
}
