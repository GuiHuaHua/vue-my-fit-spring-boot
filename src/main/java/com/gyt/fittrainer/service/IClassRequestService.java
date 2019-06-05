package com.gyt.fittrainer.service;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.ClassRequest;
import com.gyt.fittrainer.dto.Event;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/03/25 16:03
 */
public interface IClassRequestService {

    List<ClassRequest> selectByUser(ClassRequest record, HttpServletRequest request);

    MyResult submitClassRequest(ClassRequest record, HttpServletRequest request);
}
