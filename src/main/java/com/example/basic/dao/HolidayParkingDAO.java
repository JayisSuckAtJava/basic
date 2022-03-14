package com.example.basic.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
public class HolidayParkingDAO {}
/*
@Component

    @Autowired
    JdbcTemplate jt;
    
    public List<Map<String, Object>> sel(int page) {
        return jt.queryForList("select * from holiday_parking limit 0 , ?", page * 10);
    }

    public List<Map<String, Object>> sel2() {
        // 금천구만 검색
        return jt.queryForList("select * from holiday_parking WHERE gu = '금천구'");
    }

    public List<Map<String, Object>> sel3() {
        // 금천구만 검색
        return jt.queryForList("select * from holiday_parking WHERE address = '%조치원%'");
    }
}*/
