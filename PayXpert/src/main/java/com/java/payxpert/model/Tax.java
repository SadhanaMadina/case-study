package com.java.payxpert.model;



public class Tax {
	private int taxID;
	private int employeeId;
	private String taxYear;
	private double taxableIncome;
	private double taxAmount;
	public int getTaxID() {
		return taxID;
	}
	public void setTaxID(int taxID) {
		this.taxID = taxID;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}
	public double getTaxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	@Override
	public String toString() {
		return "Tax [taxID=" + taxID + ", employeeId=" + employeeId + ", taxYear=" + taxYear + ", taxableIncome="
				+ taxableIncome + ", taxAmount=" + taxAmount + "]";
	}
	public Tax() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tax(int taxID, int employeeId, String taxYear, double taxableIncome, double taxAmount) {
		super();
		this.taxID = taxID;
		this.employeeId = employeeId;
		this.taxYear = taxYear;
		this.taxableIncome = taxableIncome;
		this.taxAmount = taxAmount;
	}
	
}
