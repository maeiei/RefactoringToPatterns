package com.maeiei.compositeOneMany;

import java.util.ArrayList;
import java.util.List;

import com.maeiei.composite.Product;

public class ProductRepository {

	public List<Product> selectBy(Spec spec) {
		
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		product.setName("Spec");
		
		productList.add(product);

		return productList;
	}
}
