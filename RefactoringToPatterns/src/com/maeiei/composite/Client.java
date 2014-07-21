package com.maeiei.composite;

public class Client {

	private Orders orders;
	
	public Client(Orders orders) {
		this.orders = orders;
	}

	public String generate() {

		TagNode ordersNode = new TagNode("orders");

		for (int i = 0; i < orders.getOrderCount(); i++) {

			Order order = orders.getOrder(i);
			TagNode orderNode = new TagNode("order");

			orderNode.addAttributes("id", order.getId());

			generateProduct(orderNode, order);

			ordersNode.add(orderNode);
		}
		return ordersNode.toString();
	}

	private void generateProduct(TagNode orderNode, Order order) {

		for (int j = 0; j < order.getProductCount(); j++) {

			Product product = order.getProduct(j);
			TagNode productNode = new TagNode("product");

			productNode.addAttributes("id", product.getId());
			productNode.addAttributes("color", product.getColor());
			productNode.addAttributes("size", product.getSize());
			productNode.addValue(product.getName());

			generatePrice(productNode, product);
			orderNode.add(productNode);
		}
	}

	private void generatePrice(TagNode productNode, Product product) {

		TagNode priceNode = new TagNode("price");

		priceNode.addAttributes("currency", product.getPrice().getCurrency());
		priceNode.addValue(product.getPrice().getValue());

		productNode.add(priceNode);
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
}