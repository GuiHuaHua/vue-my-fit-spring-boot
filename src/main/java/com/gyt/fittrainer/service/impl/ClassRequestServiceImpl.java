package com.gyt.fittrainer.service.impl;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.ClassRequest;
import com.gyt.fittrainer.dto.Event;
import com.gyt.fittrainer.mapper.ClassRequestMapper;
import com.gyt.fittrainer.mapper.EventMapper;
import com.gyt.fittrainer.service.IClassRequestService;
import com.gyt.fittrainer.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * description
 *
 * @author guiyuting 2019/04/10 16:29
 */
@Service(value = "classRequestService")
public class ClassRequestServiceImpl implements IClassRequestService {

    @Autowired
    private ClassRequestMapper mapper;

    @Override
    public List<ClassRequest> selectByUser(ClassRequest record, HttpServletRequest request) {
        return mapper.selectByUser(record);
    }

    @Override
    public MyResult submitClassRequest(ClassRequest record, HttpServletRequest request) {
        MyResult result = new MyResult();
        if(record.getClassTime()!=null){
            record.setStartTime(record.getClassTime()[0]);
            record.setEndTime(record.getClassTime()[1]);
        }
        if(record.getBodypartList()!=null){
            List<String> bodyParts = record.getBodypartList();
            String parts = "";
            for(int i=0;i<bodyParts.size();i++){
                parts  = parts + bodyParts.get(i);
                if(i<bodyParts.size()-1){
                    parts += ";";
                }
            }
            record.setBodypart(parts);
        }
        if(record.getRequestId()!=null){
            mapper.updateByPrimaryKey(record);
        }else{
            mapper.insertSelective(record);
        }
        result.setCode(0);
        result.setMessage("保存成功！");
        return result;
    }
}
