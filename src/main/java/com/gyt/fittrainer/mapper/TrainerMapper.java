package com.gyt.fittrainer.mapper;

import com.gyt.fittrainer.dto.Trainer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainerMapper {
    int deleteByPrimaryKey(Long trainerId);

    int insert(Trainer record);

    int insertSelective(Trainer record);

    Trainer selectByPrimaryKey(Long trainerId);

    int updateByPrimaryKeySelective(Trainer record);

    int updateByPrimaryKey(Trainer record);

    List<Trainer> getTrainerList(Trainer record);

    int checkIfExists(@Param("userId") Long userId);
}