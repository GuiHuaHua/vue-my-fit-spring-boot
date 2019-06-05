package com.gyt.fittrainer.controllers;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.annotions.UserLoginToken;
import com.gyt.fittrainer.dto.Diet;
import com.gyt.fittrainer.service.IDietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * description
 *
 * @author guiyuting 2019/06/04 10:36
 */
@RequestMapping(value = "/diet")
@Controller
public class DietController {
    @Autowired
    private IDietService dietService;

    @ResponseBody
    @RequestMapping("/getDietList")
    @UserLoginToken
    public List<Diet> getTrainerList(Long userId, HttpServletRequest request){
        return  dietService.getDietList(userId,request);
    }

    @ResponseBody
    @RequestMapping("/insertDiet")
    @UserLoginToken
    public MyResult insertDiet(@RequestBody Diet diet, HttpServletRequest request){
        return  dietService.insertDiet(diet,request);
    }

    @ResponseBody
    @RequestMapping("/importTest")
    @UserLoginToken
    public MyResult importData(@RequestBody Diet diet, HttpServletRequest req) throws IOException {
        MyResult result = new MyResult();
/*        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/upload") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload" + format + newName;
        System.out.println(url);*/
        return result;
    }

}
