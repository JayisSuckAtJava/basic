package com.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VisitorController {

	@GetMapping("/visitor")
	@ResponseBody
	public String visitor(@RequestHeader("user-agent") String userAgent) {
		return userAgent;
	}
}
