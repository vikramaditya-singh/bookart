package com.bookart.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class KartController {

	
	@RequestMapping(value="/hi", method=RequestMethod.GET/*headers="application/json"*//* produces="application/json"*/)
	public @ResponseBody Map<String, String> test(){
		Map<String, String> map = new HashMap<>();
		System.out.println("TESTING");
		map.put("Hello", "Hi");
		return map;
	}
	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
     public String welcome() {
           return "index";
     }
}
