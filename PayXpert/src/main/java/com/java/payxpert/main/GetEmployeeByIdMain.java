package com.java.payxpert.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.payxpert.dao.EmployeeService;
import com.java.payxpert.model.Employee;

public class GetEmployeeByIdMain {
	public static void main(String[] args) {
		int emp_id;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee Id");
		emp_id=sc.nextInt();
		EmployeeService e=new EmployeeService();
		try {
			Employee employ = e.GetEmployeeById(emp_id);
			if(employ != null) {
			System.out.println("Employee details "+employ);
		    }
			else {
				System.out.println("*** Customer Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}

