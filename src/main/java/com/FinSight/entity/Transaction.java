package com.FinSight.entity;
import java.lang.Double;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String transactionType; // Added to capture the transaction type
	private String category;        // Changed from name to category
	private String note;           // Added to capture notes
	private Double price;          // Changed from amount to price

	public Transaction(int id, String transactionType, String category, String note, Double price) {
		super();
		this.id = id;
		this.transactionType = transactionType;
		this.category = category;
		this.note = note;
		this.price = price;
	}

	public Transaction() {
		super();
		// Default constructor
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
