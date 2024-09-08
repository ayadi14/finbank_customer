package com.example.demo.dto;

public class TransactionMessageDto {
    private String transactionId;
    private String timestamp;
    private String fromAccountNumber;
    private String toAccountNumber;
    private String message;
    private String transactionType;
    private String status;
    private String statusCode;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public String getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public TransactionMessageDto(String transactionId, String timestamp, String fromAccountNumber,
			String toAccountNumber, String message, String transactionType, String status, String statusCode) {
		super();
		this.transactionId = transactionId;
		this.timestamp = timestamp;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.message = message;
		this.transactionType = transactionType;
		this.status = status;
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "TransactionMessageDto [transactionId=" + transactionId + ", timestamp=" + timestamp
				+ ", fromAccountNumber=" + fromAccountNumber + ", toAccountNumber=" + toAccountNumber + ", message="
				+ message + ", transactionType=" + transactionType + ", status=" + status + ", errorCode=" + statusCode
				+ "]";
	}
	
    
}