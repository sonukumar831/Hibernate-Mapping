package com.manttomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Product {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prodId;
	private String prodName;
	private double price;
	
	@ManyToMany
	@JoinTable(name="orders_product", //--->change table name
	joinColumns = @JoinColumn(name = "product_id"), //--->change first column name
	inverseJoinColumns = @JoinColumn(name = "orders_id")) //--->change the second column name after merging the two extra table while excution
	List<Orders> orderlist=new ArrayList<Orders>();
}
