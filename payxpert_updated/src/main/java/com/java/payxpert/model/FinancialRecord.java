package com.java.payxpert.model;

import java.util.Date;

public class FinancialRecord {
	private int RecordId;
	private int EmployeeId;
	private Date RecoedDate;
	private String Description;
	private double Amount;
	private String RecordType;
	public int getRecordId() {
		return RecordId;
	}
	public void setRecordId(int recordId) {
		RecordId = recordId;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public Date getRecordDate() {
		return RecoedDate;
	}
	public void setRecordDate(Date recoedDate) {
		RecoedDate = recoedDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public String getRecordType() {
		return RecordType;
	}
	public void setRecordType(String recordType) {
		RecordType = recordType;
	}
	public FinancialRecord(int recordId, int employeeId, Date recoedDate, String description, double amount,
			String recordType) {
		RecordId = recordId;
		EmployeeId = employeeId;
		RecoedDate = recoedDate;
		Description = description;
		Amount = amount;
		RecordType = recordType;
	}
	public FinancialRecord() {
		
	}
	@Override
	public String toString() {
		return "FinancialRecord [RecordId=" + RecordId + ", EmployeeId=" + EmployeeId + ", RecoedDate=" + RecoedDate
				+ ", Description=" + Description + ", Amount=" + Amount + ", RecordType=" + RecordType + "]";
	}
	
	
	
	
	
}
