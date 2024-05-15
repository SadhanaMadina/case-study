package com.java.payxpert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.payxpert.model.Payroll;
import com.java.payxpert.model.Tax;
import com.java.payxpert.util.DBConnUtil;
import com.java.payxpert.util.DBPropertyUtil;

public class TaxService implements ITaxService{
	Connection con;
	PreparedStatement pst;

	@Override
	public double CalculateTax(int employeeId, String taxyear) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd1="select netsalary from payroll where employeeid=?";
		pst=con.prepareStatement(cmd1);
		pst.setInt(1, employeeId);
		ResultSet rs=pst.executeQuery();
		Payroll payroll=null;
		if(rs.next()) {
			payroll=new Payroll();
			payroll.setNetSalary(rs.getDouble("netsalary"));

		}
	    String cmd2="select taxableincome from tax where employeeid=? and taxyear=?";
	    pst=con.prepareStatement(cmd2);
	    pst.setInt(1, employeeId);
	    pst.setString(2, taxyear);
	    Tax tax=null;
	    rs=pst.executeQuery();
		if(rs.next()) {
			tax=new Tax();
			tax.setTaxableIncome(rs.getDouble("taxableincome"));
		}
		
		return payroll.getNetSalary()-tax.getTaxableIncome();
	}

	@Override
	public double GetTaxById(int taxId) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="select employeeid,taxyear from tax where taxid=?";
		pst=con.prepareStatement(cmd);
		pst.setInt(1, taxId);
		ResultSet rs=pst.executeQuery();
		double a=-1;
		Tax tax=null;
		if(rs.next())
		{
			tax=new Tax();
			tax.setEmployeeId(rs.getInt("employeeid"));
			tax.setTaxYear(rs.getString("taxyear"));
			 int x=tax.getEmployeeId();
			 String y=tax.getTaxYear();
			 return CalculateTax(x, y);
		}
		return a;
		
	}

	@Override
	public List<Tax> GetTaxesForEmployee(int employeeId) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="select * from tax where employeeid=?";
		pst=con.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		ResultSet rs=pst.executeQuery();
		List<Tax> taxList=new ArrayList<Tax>();
		Tax tax=null;
		while(rs.next()) {
			tax=new Tax();
			tax.setEmployeeId(employeeId);
			tax.setTaxID(rs.getInt("taxid"));
			tax.setTaxYear(rs.getString("taxyear"));
			tax.setTaxableIncome(rs.getDouble("taxableincome"));
			tax.setTaxAmount(CalculateTax(employeeId, rs.getString("taxyear")));
			taxList.add(tax);
		}
		return taxList;
	}

	@Override
	public List<Tax> GetTaxesForYear(String taxYear) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="select * from tax where taxyear=?";
		pst=con.prepareStatement(cmd);
		pst.setString(1, taxYear);
		ResultSet rs=pst.executeQuery();
		List<Tax> taxList=new ArrayList<Tax>();
		Tax tax=null;
		while(rs.next()) {
			tax=new Tax();
			tax.setEmployeeId(rs.getInt("employeeid"));
			tax.setTaxID(rs.getInt("taxid"));
			tax.setTaxYear(taxYear);
			tax.setTaxableIncome(rs.getDouble("taxableincome"));
			tax.setTaxAmount(CalculateTax(rs.getInt("employeeid"), rs.getString("taxyear")));
			taxList.add(tax);
		}
		return taxList;
		
		
	}

}
