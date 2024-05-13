package com.java.payxpert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.java.payxpert.model.FinancialRecord;
import com.java.payxpert.util.DBConnUtil;
import com.java.payxpert.util.DBPropertyUtil;

public class FinancialRecordService implements IFinancialRecordService{
	Connection con;
	PreparedStatement pst;
	public int GenerateRecordId() throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="Select max(recordid)+1 rid from finance";
		pst=con.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		rs.next();
		int rid = rs.getInt("rid");
		return rid;
	}

	@Override
	public String AddFinancialRecord(int employeeId, String description, double amount, String recordType) throws ClassNotFoundException, SQLException {
		int a=GenerateRecordId();
		String connstr=DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="insert into finance (RecordID, EmployeeID, RecordDate, Descr, Amount, RecordType) values (?,?,?,?,?,?)";
		pst=con.prepareStatement(cmd);
		pst.setInt(1,a);
		pst.setInt(2, employeeId);
		pst.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
		pst.setString(4, description);
		pst.setDouble(5, amount);
		pst.setString(6, recordType);
		int rs=pst.executeUpdate();
		if(rs>0)
		{
			return "Inserted successfully";
		}
		else
		{
			return "Record not found";
		}
		
	}

	@Override
	public FinancialRecord GetFinancialRecordById(int recordId) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="select * from finance where recordid=?";
		pst=con.prepareStatement(cmd);
		pst.setInt(1, recordId);
		ResultSet rs=pst.executeQuery();
		FinancialRecord finance=null;
		if(rs.next())
		{
			finance = new FinancialRecord();
			finance.setRecordId(recordId);
			finance.setEmployeeId(rs.getInt("Employeeid"));
			finance.setRecordDate(rs.getDate("recorddate"));
			finance.setAmount(rs.getDouble("amount"));
			finance.setDescription(rs.getString("descr"));
			finance.setRecordType(rs.getString("recordtype"));
			
		}
		return finance;
	}

	@Override
	public List<FinancialRecord> GetFinancialRecordsForEmployee(int employeeId) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="select * from finance where employeeid=?";
		pst=con.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		ResultSet rs=pst.executeQuery();
		List<FinancialRecord> finList=new ArrayList<FinancialRecord>();
		FinancialRecord finance=null;
		while(rs.next())
		{
			finance = new FinancialRecord();
			finance.setRecordId(rs.getInt("recordid"));
			finance.setEmployeeId(employeeId);
			finance.setRecordDate(rs.getDate("recorddate"));
			finance.setAmount(rs.getDouble("amount"));
			finance.setDescription(rs.getString("descr"));
			finance.setRecordType(rs.getString("recordtype"));
			finList.add(finance);
		}
		return finList;
		
	}

	@Override
	public List<FinancialRecord> GetFinancialRecordsForDate(Date recordDate) throws ClassNotFoundException, SQLException {
		String connstr=DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="select * from finance where recorddate=?";
		pst=con.prepareStatement(cmd);
		pst.setDate(1, new java.sql.Date(recordDate.getTime()));
		ResultSet rs=pst.executeQuery();
		List<FinancialRecord> finList=new ArrayList<FinancialRecord>();
		FinancialRecord finance=null;
		while(rs.next())
		{
			finance = new FinancialRecord();
			finance.setRecordId(rs.getInt("recordid"));
			finance.setEmployeeId(rs.getInt("employeeid"));
			finance.setRecordDate(new java.sql.Date(recordDate.getTime()));
			finance.setAmount(rs.getDouble("amount"));
			finance.setDescription(rs.getString("descr"));
			finance.setRecordType(rs.getString("recordtype"));
			finList.add(finance);
		}
		return finList;
	}

}
