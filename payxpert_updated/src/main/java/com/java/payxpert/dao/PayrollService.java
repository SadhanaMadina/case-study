package com.java.payxpert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.java.payxpert.model.Payroll;
import com.java.payxpert.util.DBConnUtil;
import com.java.payxpert.util.DBPropertyUtil;

public class PayrollService implements IPayrollService{
	Connection con;
	PreparedStatement pst;

	@Override
	public Payroll GetPayrollById(int payrollId) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.ConnectionString("db");
		con = DBConnUtil.getConnection(connstr);
		String cmd="select * from payroll where payrollid=?";
		pst=con.prepareStatement(cmd);
		pst.setInt(1, payrollId);
		ResultSet rs=pst.executeQuery();
		Payroll payroll=null;
		if(rs.next()) {
			payroll=new Payroll();
			payroll.setPayrollID(payrollId);
			payroll.setEmployeeID(rs.getInt("employeeId"));
			payroll.setPayPeriodStartDate(rs.getDate("payperiodstartdate"));
			payroll.setPayPeriodEndDate(rs.getDate("payperiodenddate"));
			payroll.setBasicSalary(rs.getDouble("Basicsalary"));
			payroll.setOvertimePay(rs.getDouble("overtimepay"));
			payroll.setDeductions(rs.getDouble("deductions"));
			payroll.setNetSalary(rs.getDouble("netsalary"));
		}
		return payroll;
		
	}

	@Override
	public List<Payroll> GetPayrollsForEmployee(int employeeId) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.ConnectionString("db");
		con = DBConnUtil.getConnection(connstr);
		String cmd="select * from payroll where employeeid=?";
		pst=con.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		ResultSet rs=pst.executeQuery();
		List<Payroll> payrollList = new ArrayList<Payroll>();
		Payroll payroll=null;
		while(rs.next()) {
			payroll=new Payroll();
			payroll.setPayrollID(employeeId);
			payroll.setEmployeeID(rs.getInt("employeeId"));
			payroll.setPayPeriodStartDate(rs.getDate("payperiodstartdate"));
			payroll.setPayPeriodEndDate(rs.getDate("payperiodenddate"));
			payroll.setBasicSalary(rs.getDouble("Basicsalary"));
			payroll.setOvertimePay(rs.getDouble("overtimepay"));
			payroll.setDeductions(rs.getDouble("deductions"));
			payroll.setNetSalary(rs.getDouble("netsalary"));
			payrollList.add(payroll);
		}
		return payrollList;
		
	}

	@Override
	public List<Payroll> GetPayrollsForPeriod(Date startdate, Date enddate) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.ConnectionString("db");
		con = DBConnUtil.getConnection(connstr);
		String cmd="select * from payroll where payperiodstartdate=? and payperiodenddate=? ";
		pst=con.prepareStatement(cmd);
		pst.setDate(1, new java.sql.Date(startdate.getTime()));
		pst.setDate(2, new java.sql.Date(enddate.getTime()));
		ResultSet rs=pst.executeQuery();
		List<Payroll> payrollList = new ArrayList<Payroll>();
		Payroll payroll=null;
		while(rs.next()) {
			payroll=new Payroll();
			payroll.setPayrollID(rs.getInt("payrollid"));
			payroll.setEmployeeID(rs.getInt("employeeId"));
			payroll.setPayPeriodStartDate(startdate);
			payroll.setPayPeriodEndDate(enddate);
			payroll.setBasicSalary(rs.getDouble("Basicsalary"));
			payroll.setOvertimePay(rs.getDouble("overtimepay"));
			payroll.setDeductions(rs.getDouble("deductions"));
			payroll.setNetSalary(rs.getDouble("netsalary"));
			payrollList.add(payroll);
		}
		return payrollList;
		
		
	}

	@Override
	public List<Payroll> GeneratePayroll(int employeeId, Date startDate, Date endDate)
			throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.ConnectionString("db");
		con = DBConnUtil.getConnection(connstr);
		String cmd="select * from payroll where employeeid= ? and payperiodstartdate=? and payperiodenddate=? ";
		pst=con.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		pst.setDate(2, new java.sql.Date(startDate.getTime()));
		pst.setDate(3, new java.sql.Date(endDate.getTime()));
		ResultSet rs=pst.executeQuery();
		List<Payroll> payrollList = new ArrayList<Payroll>();
		Payroll payroll=null;
		while(rs.next()) {
			payroll=new Payroll();
			payroll.setPayrollID(rs.getInt("payrollid"));
			payroll.setEmployeeID(employeeId);
			payroll.setPayPeriodStartDate(startDate);
			payroll.setPayPeriodEndDate(endDate);
			payroll.setBasicSalary(rs.getDouble("Basicsalary"));
			payroll.setOvertimePay(rs.getDouble("overtimepay"));
			payroll.setDeductions(rs.getDouble("deductions"));
			payroll.setNetSalary(rs.getDouble("netsalary"));
			payrollList.add(payroll);
		}
		return payrollList;
	}

	
	
	

}
