package com.gyt.fittrainer.service;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.Trainer;
import com.gyt.fittrainer.dto.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/03/25 16:03
 */
public interface ITrainerService {

    List<Trainer> getTrainerList(Trainer trainer, HttpServletRequest request);

    int checkIfExists(Long userId, HttpServletRequest request);

    Trainer getTrainerDetail(Long trainerId, HttpServletRequest request);
}
