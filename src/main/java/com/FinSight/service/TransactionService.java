package com.FinSight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinSight.entity.Transaction;
import com.FinSight.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository bRepo;
	
	public void save(Transaction b) {
		bRepo.save(b);
	}
	
	public List<Transaction> getAllTransaction(){
		return bRepo.findAll();
	}
	
	public Transaction getTransactionById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}

}
