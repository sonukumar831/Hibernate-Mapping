package com.onetomanybi;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;
	private String bankName;
	private String address;
	
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy = "bank")
    private List<Account> account;
	
	//Helper method
//	public void addAccount(Account a)
//	{
//		accountlist.add(a);
//		
//	}
}
