package com.dao;

import com.entity.ActivityTaskPrize;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActivityTaskPrizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivityTaskPrize record);

    int insertSelective(ActivityTaskPrize record);

    ActivityTaskPrize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivityTaskPrize record);

    int updateByPrimaryKey(ActivityTaskPrize record);
}