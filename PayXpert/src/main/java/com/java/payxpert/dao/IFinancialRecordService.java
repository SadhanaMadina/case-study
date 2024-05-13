package com.java.payxpert.dao;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;

import com.java.payxpert.model.FinancialRecord;

public interface IFinancialRecordService {
	String AddFinancialRecord(int employeeId, String description,double  amount, String recordType) throws ClassNotFoundException, SQLException;
	FinancialRecord GetFinancialRecordById(int recordId) throws ClassNotFoundException, SQLException ;
	List<FinancialRecord>  GetFinancialRecordsForEmployee(int employeeId) throws ClassNotFoundException, SQLException;
	List<FinancialRecord> GetFinancialRecordsForDate(Date recordDate) throws ClassNotFoundException, SQLException;

}
