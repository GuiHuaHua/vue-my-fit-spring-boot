package com.gyt.fittrainer.service.impl;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.Trainer;
import com.gyt.fittrainer.dto.User;
import com.gyt.fittrainer.mapper.TrainerMapper;
import com.gyt.fittrainer.mapper.UserMapper;
import com.gyt.fittrainer.service.ITokenService;
import com.gyt.fittrainer.service.ITrainerService;
import com.gyt.fittrainer.service.IUserService;
import com.gyt.fittrainer.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/03/25 16:03
 */
@Service( value = "userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    ITokenService tokenService;

    @Autowired
    TrainerMapper trainerMapper;

    @Override
    public MyResult login(User user, HttpServletRequest request) {
        User u = userMapper.queryByUserName(user);
        MyResult result = new MyResult();
        if(u == null){
            result.setCode(-1);
            result.setMessage("用户不存在，请先注册！");
            return result;
        }
        String password = EncryptUtil.decryptBasedDes(u.getPassword());
        if(!user.getPassword().equals(password)){
            result.setCode(-1);
            result.setMessage("密码错误！");
            return result;
        }
        if(user.getType().equals(u.getType())){
            if(u.getType().equals("T")){
                int num = trainerMapper.checkIfExists(u.getUserId());
                if(num==0){
                    result.setCode(-1);
                    result.setMessage("此用户不是教练！");
                    return result;
                }
            }
            String token = tokenService.getToken(u);
            result.setCode(0);
            result.setMessage("成功啦！");
            result.setObject(u);
            result.setToken(token);
            HttpSession session = request.getSession();
            session.setAttribute("userId",u.getUserId());
            session.setAttribute("userName",u.getUserName());
            session.setAttribute("userType",u.getType());
        }

        return result;
    }

    @Override
    public MyResult register(User user, HttpServletRequest request) {
        MyResult result = new MyResult();
        User u = userMapper.queryByUserName(user);
        if(u!=null){
            result.setCode(-1);
            result.setMessage("用户已存在！");
            return result;
        }
        String password = EncryptUtil.encryptBasedDes(user.getPassword());
        user.setPassword(password);
        userMapper.insertSelective(user);
        if(user.getType().equals("T")){
            u = userMapper.queryByUserName(user);
            trainerMapper.insertSelective(Trainer.builder().userId(u.getUserId()).build());
        }
        result.setCode(0);
        result.setMessage("注册成功！");
        return result;
    }

    @Override
    public User selectByPrimaryKey(Long userId, HttpServletRequest request) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
