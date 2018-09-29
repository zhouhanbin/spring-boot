package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@RestController
@RequestMapping("myDb")
public class DbController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("getDbType")
    public List<Map<String,Object>> getDbType(){
        String sql = "select * from activity_prize";

        List<Map<String,Object>> mapList = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> objectMap : mapList) {
            Set<Entry<String, Object>> entitySet = objectMap.entrySet();
            if(entitySet.isEmpty()){
                Iterator<Entry<String, Object>> iterable = entitySet.iterator();
                while (iterable.hasNext()){
                    Entry<String, Object> entry = iterable.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return mapList;
    }

}
