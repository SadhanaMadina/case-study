package com.java.payxpert.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.payxpert.dao.FinancialRecordService;
import com.java.payxpert.model.FinancialRecord;

public class GetFinancialRecordByIdMain {
	public static void main(String[] args) {
		FinancialRecord finance=null;
		FinancialRecordService f= new FinancialRecordService();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter record id..");
		int record_id = sc.nextInt();
		try {
			finance=f.GetFinancialRecordById(record_id);
			if(finance!=null)
			{
				System.out.println(finance);
			}
			else
			{
				System.out.println("Record not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
