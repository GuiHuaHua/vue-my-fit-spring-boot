package com.gyt.fittrainer.mapper;

import com.gyt.fittrainer.dto.Event;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface EventMapper {
    int deleteByPrimaryKey(Long eventId);

    int insert(Event record);

    int insertSelective(Event record);

    Event selectByPrimaryKey(Long eventId);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);

    List<Event> selectByUserId(@Param("userId") Long userId);

    int checkIfOccupied(Event event);
}