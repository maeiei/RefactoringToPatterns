package com.maeiei.composite.test;

import org.junit.Assert;
import org.junit.Test;

import com.maeiei.composite.Client;
import com.maeiei.composite.Order;
import com.maeiei.composite.Orders;
import com.maeiei.composite.Price;
import com.maeiei.composite.Product;
import com.maeiei.composite.TagNode;

public class CompositeTest {
	
	@Test
	public void generateTest() {
		
		Price price = initializePrice();
		Product product = initializeProduct(price);
		Order order = initializeOrder(product);
		
		Orders orders = new Orders();
		
		orders.addOrder(order);
		
		Client client = new Client(orders);
		
		String xml = client.generate();
		
		String expectedResult = 
				"<orders>" +
					"<order id='321'>" +
					"<product id='f1234' color='red' size='medium'>" +
						"<price currency='USD'>" +
							"8.95" + 
						"</price>" +
						"Fire Truck" +
					"</product>" + 
					"</order>" +
				"</orders>";

		Assert.assertEquals(expectedResult, xml);
	}

	@Test
	public void testCompositeTagOneChild() {
		
		String expectedResult = 
					"<product>" +
						"<price>" +
						"</price>" +
					"</product>";
		
		TagNode productNode = new TagNode("product");
		productNode.add(new TagNode("price"));
		
		Assert.assertEquals(expectedResult, productNode.toString());
	}	
	@Test
	public void testaddingChildrenAndGrandChildren() {
		
		String expectedResult = 
					"<orders>" +
						"<order>" +
							"<product>" +
							"</product>" +
						"</order>" +
					"</orders>";
		
		TagNode ordersNode = new TagNode("orders");
		TagNode orderNode = new TagNode("order");
		TagNode productNode = new TagNode("product");
		
		orderNode.add(productNode);
		ordersNode.add(orderNode);
		
		Assert.assertEquals(expectedResult, ordersNode.toString());
	}
	@Test
	public void testParent() {
		
		TagNode rootNode = new TagNode("root");
		
		Assert.assertNull(rootNode.getParent());
		
		TagNode childNode = new TagNode("childNode");
		
		rootNode.add(childNode);
		
		Assert.assertEquals(rootNode, childNode.getParent());
		Assert.assertEquals("root", childNode.getParent().getName());
	}	

	private Order initializeOrder(Product product) {
		
		Order order = new Order();
		order.setId("321");
		order.addProduct(product);
		
		return order;
	}

	public Price initializePrice() {
		
		Price price = new Price();
		price.setCurrency("USD");
		price.setValue("8.95");
		
		return price;
	}
	
	private Product initializeProduct(Price price) {
		
		Product product = new Product();
		product.setId("f1234");
		product.setColor("red");
		product.setSize("medium");
		product.setName("Fire Truck");
		
		product.setPrice(price);
		
		return product;
	}	
}
