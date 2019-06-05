package com.gyt.fittrainer.service.impl;

import com.github.pagehelper.PageHelper;
import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.Trainer;
import com.gyt.fittrainer.dto.User;
import com.gyt.fittrainer.mapper.TrainerMapper;
import com.gyt.fittrainer.mapper.UserMapper;
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
@Service( value = "trainerService")
public class TrainerServiceImpl implements ITrainerService {
    @Autowired
    private TrainerMapper trainerMapper;


    @Override
    public List<Trainer> getTrainerList(Trainer trainer, HttpServletRequest request) {
        return trainerMapper.getTrainerList(trainer);
    }

    @Override
    public int checkIfExists(Long userId, HttpServletRequest request) {
        return trainerMapper.checkIfExists(userId);
    }

    @Override
    public Trainer getTrainerDetail(Long trainerId, HttpServletRequest request) {
        return trainerMapper.selectByPrimaryKey(trainerId);
    }
}
