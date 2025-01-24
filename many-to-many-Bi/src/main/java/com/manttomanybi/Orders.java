package com.manttomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String orderAddress;
	
	@ManyToMany(cascade = CascadeType.PERSIST,mappedBy = "orderlist")
	List<Product> productlist=new ArrayList<Product>();
	
	//Helper method
	public void addProduct(Product p) {
		productlist.add(p);
		p.getOrderlist().add(this);
	}
}
