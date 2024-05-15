package com.java.payxpert.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.java.payxpert.dao.EmployeeService;
import com.java.payxpert.model.Employee;

public class UpdateEmployeeMain {
	
	public static void main(String[] args) throws ParseException {
		Employee employ=null;
		 employ=new Employee();
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter employee id..");
		 employ.setEmployeeID(sc.nextInt());
		 System.out.println("Enter firstname..");
		 employ.setFirstName(sc.next());
		 System.out.println("Enter Lastname..");
		 employ.setLastName(sc.next());
		 System.out.println("Enter Gender..");
		 employ.setGender(sc.next());
		 System.out.println("Enter Email..");
		 employ.setEmail(sc.next());
		 System.out.println("Enter phone number..");
		 employ.setPhoneNumber(sc.next());
		 System.out.println("Enter Address..");
		 employ.setAddress(sc.next());
		 System.out.println("Enter position..");
		 employ.setPosition(sc.next());
		 System.out.println("Enter dob..");   
		 String dateStr = sc.next();  
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		 Date date = sdf.parse(dateStr);  
		 employ.setDateOfBirth(date);
		 System.out.println("Enter joining date..");
		 String joiningdateStr = sc.next();
		 Date joiningdate = sdf.parse(joiningdateStr); 
		 employ.setJoiningDate(joiningdate);
		 System.out.println("Enter termination date..");
		 String terminationdateStr = sc.next();
		 Date terminationdate = sdf.parse(terminationdateStr);  
		 employ.setTerminationDate(terminationdate);
		 EmployeeService e = new EmployeeService();
		 try {
			System.out.println(e.updateEmployee(employ));
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	}


