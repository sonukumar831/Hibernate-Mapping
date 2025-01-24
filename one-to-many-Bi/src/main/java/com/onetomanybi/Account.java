package com.onetomanybi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	private String name;
	private String ifsc;
	private long accountNo;
	
	
	@ManyToOne
	@JoinColumn(name="bank_account_Id")
	private Bank bank;
	
}
