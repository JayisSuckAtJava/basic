package com.example.basic.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.Member;
import com.example.basic.repository.MemberRepository;

@Controller
public class MemberController {

	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("member")
	public String member() {
		return "member";
	}
	
	@PostMapping("member/signup")
	public String memberPost(@ModelAttribute Member member,HttpSession session) {
		memberRepository.save(member);
		session.setAttribute("member", member);
		
		return "redirect:/member";
	}
	
	@GetMapping("member/login")
	public String login() {
		
		return "member/login";
	}
	
	@ResponseBody
	@PostMapping("member/login")
	public Map<String , Object> login(@ModelAttribute Member member,HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String id =member.getUserId();
		String password =member.getUserPassword();
		
		Member result = memberRepository.findByUserIdAndUserPassword(id,password);
		
		session.setAttribute("member", result);
		System.out.println(session.getAttribute("member"));
		if(result.getUserId()==null) {
			map.put("result", "fail");
		}else {
			map.put("result", "done");
		}
		return map;
		
	}
	
	@GetMapping("member/signup")
	public String sginup() {
		return "member/signup";
	}
}
