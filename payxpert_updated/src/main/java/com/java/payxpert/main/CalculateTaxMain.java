package com.java.payxpert.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.java.payxpert.dao.TaxService;

public class CalculateTaxMain {
	public static void main(String[] args) throws ParseException {
		int employee_id;
		String year;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter employee id..");
		employee_id=sc.nextInt();
		System.out.println("Enter taxyear..");
		year=sc.next();
		TaxService t =new TaxService();
		double a=-1;
		try {
			a=t.CalculateTax(employee_id, year);
			if (a == -1)
			{
				System.out.println("recotd not found");
			}
			else {
			System.out.println("Taxamount"+a);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
