package com.demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	
	private static final String SUCCESS = "success";
	
	@RequestMapping("/testAntPath/*/abc")
	public String testAntPath(){
		System.out.println("testAntPath");
		return SUCCESS;
	}
	
	@RequestMapping(value="testParamsAndHeaders",params={"username","age!=10"})
	public String testParamsAndHeaders(){
		System.out.println("testParamsAndHeaders");
		return SUCCESS;
	}
	
	/**
	 * 使用 method 属性来指定 请求方式
	 * @return
	 */
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("testMethod");
		return SUCCESS;
	}
	
	/**
	 * @RequestMapping 除了修饰方法，还可以修饰类
	 * @return
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		
		System.out.println("testRequestMapping");
		return SUCCESS;
	}
	
	
	
}
