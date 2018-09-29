package com.controller;

import com.service.ActivityTaskPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("activityTask")
public class ActivityTaskController {

    @Autowired
    private ActivityTaskPrizeService activityTaskPrizeService;

    @RequestMapping("getById")
    @ResponseBody
    public Object getById(@RequestParam(value = "id")Integer id){
       return activityTaskPrizeService.findById(id);
    }

}
