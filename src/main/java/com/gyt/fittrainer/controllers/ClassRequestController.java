package com.gyt.fittrainer.controllers;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.ClassRequest;
import com.gyt.fittrainer.dto.Event;
import com.gyt.fittrainer.service.IClassRequestService;
import com.gyt.fittrainer.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/03/25 16:04
 */
@RequestMapping(value = "/training")
@Controller
public class ClassRequestController {
    @Autowired
    private IClassRequestService classRequestService;

    @ResponseBody
    @RequestMapping("/getRequestByUser")
    public List<ClassRequest> getRequestByUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        return classRequestService.selectByUser(ClassRequest.builder().userId(userId).build(), request);
    }

    @ResponseBody
    @RequestMapping("/getClassRequestInfo")
    public ClassRequest getClassRequestInfo(Long requestId,HttpServletRequest request) {
        ClassRequest classRequest = classRequestService.selectByUser(ClassRequest.builder().userId(requestId).build(), request).get(0);
        Date[] dates = new Date[2] ;
        dates[0] = classRequest.getStartTime();
        dates[1] = classRequest.getEndTime();
        classRequest.setClassTime(dates);
        List<String> bodypartList = new ArrayList<>();
        if(classRequest.getBodypart()!=null){
            String[] parts = classRequest.getBodypart().split(";");
            for(int i=0;i<parts.length;i++){
                bodypartList.add(parts[i]);
            }
        }
        classRequest.setBodypartList(bodypartList);

        return classRequest;
    }

    @ResponseBody
    @RequestMapping("/submitClassRequest")
    public MyResult submitClassRequest(@RequestBody ClassRequest classRequest,@RequestParam String action, HttpServletRequest request){
        if(action == "submit"){
            classRequest.setStatus("submitted");
        }
        return classRequestService.submitClassRequest(classRequest,request);
    }

}
