package com.example.demo.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.test.model.Test;
import com.example.demo.test.model.TestDetails;
import com.example.demo.test.service.TestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
	
	private final TestService service;
	
	@PostMapping("/insert")
	void insertTest(@RequestBody TestDetails details) {
		service.insertTest(details);
	}
	
	@GetMapping("get/all")
	List<Test> getAllTests(){
		return service.getAllTest();
	}

}
