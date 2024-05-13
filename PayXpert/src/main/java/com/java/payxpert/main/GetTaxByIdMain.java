package com.java.payxpert.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.payxpert.dao.TaxService;

public class GetTaxByIdMain {
	public static void main(String[] args) {
		int tax_id;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter taxid..");
		tax_id=sc.nextInt();
		TaxService t=new TaxService();
		try {
			double ans=t.GetTaxById(tax_id);
			if(ans==-1)
			{
				System.out.println("Record not found");
			}
			else
			{
				System.out.println("Tax Amount is "+ans);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
