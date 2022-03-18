package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.basic.model.Night_Pharmacy;
import com.example.basic.repository.Night_PharmacyRepository;

@Controller
public class ThymeleafController {
	
	@Autowired
	Night_PharmacyRepository night_PharmacyRepository;
	

	@GetMapping("user")
	public String user(Model model) {
		Map<String, Object> user = null;
		user = new HashMap<>();
		user.put("userId", "z");
		user.put("userName", "zoo");
		user.put("userAge", 25);
		Map<String,Object> map = new HashMap<>();
		user.put("map", map);
		map.put("1", "ㄱ");
		map.put("2", "ㄴ");
		map.put("3", "ㄷ");
		model.addAttribute("user", user);
		return "user";
	}

	@GetMapping("userList")
	public String userList(Model model) {
		List<Map<String, Object>> userList = new ArrayList<>();
		Map<String, Object> user = null;
		user = new HashMap<>();
		user.put("userId", "a");
		user.put("userName", "apple");
		user.put("userAge", 21);
		userList.add(user);
		user = new HashMap<>();
		user.put("userId", "b");
		user.put("userName", "banana");
		user.put("userAge", 22);
		userList.add(user);
		user = new HashMap<>();
		user.put("userId", "c");
		user.put("userName", "carrot");
		user.put("userAge", 23);
		userList.add(user);
		model.addAttribute("userList", userList);
		return "userList";
	}

	@GetMapping("mode")// th:if , th:unless , th:switch 자바와 쪼오금 유사함.
	public String mode(// if()     if(!)		swtich - case 
			Model model, @RequestParam Map<String, Object> map) {
		model.addAttribute("name", map.get("name"));
		model.addAttribute("auth", map.get("auth"));
		model.addAttribute("category", map.get("category"));
		return "mode";
	}

	@GetMapping("pagination")
	public String pagination(
			Model model, @RequestParam(defaultValue = "1") int page) {
		int startPage = (page - 1) / 10 * 10 + 1;
		int endPage = startPage + 9;
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		return "pagination";
	}
	
	@GetMapping("linkUrl")
	public String linkUrl(
			Model model, @RequestParam(defaultValue = "1") int page) {
		int startPage = (page - 1) / 10 * 10 + 1;
		int endPage = startPage + 9;
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		return "linkUrl";
	}
	
	@GetMapping("test")
	public String test(
			Model model, @RequestParam(defaultValue = "1") int page) {
		int startPage = (page - 1) / 10 * 10 + 1;
		int endPage = startPage + 9;
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		return "test";
	}
	
	@GetMapping("test/{page}")
	public String test(
			Model model, @PathVariable("page") String page) {
		int pages = Integer.parseInt(page);
		int startPage = (pages - 1) / 10 * 10 + 1;
		int endPage = startPage + 9;
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", pages);
		return "test";
	}
	
	@GetMapping("/html/night")
	public String night(Model model, @RequestParam(value="page",defaultValue = "0",required = false)String page) {
		int pages = Integer.parseInt(page)-1;
		if(pages<0) {pages=0;}
		Sort sort = Sort.by("name");
		Pageable p = PageRequest.of(pages, 10,sort);
		Page<Night_Pharmacy> result = night_PharmacyRepository.findAll(p);
		List<Night_Pharmacy> list = result.getContent();
		model.addAttribute("list", list);
		model.addAttribute("page", pages+1);
		return "html/night";
		
	}
	


}
