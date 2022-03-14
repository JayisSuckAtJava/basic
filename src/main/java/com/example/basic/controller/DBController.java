package com.example.basic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.basic.dao.DemoDao;
import com.example.basic.dao.SunbyulDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {
    @Autowired
    DemoDao demoDao;

    @Autowired
    SunbyulDao sunbyulDao;

    @GetMapping("/jdbc/demo")
    public List<Map<String, Object>> jdbcDemo() {
        return demoDao.select();
    }

    @GetMapping("/jdbc/demo2")
    public Map<String, Object> jdbcDemo2() {
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("key", demoDao.select2()) ;
        
        return map;
    }

    @GetMapping("/jdbc/holiday")
    public List<Map<String, Object>> jdbcHoliday(@RequestParam(value = "page",defaultValue = "1")int page){
        int startRow = (page-1) * 10;
        return demoDao.sel(startRow);
    }

    @GetMapping("/jdbc/holiday2")
    public List<Map<String, Object>> jdbcHoliday2(){
        return demoDao.sel2();
    }

    @GetMapping("/jdbc/holiday3")
    public List<Map<String, Object>> jdbcHoliday3(){
        return demoDao.sel3();
    }

    @GetMapping("/jdbc/sunbyul")
    public List<Map<String, Object>> jdbcSunbyul(@RequestParam(value = "page",defaultValue = "1")int page){
        int startRow = (page-1) * 10;
        return sunbyulDao.sel(startRow);
    }

    @GetMapping("/jdbc/sunbyul2")
    public List<Map<String, Object>> jdbcSunbyul2(){
        return sunbyulDao.sel2();
    }

    // j unit - 
}