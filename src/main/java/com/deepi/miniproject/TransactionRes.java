package com.deepi.miniproject;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRes extends JpaRepository<Transaction, Integer> {
	@Query("from Transaction where acc.account_number=?1")
	List<Transaction> getTran(int account_number);

}
