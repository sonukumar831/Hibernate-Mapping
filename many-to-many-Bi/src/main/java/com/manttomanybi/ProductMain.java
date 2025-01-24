package com.manttomanybi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("many-to-manyBi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Orders o1=new Orders();
		o1.setOrderAddress("adityapur");
		
		Orders o2=new Orders();
		o2.setOrderAddress("bhidhannager");
		
		Product p1=new Product();
		p1.setProdId(201);
		p1.setProdName("Watch");
		p1.setPrice(2000d);
		
		Product p2=new Product();
		p2.setProdId(202);
		p2.setProdName("Trimmer");
		p2.setPrice(500d);
		
		//maooing
		o1.addProduct(p1);
		o1.addProduct(p2);
		 	 	
		o2.addProduct(p1);
		o2.addProduct(p2);
		
		//persist
		et.begin();
		em.persist(o1);
		em.persist(o2);
		et.commit();
	}
}

