package com.example.basic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.dao.DemoDao;
import com.example.basic.dao.SunbyulDao;
import com.example.basic.mapper.DemoMapper;
import com.example.basic.mapper.PollMapper;
import com.example.basic.mapper.SunbyulMapper;
import com.example.basic.model.Demo;
import com.example.basic.model.holiday_Parking;
import com.example.basic.repository.AnyRepository;
import com.example.basic.repository.DemoRepository;
import com.example.basic.repository.ParkingRepository;
import com.example.basic.vo.Any;

@RestController
public class DBController {
    @Autowired
    DemoDao demoDao;

    @Autowired
    SunbyulDao sunbyulDao;

    @Autowired
    DemoMapper demoMapper;
    
    @Autowired
    PollMapper pollMapper;
    
    @Autowired
    SunbyulMapper sunbyulMapper;
    
    @Autowired
    DemoRepository demoRepository;
    
    @Autowired
    AnyRepository anyRepository;

    @Autowired
    ParkingRepository parkingRepository;
    
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
    	int endRow = startRow + 10;
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("startRow", startRow);
    	map.put("endRow", endRow);
    
        return sunbyulMapper.select(map);
    }

    @GetMapping("/jdbc/sunbyul2")
    public List<Map<String, Object>> jdbcSunbyul2(){
        return  sunbyulMapper.sejong();
    }

    // j unit - 

    @GetMapping("/mybatis/demo")
    public List<Map<String, Object>> mybatisDemo() {
        return demoMapper.select();
    }


    @GetMapping("/mybatis/demo2")
    public String mybaitsDemoInsert(@RequestParam("seq") int seq, @RequestParam("user") String user){
        Map<String , Object > map = new HashMap<>();
        map.put("seq", seq);
        map.put("user", user);
        int result = demoMapper.insert(map);
        if(result!=0){return "Done";}
        if(result==0){return "Fail";}
        return "What is this fucking error";
    }
    
    @GetMapping("/mybatis/poll")
    public String mybatisPoll(@RequestParam Map<String ,Object> map) {
    	int result =pollMapper.insert(map);
    	if(result!=0){return "Done";}
        if(result==0){return "Fail";}
		return "What is this fucking error";    	
    }
    
    @GetMapping("/mybatis/polls")
    public List<Map<String, Object>> mybatisPolls() {
    	return pollMapper.select();
    }
    @GetMapping("/jpa/demo")
    public List<Demo> jpaDemo() {
    return demoRepository.findAll();
    }
    
    @GetMapping("/jpa/any")
    public List<Any> jpaAny(){
    	return anyRepository.findAll();
    }
    @GetMapping("/jpa/parking")
    public List<holiday_Parking> jpaParking(){
    	return parkingRepository.findAll();
    }
    
    @GetMapping("/jpa/parking2")
    public List<holiday_Parking> jpaParking2(@RequestParam(value = "sido", defaultValue = "세종%",required = false)String sido){
    	return parkingRepository.findBySido(sido);
    }

}