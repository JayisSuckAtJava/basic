package com.example.basic.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("number", new Random().nextInt(10));
        return "html/string";
    }
    @GetMapping("html/void")
    public void htmlVoid() {
    }// Mapping 의 Value 와 동일 경로에 templates/ 아래 파일이 있다면 가져온다.

    @GetMapping("html/map")
    public Map<String, Object> htmlMap(Map<String, Object> map) {
        Map<String, Object> map2 = new HashMap<String, Object>();
        return map2;
    }

    @GetMapping("html/model")
    public Model htmlModel(Model model) {
        return model;
    }

    @GetMapping("html/model_and_view")
    public ModelAndView htmlModel() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("html/model_and_view");
        return mav;
    }

    @GetMapping("html/exam")
    public void htmlExam(){
    }

    // @GetMapping("html/object")
    // public Member htmlObject() {
    //     Member member = new Member();
    //     member.setName("kim");
    //     return member;
    // }

}
