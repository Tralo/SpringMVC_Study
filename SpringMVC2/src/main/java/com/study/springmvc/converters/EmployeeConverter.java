package com.study.springmvc.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.study.springmvc.crud.entity.Department;
import com.study.springmvc.crud.entity.Employee;
@Component
public class EmployeeConverter implements Converter<String, Employee>{
	public Employee convert(String source) {
		// <!-- lastname-email-gender-department.id -->
		Employee employee = new Employee();
		if(source != null){
			String[] vals = source.split("-");
			if(vals != null && vals.length == 4){
				employee.setLastName(vals[0]);
				employee.setEmail(vals[1]);
				employee.setGender(Integer.parseInt(vals[2]));
				Department department = new Department();
				department.setId(Integer.parseInt(vals[3]));
				employee.setDepartment(department);
				System.out.println("---- converter ----- ");
				return employee;
			}
			
		}
		
		return null;
	}
}
