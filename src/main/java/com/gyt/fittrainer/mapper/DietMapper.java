package com.gyt.fittrainer.mapper;

import com.gyt.fittrainer.dto.Diet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DietMapper {
    int deleteByPrimaryKey(Long dietId);

    int insert(Diet record);

    int insertSelective(Diet record);

    Diet selectByPrimaryKey(Long dietId);

    int updateByPrimaryKeySelective(Diet record);

    int updateByPrimaryKey(Diet record);

    List<Diet> getDietList(@Param("userId") Long userId);
}