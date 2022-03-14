package com.example.basic.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.basic.vo.Data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestContorller {

    @GetMapping("req/param1")
    public String param1(@RequestParam("key1") String key1,@RequestParam("key2") String key2,@RequestParam(value = "key3", defaultValue = "ISNULL")String key3) {
        return key1 + ", " + key2 + " , " + key3;
    }

    @GetMapping("req/param2")
    public String param2(@RequestParam Map<String, Object> map) {
        return map.toString();
    }

    @GetMapping("req/path/{path1}/{path2}")
    public String path( @PathVariable("path1") String path1, @PathVariable("path2") String path2) {
        return path1 + ", " + path2;
    }// 게시물 번호 , 사용자 정보 , 제품 정보 등으로 사용함
    // /board/123   /user/ggoreb     /product/a001

    @GetMapping("req/data")
    public Map<String, Object> data(@RequestParam Map<String,Object> map) {
        return map;
    }
    
    @GetMapping("req/data2")
    public Map<String, Object> data2(String area,String score) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(area!=null){map.put("area", area);};
        if(score!=null){map.put("score", score);};
        return map;
    }

    @GetMapping("req/data3")
    public Map<String,Object> data3(@RequestParam(value = "area", required = false) String area,
                                    @RequestParam(value = "score",required = false) Integer score,
                                    @ModelAttribute("data") Data data){
        Map<String,Object> map = new HashMap<String,Object>();
        if(area!=null){map.put("area", area);}
        if(score!=null){map.put("score", score);}
        return map;
    }
    
}
