package com.gyt.fittrainer.mapper;

import com.gyt.fittrainer.dto.ClassRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassRequestMapper {
    int deleteByPrimaryKey(Long requestId);

    int insert(ClassRequest record);

    int insertSelective(ClassRequest record);

    ClassRequest selectByPrimaryKey(Long requestId);

    int updateByPrimaryKeySelective(ClassRequest record);

    int updateByPrimaryKey(ClassRequest record);

    List<ClassRequest> selectByUser(ClassRequest record);
}