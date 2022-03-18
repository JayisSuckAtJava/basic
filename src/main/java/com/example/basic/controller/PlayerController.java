package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.basic.repository.PlayerRepository;

@Controller
public class PlayerController {
	
	@Autowired
	PlayerRepository playerRepository;
	
	
	
	
	@GetMapping("")
	public void se() {
		
	}
}
