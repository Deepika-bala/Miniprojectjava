package com.deepi.miniproject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Transaction {
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="account_number")
	private Bank_Account acc;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transaction_id;
	private float transaction_amount;
	private String transaction_type;
	private Date transaction_date;
	private String transaction_status;
	private Date created_up;
	private Date updated_up;
	private float balance;
	
	public Bank_Account getAcc() {
		return acc;
	}
	public void setAcc(Bank_Account acc) {
		this.acc = acc;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
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
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	

}
