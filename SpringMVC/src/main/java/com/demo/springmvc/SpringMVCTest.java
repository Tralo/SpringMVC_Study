package com.demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	
	private static final String SUCCESS = "success";
	
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam(value="username") String um,@RequestParam(value="age", required=false,defaultValue="0") Integer age){
		System.out.println("testRequestParam: username = " + um + "  age=" + age);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRestPut/{id}",method=RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id){
		System.out.println("testRestPut: " + id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRestDelete/{id}",method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable Integer id){
		System.out.println("testRestDelete: " + id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest",method=RequestMethod.POST)
	public String testRest(){
		System.out.println("testRest POST");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.GET)
	public String testRest(@PathVariable Integer id){
		System.out.println("testRest GET: " + id);
		return SUCCESS;
	}
	
	
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id){
		System.out.println("testParamsAndHeaders: " + id);
		return SUCCESS;
	}
	
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
