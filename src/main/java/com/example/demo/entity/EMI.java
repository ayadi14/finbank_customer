package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
	public class EMI {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private LocalDateTime dueDate;
	    private String status;
	    private BigDecimal emiAmount;

	    @ManyToOne
	    @JoinColumn(name = "loan_id")
	    private Loan loan;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getDueDate() {
			return dueDate;
		}

		public void setDueDate(LocalDateTime dueDate) {
			this.dueDate = dueDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public BigDecimal getEmiAmount() {
			return emiAmount;
		}

		public void setEmiAmount(BigDecimal emiAmount) {
			this.emiAmount = emiAmount;
		}

		public Loan getLoan() {
			return loan;
		}

		public void setLoan(Loan loan) {
			this.loan = loan;
		}
	    
}
