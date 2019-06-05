package com.gyt.fittrainer.service;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.Event;
import com.gyt.fittrainer.dto.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/03/25 16:03
 */
public interface IEventService {

    List<Event> selectByUserId(Long userId, HttpServletRequest request);

    int checkIfOccupied(Event event, HttpServletRequest request);

    Event insertEvent(Event event, HttpServletRequest request);

    void updateEvent(Event event, HttpServletRequest request);
}
