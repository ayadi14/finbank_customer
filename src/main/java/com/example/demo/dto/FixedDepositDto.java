package com.example.demo.dto;

import java.math.BigDecimal;

public class FixedDepositDto {
//FixedDepositDTO.java
 
 private Long accountNumber;              // User ID for identifying the account holder
 private BigDecimal depositAmount; // Deposit amount for the fixed deposit
 private Integer depositPeriod; 
 private Float rateOfIntrest;
public Long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(Long accountNumber) {
	this.accountNumber = accountNumber;
}
public BigDecimal getDepositAmount() {
	return depositAmount;
}
public void setDepositAmount(BigDecimal depositAmount) {
	this.depositAmount = depositAmount;
}
public Integer getDepositPeriod() {
	return depositPeriod;
}
public void setDepositPeriod(Integer depositPeriod) {
	this.depositPeriod = depositPeriod;
}
public Float getRateOfIntrest() {
	return rateOfIntrest;
}
public void setRateOfIntrest(Float rateOfIntrest) {
	this.rateOfIntrest = rateOfIntrest;
}
 
}
