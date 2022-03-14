package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Json1Controller {
// ResponseBody 를 사용하여 Json(api) 으로 보내기 때문에,
// html 이 필요 없음. 보통 Map List Dto(vo)를 보냄.
    @GetMapping("json/string")
    @ResponseBody
    public String json() {
        return "json/string";
    }

    @GetMapping("json/map")
    @ResponseBody
    public Map<String, Object> jsonMap(Map<String, Object> map) {
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("key1", "value");
        map2.put("key2", 2324);
        map2.put("key3", true);
        return map2;
    }

    @GetMapping("json/list")
    @ResponseBody
    public List<String> jsonList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        return list;
    }

    @GetMapping("json/exam")
    @ResponseBody
    public Map<String,Object> jsonExam(){
        List<Map<String,String>> list = new ArrayList<>();

        Map<String,Object> map = new HashMap<>();
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();

        map1.put("name", "가"); 
        map1.put("userId", "A");
        map1.put("userPassword", "1");
     
        map2.put("name", "나");
        map2.put("userId", "B");
        map2.put("userPassword", "2");
        list.add(map1);
        list.add(map2);
        map.put("count", 2);
        map.put("list", list);


        return map;
    }

}
