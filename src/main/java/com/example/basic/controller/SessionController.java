package com.example.basic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.basic.model.User;
import com.example.basic.repository.UserRepository;
@Controller
public class SessionController {
// Session ( HttpSession ) setAttribute , getAttribute , invalidate ( 값 설정 , 받기 , 세션 초기화 )

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/login")
	public String login() {
	return "login";
	}
	@PostMapping("/login")
	public String loginPost(User user, HttpSession session) {
	String id = user.getUserId();
	String pw = user.getUserPw();
	User result = userRepository.findByUserIdAndUserPw(id,pw);
	
	session.setAttribute("user", result);
	return "redirect:/main";
	}
	@GetMapping("/main")
	public String main() {
	return "main";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "main";
	}
	
	
	
	@GetMapping("join")
	public String join() {
		return "join";
	}
	
	@PostMapping("join")
	public String joinPost(@ModelAttribute User user) {
		userRepository.save(user);
		return "redirect:/login";
	}

}
