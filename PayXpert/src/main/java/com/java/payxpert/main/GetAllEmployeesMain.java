package com.java.payxpert.main;

import java.sql.SQLException;
import java.util.List;

import com.java.payxpert.dao.EmployeeService;
import com.java.payxpert.model.Employee;

public class GetAllEmployeesMain {
	public static void main(String[] args) {
		EmployeeService e= new EmployeeService();
		try {
			List<Employee> employList =  e.GetAllEmployees();
			if(employList != null) {
				for (Employee employee : employList) {
					System.out.println(employee);
				}
			}
			else {
				System.out.println("No records");
			}
				
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
