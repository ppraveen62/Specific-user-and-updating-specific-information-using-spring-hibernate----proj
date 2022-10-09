package com.example;
import com.example.Employee;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sun.net.httpserver.Request;

public class EmployeeDao {
	
	private HibernateTemplate temp;

	public void setTemp(HibernateTemplate temp) {
		this.temp = temp;
	}
	

	

	
	//search
		public List<Employee> getallemployees(){
			String sql="from Employee";
			return (List<Employee>) temp.find(sql);
			
		}
	//update
	public int update(Employee e) {
		temp.update(e);
		return 1;
			
		}

}
