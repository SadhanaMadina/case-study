package com.java.payxpert.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.payxpert.dao.FinancialRecordService;

public class AddFinancialRecordMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee id..");
		int e_id=sc.nextInt();
		System.out.println("Enter description..");
		String desc=sc.next();
		System.out.println("Enter amount..");
		double amount=sc.nextDouble();
		System.out.println("Enter record type..");
		String rt=sc.next();
		FinancialRecordService f= new FinancialRecordService();
		try {
			String s=f.AddFinancialRecord(e_id, desc, amount, rt);
			System.out.println(s);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

