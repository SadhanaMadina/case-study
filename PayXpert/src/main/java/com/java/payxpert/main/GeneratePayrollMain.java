package com.java.payxpert.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.java.payxpert.dao.PayrollService;
import com.java.payxpert.model.Payroll;

public class GeneratePayrollMain {
	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employeeid..");
		int emp_id=sc.nextInt();
		System.out.println("Enter payperiod startdate..");
		String sd=sc.next();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date str=sdf.parse(sd);
		System.out.println("Enter payperiod endate..");
		String sd1=sc.next();
		Date str1=sdf.parse(sd1);
		PayrollService p= new PayrollService();
		List<Payroll> payrollList = new ArrayList<Payroll>();
		try {
			payrollList =  p.GeneratePayroll(emp_id, str, str1);
			if(payrollList.size()>0) {
			for (Payroll payroll : payrollList) {
				System.out.println(payroll);
			  }
			}
		   if(payrollList.size()==0)
			{
				System.out.println("Record not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
