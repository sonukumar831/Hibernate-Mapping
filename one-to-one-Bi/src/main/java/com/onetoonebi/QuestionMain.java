package com.onetoonebi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class QuestionMain {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("one-to-oneBi");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Question q1=new Question();
	q1.setQuestion("what is hibernate");
	
	Answer a1=new Answer();
	a1.setAnswer("ORM tool");
	
	q1.addAnswer(a1);
	
	et.begin();
	em.persist(q1);
	et.commit();
}
}
