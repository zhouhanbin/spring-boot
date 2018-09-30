package com.controller;

import com.service.ActivityTaskPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("activityTask")
public class ActivityTaskController {

    @Autowired
    private ActivityTaskPrizeService activityTaskPrizeService;

    @RequestMapping("getById")
    @ResponseBody
    public Object getById(@RequestParam(value = "id")Integer id){
        Map<String,String> stringStringMap = new HashMap<>(16);
        stringStringMap.put("","");
       return activityTaskPrizeService.findById(id);
    }

}
