package com.java.payxpert.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.java.payxpert.dao.FinancialRecordService;
import com.java.payxpert.model.FinancialRecord;

public class GetFinancialRecordsForDateMain {
	public static void main(String[] args) throws ParseException {
		List<FinancialRecord> finList=null;
		FinancialRecordService f= new FinancialRecordService();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter record date..");
		String str = sc.next();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		Date recorddate = sdf.parse(str);
		try {
			finList=f.GetFinancialRecordsForDate(recorddate);
			if(finList!=null)
			{
				for (FinancialRecord financialRecord : finList) {
					System.out.println(financialRecord);
				}
			}
			if(finList.size()==0)
			{
				System.out.println("Record not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
