package com.example.basic.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.basic.vo.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DemoDao {
    // db 에선 snake_case 단어 사이에 _함유
    // java 에선 CamelCase 단어 시작이 대문자
    @Autowired
    JdbcTemplate jt;

    public List<Map<String, Object>> select() {
        return jt.queryForList("select * from demo");
    } // queryForList 는 return 이 List<Map>이다. (execl 과 비슷)
      // 1개의 값만 select 할때는 queryForObject 이다.

      public List<Demo> select2() {
          List<Demo> list = new ArrayList<Demo>();
          list.add(jt.queryForObject("select user from demo where seq=1", Demo.class));
        return list;
    }

    public List<Map<String, Object>> sel(int startRow) {
        return jt.queryForList("select * from holiday_parking limit ? , ?", startRow , startRow+10);
    }

    public List<Map<String, Object>> sel2() {
        // 금천구만 검색
        return jt.queryForList("select * from holiday_parking WHERE gu = '금천구'");
    }

    public List<Map<String, Object>> sel3() {
        // 조치원만 검색
        return jt.queryForList("select * from holiday_parking WHERE address LIKE '%조치원%'");
    }
}