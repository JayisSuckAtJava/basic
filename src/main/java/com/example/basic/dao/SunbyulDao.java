package com.example.basic.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class SunbyulDao {
    
    @Autowired
    JdbcTemplate jt;

    public List<Map<String, Object>> sel(int startRow) {
        return jt.queryForList("select * from sunbyul limit ? , ?", startRow , startRow+10);
    }

    public List<Map<String, Object>> sel2() {
        return jt.queryForList("select * from sunbyul where sido='세종'");
    }
}
