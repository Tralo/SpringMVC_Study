package com.demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	
	private static final String SUCCESS = "success";
	/**
	 * 1. @RequestMapping 除了修饰方法，还可以修饰类
	 * @return
	 */
	
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		
		System.out.println("testRequestMapping");
		return SUCCESS;
	}
	
	
	
}
