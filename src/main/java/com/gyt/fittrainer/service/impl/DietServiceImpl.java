package com.gyt.fittrainer.service.impl;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.Diet;
import com.gyt.fittrainer.mapper.DietMapper;
import com.gyt.fittrainer.service.IDietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/06/04 10:33
 */
@Service("dietService")
public class DietServiceImpl implements IDietService {
    @Autowired
    private DietMapper dietMapper;

    @Override
    public List<Diet> getDietList(Long userId, HttpServletRequest request) {
        return dietMapper.getDietList(userId);
    }

    @Override
    public MyResult insertDiet(Diet diet, HttpServletRequest request) {
        MyResult result = new MyResult();
        diet.setDate(new Date());
        dietMapper.insertSelective(diet);
        return result;
    }
}
