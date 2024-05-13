package com.java.payxpert.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.java.payxpert.dao.PayrollService;
import com.java.payxpert.model.Payroll;

public class GetPayrollsForPeriod {
	public static void main(String[] args) throws ParseException {
		int employeeid;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee payroll startdate..");
		String dateStr = sc.next();  
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		Date startdate = sdf.parse(dateStr);
		System.out.println("Enter employee payroll enddate..");
		String dateStr1 = sc.next();  
		Date enddate = sdf.parse(dateStr1);
		
		PayrollService p=new PayrollService();
		List<Payroll> payrollList;
		try {
			payrollList=p.GetPayrollsForPeriod(startdate,enddate);
			if(payrollList!=null) {
				for (Payroll payroll : payrollList) {
					System.out.println(payroll);
				}
			}
			if(payrollList.size()==0) {
				System.out.println("Records not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
