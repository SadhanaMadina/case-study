package com.java.payxpert.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.payxpert.dao.EmployeeService;
import com.java.payxpert.model.Employee;

public class DeleteEmployeeMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee id..");
		int emp_id=sc.nextInt();
		EmployeeService e = new EmployeeService();
		
		try {
			String ans=e.RemoveEmployee(emp_id);
			if (ans!=null) {
				System.out.println(ans);
			}
			else {
				System.out.println("Record not found");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
