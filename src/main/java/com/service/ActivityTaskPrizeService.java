package com.service;

import com.dao.ActivityTaskPrizeMapper;
import com.entity.ActivityTaskPrize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActivityTaskPrizeService {

    @Autowired
    private ActivityTaskPrizeMapper activityTaskPrizeMapper;

    public ActivityTaskPrize findById(Integer id ){
        return activityTaskPrizeMapper.selectByPrimaryKey(id);
    }
}
