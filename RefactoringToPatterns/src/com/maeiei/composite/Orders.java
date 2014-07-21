package com.maeiei.composite;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	
	private List<Order> order = new ArrayList<Order>();

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	public int getOrderCount() {
		return order.size();
	}
	
	public void addOrder(Order order) {
		this.order.add(order);
	}
	public Order getOrder(int i) {
		return order.get(i);
	}
}
