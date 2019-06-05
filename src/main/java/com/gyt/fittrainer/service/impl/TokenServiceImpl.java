package com.gyt.fittrainer.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.User;
import com.gyt.fittrainer.mapper.UserMapper;
import com.gyt.fittrainer.service.ITokenService;
import com.gyt.fittrainer.service.IUserService;
import com.gyt.fittrainer.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * description
 *
 * @author guiyuting 2019/03/25 16:03
 */
@Service( value = "tokenService")
public class TokenServiceImpl implements ITokenService {

    @Override
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getUserId().toString())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }

}
