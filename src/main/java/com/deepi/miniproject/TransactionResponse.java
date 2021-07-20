package com.deepi.miniproject;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
public class TransactionResponse {
private int transaction_id;


private int acc;


private float transaction_amount;

private String transaction_type;



private float balance;

private Date transaction_date;


private String transaction_status;

private Date created_up ;
private Date updated_up ;
public int getTransaction_id() {
	return transaction_id;
}
public void setTransaction_id(int transaction_id) {
	this.transaction_id = transaction_id;
}
public int getAcc() {
	return acc;
}
public void setAcc(int acc) {
	this.acc = acc;
}
public float getTransaction_amount() {
	return transaction_amount;
}
public void setTransaction_amount(float transaction_amount) {
	this.transaction_amount = transaction_amount;
}
public String getTransaction_type() {
	return transaction_type;
}
public void setTransaction_type(String transaction_type) {
	this.transaction_type = transaction_type;
}
public float getBalance() {
	return balance;
}
public void setBalance(float balance) {
	this.balance = balance;
}
public Date getTransaction_date() {
	return transaction_date;
}
public void setTransaction_date(Date transaction_date) {
	this.transaction_date = transaction_date;
}
public String getTransaction_status() {
	return transaction_status;
}
public void setTransaction_status(String transaction_status) {
	this.transaction_status = transaction_status;
}
public Date getCreated_up() {
	return created_up;
}
public void setCreated_up(Date created_up) {
	this.created_up = created_up;
}
public Date getUpdated_up() {
	return updated_up;
}
public void setUpdated_up(Date updated_up) {
	this.updated_up = updated_up;
}
}