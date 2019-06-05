package com.gyt.fittrainer.service;

import com.gyt.fittrainer.dto.User;

/**
 * description
 *
 * @author guiyuting 2019/04/17 19:28
 */
public interface ITokenService {
    public String getToken(User user);
}
