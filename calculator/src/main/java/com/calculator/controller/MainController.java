package com.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {

	@GetMapping("/calculator")
	public String calculate() {
		return "index";
	}
	
	
	@PostMapping("/calculate")
	public String receivedString(@RequestParam String action,String getInpData,Model m1) {
	
		if(action.equals("+")||action.equals("-")||action.equals("/")||action.equals("*")||action.equals("%")) {
			
		}
		if(action.equals("=")&&getInpData.length() !=0) {
			if(getInpData.charAt(getInpData.length()-1)=='+'||getInpData.charAt(getInpData.length()-1)=='-'
					||getInpData.charAt(getInpData.length()-1)=='/'||getInpData.charAt(getInpData.length()-1)=='*'
					||getInpData.charAt(getInpData.length()-1)=='%'||getInpData.charAt(getInpData.length()-1)=='.') {
				getInpData = getInpData.substring(0,getInpData.length()-1);
			}
			
			m1.addAttribute("demo","");
		}
		
		   return "calculator";
		
		
	}
	
}
