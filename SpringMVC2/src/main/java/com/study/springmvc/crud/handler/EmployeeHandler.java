package com.study.springmvc.crud.handler;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springmvc.crud.dao.DepartmentDao;
import com.study.springmvc.crud.dao.EmployeeDao;
import com.study.springmvc.crud.entity.Employee;

@Controller
public class EmployeeHandler {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map) {
		if(id != null){
			map.put("employee", employeeDao.get(id));
		}
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	private String input(@PathVariable("id") Integer id, Map<String, Object> map){
		map.put("departments", departmentDao.getDeparments());
		map.put("employee", employeeDao.get(id));
		return "input";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String save(@Valid Employee employee,BindingResult result,Map<String, Object> map){
		System.out.println("save employee:   " + employee);
		if(result.getErrorCount() > 0){
			System.out.println("出错了");
			for(FieldError error : result.getFieldErrors()){
				System.out.println(error.getField() + " :  " + error.getDefaultMessage());
			}
			// 若验证出错，则转向定制的页面
			map.put("departments", departmentDao.getDeparments());
			return "input";
		}
		
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String, Object> map){
		map.put("departments", departmentDao.getDeparments());
		map.put("employee", new Employee());
		return "input";
	}
	
	@RequestMapping("/emps")
	public String list(Map<String, Object> map){
		map.put("employees", employeeDao.getAll());
		return "list";
	}
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		binder.setDisallowedFields("lastName");
//	}
	
}
