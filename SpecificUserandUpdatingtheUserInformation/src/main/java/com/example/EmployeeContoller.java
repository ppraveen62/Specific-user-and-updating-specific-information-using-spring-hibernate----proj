package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeContoller {
	
	public static String id;
	
	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		
		Employee e=ac.getBean(Employee.class);
		EmployeeDao edao=ac.getBean(EmployeeDao.class);
		List<Employee> elist=edao.getallemployees();
		System.out.println(elist);
		mv.setViewName("display.jsp");
		mv.addObject("list", elist);
		
		id=request.getParameter("eid");
		
		return mv;

	
	}
	
	
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		
		Employee e=ac.getBean(Employee.class);
		EmployeeDao edao=ac.getBean(EmployeeDao.class);
		
		e.setEname(request.getParameter("ename"));
		e.setEmail(request.getParameter("eemail"));
		e.setEid(Integer.parseInt(request.getParameter("eid")));
		
	
		int row=edao.update(e);
		if(row>0) {
			mv.setViewName("index.jsp");
	
		}
		
		return mv;

	}
}
		
		


