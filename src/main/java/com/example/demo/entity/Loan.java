package com.example.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {
	  @Id
	    private String id;
	    private BigDecimal loanAmount;
	    private BigDecimal interestRate;
	    private int months;
	    private BigDecimal emi;
	    private String status;

	    @ManyToOne
	    @JoinColumn(name = "account_id")
	    private Account account;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public BigDecimal getLoanAmount() {
			return loanAmount;
		}

		public void setLoanAmount(BigDecimal loanAmount) {
			this.loanAmount = loanAmount;
		}

		public BigDecimal getInterestRate() {
			return interestRate;
		}

		public void setInterestRate(BigDecimal interestRate) {
			this.interestRate = interestRate;
		}

		public int getMonths() {
			return months;
		}

		public void setMonths(int months) {
			this.months = months;
		}

		public BigDecimal getEmi() {
			return emi;
		}

		public void setEmi(BigDecimal emi) {
			this.emi = emi;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Account getAccount() {
			return account;
		}

		public void setAccount(Account account) {
			this.account = account;
		}


}
