package com.dw.study.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerControl {

    private static final  org.slf4j.Logger logger = LoggerFactory.getLogger(LoggerControl.class) ;

    @RequestMapping(value = "/log",method = RequestMethod.POST)
    public String getLog(@RequestParam("log") String log){

        JSONObject jsonObject = JSON.parseObject(log);
        jsonObject.put("ts",System.currentTimeMillis());
        String newLog = jsonObject.toJSONString();

        //写日志
        logger.info(newLog);
        return null;
    }

}
