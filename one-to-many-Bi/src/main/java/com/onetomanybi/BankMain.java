package com.onetomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BankMain {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("one-to-manyBi");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Bank b1=new Bank();
	b1.setBankName("SBI");
	b1.setAddress("golmuri");
	
	Bank b2=new Bank();
	b2.setBankName("HDFC");
	b2.setAddress("sakchi");
	
	
	Account a1=new Account();
	a1.setName("Sonu");
	a1.setIfsc("SBI0000944");
	a1.setAccountNo(204040440);
	
	Account a2=new Account();
	a2.setName("Anuj");
	a2.setIfsc("SBI0000944");
	a2.setAccountNo(233403000);
	
	Account a3=new Account();
	a3.setName("Rahul");
	a3.setIfsc("HDFC006784");
	a3.setAccountNo(50003030);
	
	Account a4=new Account();
	a4.setName("Aryan");
	a4.setIfsc("HDFC006784");
	a4.setAccountNo(56789075);
	
	List<Account> list1=new ArrayList<Account>();
	list1.add(a1);
	list1.add(a2);
	
	List<Account> list2=new ArrayList<Account>();
	list2.add(a3);
	list2.add(a4);
	
	b1.setAccount(list1);
	b2.setAccount(list2);
	
	et.begin();
	em.persist(b1);
	em.persist(b2);
	et.commit();
	
	
}
}
