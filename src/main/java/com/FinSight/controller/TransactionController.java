package com.FinSight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.FinSight.entity.Transaction;
import com.FinSight.service.TransactionService;

import java.util.*;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService service;

	@GetMapping("/")
	public String home() {
		return "home"; // Redirects to the home page
	}

	@GetMapping("/transaction_register")
	public String transactionRegister() {
		return "TransactionRegister"; // Renders the transaction registration page
	}

	@GetMapping("/transactionhistory")
	public ModelAndView getAllTransactions() {
		List<Transaction> list = service.getAllTransaction();
		return new ModelAndView("TransactionList", "transaction", list); // Displays all transactions
	}

	@PostMapping("/save")
	public String addTransaction(@ModelAttribute Transaction transaction) {
		service.save(transaction); // Saves the transaction
		return "redirect:/transactionhistory"; // Redirects to transaction history after saving
	}

	@GetMapping("/editTransaction/{id}")
	public String editTransaction(@PathVariable("id") int id, Model model) {
		Transaction transaction = service.getTransactionById(id);
		if (transaction == null) {
			// Handle transaction not found (optional: redirect or show error)
		}
		model.addAttribute("transaction", transaction); // Adds the transaction to the model for editing
		return "TransactionEdit"; // Renders the edit transaction page
	}

	@GetMapping("/deleteTransaction/{id}")
	public String deleteTransaction(@PathVariable("id") int id) {
		service.deleteById(id); // Deletes the transaction by ID
		return "redirect:/transactionhistory"; // Redirects to transaction history after deletion
	}

}
