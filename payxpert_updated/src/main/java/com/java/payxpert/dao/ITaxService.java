package com.java.payxpert.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.payxpert.model.Tax;

public interface ITaxService {
	double CalculateTax(int employeeId, String taxYear) throws ClassNotFoundException, SQLException;
	double GetTaxById(int taxId) throws ClassNotFoundException, SQLException;
	List<Tax>  GetTaxesForEmployee(int employeeId) throws ClassNotFoundException, SQLException ;
	List<Tax> GetTaxesForYear(String taxYear) throws ClassNotFoundException, SQLException;

}