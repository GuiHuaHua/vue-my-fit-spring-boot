package com.gyt.fittrainer.service;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.Diet;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/06/04 10:33
 */
public interface IDietService {
    List<Diet> getDietList(Long userId, HttpServletRequest request);

    MyResult insertDiet(Diet diet,HttpServletRequest request);

}
