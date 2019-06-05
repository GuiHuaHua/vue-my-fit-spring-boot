package com.gyt.fittrainer.mapper;

import com.gyt.fittrainer.dto.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    User queryByUserName(User record);

    User selectByPrimaryKey(Long userId);

}