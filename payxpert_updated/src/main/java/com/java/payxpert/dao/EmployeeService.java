package com.java.payxpert.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.payxpert.model.Employee;
import com.java.payxpert.util.DBConnUtil;
import com.java.payxpert.util.DBPropertyUtil;


public class EmployeeService implements IEmployeeService{
	Connection con;
	PreparedStatement pst;

	public int GenerateEmployeeId() throws ClassNotFoundException, SQLException {
		String connstr = DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="select max(employeeid)+1 eid from employee";
		pst=con.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		rs.next();
		int eid = rs.getInt("eid");
		return eid;
	}

	@Override
	public Employee GetEmployeeById(int employeeId) throws ClassNotFoundException, SQLException {
		String connstr = DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="select * from Employee where employeeid=?";
		pst=con.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		ResultSet rs=pst.executeQuery();
		Employee employ = null;
		if(rs.next()) {
			employ = new Employee();
			employ.setEmployeeID(rs.getInt("employeeId"));
			employ.setFirstName(rs.getString("FirstName"));
			employ.setLastName(rs.getString("LastName"));
			employ.setPhoneNumber(rs.getString("phonenumber"));
			employ.setEmail(rs.getString("Email"));
			employ.setAddress(rs.getString("Address"));
			employ.setDateOfBirth(rs.getDate("dob"));
			employ.setGender(rs.getString("Gender"));
			employ.setPosition(rs.getString("Position"));
			employ.setJoiningDate(rs.getDate("JoiningDate"));
			employ.setTerminationDate(rs.getDate("TerminationDate"));
			
		}
		return employ;
	}

	@Override
	public List<Employee> GetAllEmployees() throws ClassNotFoundException, SQLException {
		
		String connstr = DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="select * from Employee";
		pst=con.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		List<Employee> employList = new ArrayList<Employee>();
		Employee employ = null;
		while(rs.next()) {
			employ=new Employee();
			employ.setEmployeeID(rs.getInt("employeeId"));
			employ.setFirstName(rs.getString("FirstName"));
			employ.setLastName(rs.getString("LastName"));
			employ.setPhoneNumber(rs.getString("phonenumber"));
			employ.setEmail(rs.getString("Email"));
			employ.setAddress(rs.getString("Address"));
			employ.setDateOfBirth(rs.getDate("dob"));
			employ.setGender(rs.getString("Gender"));
			employ.setPosition(rs.getString("Position"));
			employ.setJoiningDate(rs.getDate("JoiningDate"));
			employ.setTerminationDate(rs.getDate("TerminationDate"));
			employList.add(employ);
		}
		return employList;
	}

	@Override
	public String AddEmployee(Employee employ) throws SQLException, ClassNotFoundException {
		int emp_id=GenerateEmployeeId();
		String connstr = DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="insert into employee(employeeid,firstname,lastname,phonenumber,email,address,gender,position,dob,joiningdate,TerminationDate) values"
				+"(?,?,?,?,?,?,?,?,?,?,?)";
		pst=con.prepareStatement(cmd);
		pst.setInt(1, emp_id);
		pst.setString(2,employ.getFirstName());
		pst.setString(3, employ.getLastName());
		pst.setString(7, employ.getGender());
		pst.setString(4, employ.getPhoneNumber());
		pst.setString(5, employ.getEmail());
		pst.setString(8 , employ.getPosition());
		pst.setString(6 , employ.getAddress());
		pst.setDate(9, new java.sql.Date(employ.getDateOfBirth().getTime()));
		pst.setDate(10, new java.sql.Date(employ.getJoiningDate().getTime()));
		pst.setDate(11,new java.sql.Date(employ.getTerminationDate().getTime()));
		pst.executeUpdate();
		return "Inserted Successfully..";
		
		
	}

	@Override
	public String updateEmployee(Employee employ) throws ClassNotFoundException, SQLException {
		String connstr = DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="update employee set firstname=?,lastname=?,gender=?,phonenumber=?,email=?,position=?,address=?,dob=?,joiningdate=?,terminationdate=? where employeeid=?";
		pst=con.prepareStatement(cmd);
		pst.setInt(11, employ.getEmployeeID());
		pst.setString(1,employ.getFirstName());
		pst.setString(2, employ.getLastName());
		pst.setString(3, employ.getGender());
		pst.setString(4, employ.getPhoneNumber());
		pst.setString(5, employ.getEmail());
		pst.setString(6 , employ.getPosition());
		pst.setString(7 , employ.getAddress());
		pst.setDate(8, new java.sql.Date(employ.getDateOfBirth().getTime()));
		pst.setDate(9, new java.sql.Date(employ.getJoiningDate().getTime()));
		pst.setDate(10,new java.sql.Date(employ.getTerminationDate().getTime()));
		int a=pst.executeUpdate();
		if(a>0)
		{
		return "updated Successfully..";
		}
		else {
			return "record not found";
		}
		
		
	}

	@Override
	public String RemoveEmployee(int employeeId) throws ClassNotFoundException, SQLException {
		String connstr = DBPropertyUtil.ConnectionString("db");
		con=DBConnUtil.getConnection(connstr);
		String cmd="delete from Employee where employeeid=?";
		pst=con.prepareStatement(cmd);
		pst.setInt(1, employeeId);
		int a=pst.executeUpdate();
		if(a>0) {
		return "Deleted successfully..";
		}
		else {
			return "record not found";
		}
	}

}


