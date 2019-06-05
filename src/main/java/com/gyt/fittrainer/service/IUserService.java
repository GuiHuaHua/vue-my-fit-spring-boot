package com.gyt.fittrainer.service;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/03/25 16:03
 */
public interface IUserService {
    MyResult login(User user,HttpServletRequest request);

    MyResult register(User user, HttpServletRequest request);

    User selectByPrimaryKey(Long userId,HttpServletRequest request);

}
