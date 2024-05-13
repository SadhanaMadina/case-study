package com.java.payxpert.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.java.payxpert.model.Payroll;

public interface IPayrollService {
	List<Payroll> GeneratePayroll(int employeeId,Date startDate, Date endDate) throws ClassNotFoundException, SQLException;
	Payroll GetPayrollById(int payrollId) throws ClassNotFoundException, SQLException;
	List<Payroll>  GetPayrollsForEmployee(int employeeId) throws ClassNotFoundException, SQLException;
	List<Payroll> GetPayrollsForPeriod(Date startDate,Date endDate) throws ClassNotFoundException, SQLException;
	
	

}
