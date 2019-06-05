package com.gyt.fittrainer.controllers;

import com.gyt.fittrainer.dto.PageEntity;
import com.gyt.fittrainer.dto.Trainer;
import com.gyt.fittrainer.annotions.UserLoginToken;
import com.gyt.fittrainer.service.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/03/25 16:04
 */
@RequestMapping(value = "/trainer")
@Controller
public class TrainerController {
    @Autowired
    private ITrainerService trainerService;

    @ResponseBody
    @RequestMapping("/getTrainerList")
    @UserLoginToken
    public ResponseEntity getTrainerList(Long userId, int pageNum, int pageSize, HttpServletRequest request) {
        Trainer trainer = new Trainer();
        trainer.setUserId(userId);
        trainer.setPageNum(pageNum);
        trainer.setPageSize(pageSize);
        List<Trainer> list = trainerService.getTrainerList(trainer, request);
        return new ResponseEntity( new PageEntity<>(list), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping("/getTrainerDetail")
    @UserLoginToken
    public Trainer getTrainerDetail(Long trainerId, HttpServletRequest request) {
        return trainerService.getTrainerDetail(trainerId, request);
    }

}
