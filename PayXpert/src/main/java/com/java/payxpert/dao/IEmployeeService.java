package com.java.payxpert.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.payxpert.model.Employee;

public interface IEmployeeService {
	Employee GetEmployeeById(int employeeId) throws ClassNotFoundException, SQLException;
	List<Employee> GetAllEmployees() throws ClassNotFoundException, SQLException;
	String AddEmployee(Employee employ) throws SQLException, ClassNotFoundException;
	String updateEmployee(Employee employ) throws ClassNotFoundException, SQLException;
	String RemoveEmployee(int employeeId) throws ClassNotFoundException, SQLException;
	

}
