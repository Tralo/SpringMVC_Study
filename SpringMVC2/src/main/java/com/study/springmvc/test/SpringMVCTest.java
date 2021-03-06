package com.study.springmvc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.study.springmvc.crud.dao.EmployeeDao;
import com.study.springmvc.crud.entity.Employee;


@Controller
public class SpringMVCTest {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="测试")
	@RequestMapping("testResponseStatusExceptionResolver")
	public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
		if(i == 13){
			throw new UserNameNotMatchPasswordException();
		}
		System.out.println("正常执行");
		
		return "success";
	}
	
	
	/*@ExceptionHandler({RuntimeException.class})
	public ModelAndView handleRuntimeException(Exception ex){
		System.out.println("[出异常了]:  " + ex);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception",ex);
		return mv;
	}
	
	 * 1. 在 @ExceptionHandler 方法的入参中可以加入 Exception 类型的参数，该参数即对应发生的异常对象
	 * 2. 在 @ExceptionHandler 方法的入参中不能传入 Map，若希望把异常信息传到页面上，需要使用 ModelAndView 作为返回值
	 * 3. 在 @ExceptionHandler 方法标记的异常有优先级之分
	 * 4. @ControllerAdvice 如果在当前 Handler 中找不到 @ExceptionHandler 方法来处理当前的异常
	 * 则将去 @ControllerAdvice 标记的类中 @ExceptionHandler标记的方法来处理异常
	 * @param ex
	 * @param map
	 * @return
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handleArithmeticException(Exception ex){
		System.out.println("出异常了:  " + ex);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception",ex);
		return mv;
	}
	*/
	
	@RequestMapping("testExceptionHandlerExceptionResolver")
	public String testExceptionHandlerExceptionResolver(@RequestParam("i")int i){
		System.out.println("result:  " + (10 / i));
		return "success";
	}
	
	
	@RequestMapping("/testFileUpload")
	public String testFileUpload(@RequestParam("desc") String desc, @RequestParam(value= "file", required = false) MultipartFile file) throws IOException{
		System.out.println("desc:  " + desc);
		System.out.println("OriginalFilename:  " + file.getOriginalFilename());
		System.out.println("InputStream:   " + file.getInputStream());
		return "success";
	}
	
	
	@RequestMapping("/i18n")
	private String testI18n(Locale locale){
		String val = messageSource.getMessage("i18n.user", null,locale);
		System.out.println("val:  " + val);
		return "i18n";
	}
	
	
	@RequestMapping("/testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
		byte[] body = null;
		ServletContext servletContext = session.getServletContext();
		InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
		body = new byte[in.available()];
		in.read(body);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=abc.txt");
		
		HttpStatus statusCode = HttpStatus.OK;
		
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}
	
	@ResponseBody
	@RequestMapping("/testHttpMessageConverter")
	public String testHttpMessageConverter(@RequestBody String body){
		System.out.println(body);
		return "hello ! " + new Date();
	}
	
	
	
	
	
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
