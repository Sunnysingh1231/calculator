package com.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@Controller
public class MainController {

	// DEMO BOX CONTAINER
	String demo = "";
	
	@GetMapping("/calculator")
	public String test() {
		return "index";
	}
	
	@PostMapping("/calculate")
	public String receivedString(@RequestParam String action,String getInpData,String demoData, Model m1) {
	
		// IF USER PERFORM ANY OPERATION ( +, -, /, *, % )
		if(action.equals("+")||action.equals("-")||action.equals("/")||action.equals("*")||action.equals("%")) {
			
			// CHECK IF CONTAINER DOES NOT CONTAIN ANY VALUE.
			if(getInpData.length() !=0) {

				// REMOVE IF IT CONTAINS ANY OPERATION SYMBOL AT THE END
				if(getInpData.charAt(getInpData.length()-1)=='+'||getInpData.charAt(getInpData.length()-1)=='-'||
						getInpData.charAt(getInpData.length()-1)=='/'||getInpData.charAt(getInpData.length()-1)=='*') {
					getInpData = getInpData.substring(0,getInpData.length()-1);
				}
				
				// CALCULATE MULTIPLE OPERATION AT SINGLE TIME
				Expression expression = null;
				try {
					
					expression = new ExpressionBuilder(getInpData).build();
					double result = expression.evaluate();
					
					// ADD  OPERATOR SYMBOL AT END TO SHOW IN INPUT BOX.
					getInpData+=action;
					
					// SET VALUE TO THE INPUT BOX AND DEMO BOX
					m1.addAttribute("addInp",getInpData);
					m1.addAttribute("demo",result);
					
				} catch (Exception e) {
					m1.addAttribute("addInp",getInpData);
					m1.addAttribute("demo","Error");
				}
				
				
				
			}

		}
		// USER PERFORM = OPERATION
		if(action.equals("=")&&getInpData.length() !=0) {

			// REMOVE IF IT CONTAINS ANY OPERATION SYMBOL AT THE END
			if(getInpData.charAt(getInpData.length()-1)=='+'||getInpData.charAt(getInpData.length()-1)=='-'
					||getInpData.charAt(getInpData.length()-1)=='/'||getInpData.charAt(getInpData.length()-1)=='*'
					||getInpData.charAt(getInpData.length()-1)=='%'||getInpData.charAt(getInpData.length()-1)=='.') {
				getInpData = getInpData.substring(0,getInpData.length()-1);
			}

			// CALCULATE MULTIPLE OPERATION AT SINGLE TIME
			try {
				
				Expression expression = new ExpressionBuilder(getInpData).build();
				double result = expression.evaluate();
				// SET VALUE TO THE INPUT BOX
				m1.addAttribute("addInp",result);

				// CLEAR THE DEMO BOX
				m1.addAttribute("demo","");
				
			} catch (Exception e) {
				m1.addAttribute("addInp",getInpData);
				m1.addAttribute("demo","Error");
			}
		}
		
		return "index";
		
	}
	
	
}
