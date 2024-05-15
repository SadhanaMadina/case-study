package com.java.payxpert.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.payxpert.dao.TaxService;
import com.java.payxpert.model.Tax;

public class GetTaxesForYearMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter taxyear..");
		String tax_year=sc.next();
		TaxService t=new TaxService();
		List<Tax> taxList= null;
		try {
			taxList= t.GetTaxesForYear(tax_year);
			if(taxList != null)
			{
				for (Tax tax : taxList) {
					System.out.println(tax);
				}
			}
			if(taxList.size()==0) {
				System.out.println("record not found..");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
