package com.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;



@Controller
public class MainController {

	String demo = "";			
	

	@GetMapping("/calculator")
	public String test() {
		return "index"; 
	}
	
	@PostMapping("/calculate")
	public String receivedString(@RequestParam String action,String getInpData,String demoData, Model m1) {
	
		if(action.equals("+")||action.equals("-")||action.equals("/")||action.equals("*")||action.equals("%")) {
			
			
			if(getInpData.length() !=0) {
				if(getInpData.charAt(getInpData.length()-1)=='+'||getInpData.charAt(getInpData.length()-1)=='-'||
						getInpData.charAt(getInpData.length()-1)=='/'||getInpData.charAt(getInpData.length()-1)=='*') {
					getInpData = getInpData.substring(0,getInpData.length()-1);
				}
				
				Expression expression = new ExpressionBuilder(getInpData).build();
				
				getInpData+=action;
				
				m1.addAttribute("addInp",getInpData);
							
				m1.addAttribute("demo",expression.evaluate());
				
			}
			
			
			
			
		}
		if(action.equals("=")&&getInpData.length() !=0) {
			if(getInpData.charAt(getInpData.length()-1)=='+'||getInpData.charAt(getInpData.length()-1)=='-'
					||getInpData.charAt(getInpData.length()-1)=='/'||getInpData.charAt(getInpData.length()-1)=='*'
					||getInpData.charAt(getInpData.length()-1)=='%'||getInpData.charAt(getInpData.length()-1)=='.') {
				getInpData = getInpData.substring(0,getInpData.length()-1);
			}
			Expression expression = new ExpressionBuilder(getInpData).build();			
			m1.addAttribute("addInp",expression.evaluate());
			m1.addAttribute("demo","");
		}
		
		   return "index";
		
		
	}
	
}
