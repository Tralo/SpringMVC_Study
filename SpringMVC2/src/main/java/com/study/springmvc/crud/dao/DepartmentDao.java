package com.study.springmvc.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.study.springmvc.crud.entity.Department;

@Repository
public class DepartmentDao {
	private static Map<Integer,Department> deparments = null;
	static{
		deparments = new HashMap<Integer, Department>();
		
		deparments.put(101, new Department(101, "D-AA"));
		deparments.put(101, new Department(102, "D-BB"));
		deparments.put(101, new Department(103, "D-CC"));
		deparments.put(101, new Department(104, "D-DD"));
		deparments.put(101, new Department(105, "D-EE"));
		
	}
	
	public Collection<Department> getDeparments() {
		return deparments.values();
	}
	public Department getDepartment(Integer id) {
		return deparments.get(id);
	}
	
	
	
}
