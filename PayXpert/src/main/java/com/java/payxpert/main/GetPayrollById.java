package com.java.payxpert.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.payxpert.dao.PayrollService;
import com.java.payxpert.model.Payroll;

public class GetPayrollById {
	public static void main(String[] args) {
		int payroll_id;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter payroll id..");
		payroll_id=sc.nextInt();
		PayrollService p = new PayrollService();
		try {
			Payroll payroll=p.GetPayrollById(payroll_id);
			if(payroll != null) {
				System.out.println("payroll details.."+payroll);
			}
			else {
				System.out.println("Record not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
