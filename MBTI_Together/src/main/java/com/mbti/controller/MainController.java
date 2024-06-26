package com.mbti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mbti.config.error.InvalidDataException;


@Controller
public class MainController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String main() {
		return "main";
	
	}
	
	// 파라미터 넣으면 오류남 
	@RequestMapping(path="/test2", method=RequestMethod.GET)
	public String test(String hmm) {
		System.out.println(hmm);
		if(hmm==null)
			throw new InvalidDataException("Data must be at least 5 characters long");
		return "main";
	
	}
	
	
	
}
