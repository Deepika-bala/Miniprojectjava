package com.deepi.miniproject;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
	@Autowired
	BankRes data;
	@Autowired
	TransactionRes datar;

	@PostMapping("/map")
	public Bank_Account addacc(@Valid@RequestBody Bank_Account a) {
		Date d = new Date();
		a.setCreated_at(d);
		a.setUpdated_at(d);
	    data.save(a);
	    return a;
	}
	
	@PostMapping("/{account_number}")
	public TransactionResponse postTransaction (@RequestBody TransactionRequest obj,@PathVariable int account_number) {
		Transaction trs=new Transaction();
		trs.setTransaction_amount(obj.getTransaction_amount());
		trs.setTransaction_type(obj.getTransaction_type());
		Optional<Bank_Account> ob2=data.findById(account_number);
    	Bank_Account getobj3=ob2.get();
    	trs.setAcc(getobj3);
    	float balance = getobj3.getBalance();
    	trs.setTransaction_amount(balance);
        trs.setTransaction_status("FAILURE");
        float newbalance;
        
    	if(obj.getTransaction_type().equals("WITHDRAW")) {
    		newbalance = balance-trs.getTransaction_amount();
    		trs.setBalance(newbalance);
    		trs.getAcc().setBalance(newbalance);
    		trs.setTransaction_status("SUCCESS");

		}else if(obj.getTransaction_type().equals("DEPOSIT")) {
			newbalance = balance+trs.getTransaction_amount();
			trs.setBalance(newbalance);
    		trs.getAcc().setBalance(newbalance);
    		trs.setTransaction_status("SUCCESS");
			
		}else {
			trs.setTransaction_status("FAIL");
			
			
		}
    	
		Date date= new Date();
        trs.setTransaction_date(date);
        trs.setCreated_up(date);
        trs.setUpdated_up(date);	
        datar.save(trs);  
    	TransactionResponse tr = new TransactionResponse();
    	tr.setTransaction_id(trs.getTransaction_id());
    	tr.setAcc(account_number);
    	tr.setTransaction_amount(trs.getTransaction_amount());
    	tr.setTransaction_type(trs.getTransaction_type());
    	tr.setBalance(trs.getBalance());
    	tr.setTransaction_date(trs.getTransaction_date());
    	tr.setTransaction_status(trs.getTransaction_status());
    	tr.setCreated_up(trs.getCreated_up());
    	tr.setUpdated_up(trs.getUpdated_up());
        return tr;
	}
	@GetMapping("/gettran/{account_number}")
	public GetResponse gettransaction(@PathVariable int account_number) {
		Optional<Bank_Account> ob2=data.findById(account_number);
		Bank_Account ba = ob2.get();
		List<Transaction> t = datar.getTran(account_number);
		GetResponse gr = new GetResponse();
		gr.setAccount_number(ba.getAccount_number());
		gr.setAccount_holdername(ba.getAccount_holdername());
		gr.setDob(ba.getDob());
		gr.setAccount_type(ba.getAccount_type());
		gr.setBalance(ba.getBalance());
		gr.setTransactions(t);
		return gr;
		
		
	}
}
