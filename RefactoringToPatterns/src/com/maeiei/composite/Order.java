package com.maeiei.composite;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private String id;
	
	private List<Product> product = new ArrayList<Product>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public Product getProduct(int i) {
		return product.get(i);
	}
	public int getProductCount() {
		return product.size();
	}
	public void addProduct(Product product) {
		this.product.add(product);
	}
}
