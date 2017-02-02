package com.study.springmvc.test;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.crud.dao.EmployeeDao;
import com.study.springmvc.crud.entity.Employee;


@Controller
public class SpringMVCTest {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	
	@RequestMapping(value="/testConversionServiceConverter")
	public String testConverter(@RequestParam("employee") Employee employee){
		System.out.println("save:  " + employee);
		employeeDao.save(employee);
		
		return "redirect:/emps";
	}
	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson(){
		
		return employeeDao.getAll();
	}
	
}
