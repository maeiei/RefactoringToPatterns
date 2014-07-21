package com.maeiei.compositeOneMany.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.maeiei.composite.Product;
import com.maeiei.compositeOneMany.ColorSpec;
import com.maeiei.compositeOneMany.CompositeSpec;
import com.maeiei.compositeOneMany.ProductRepository;
import com.maeiei.compositeOneMany.SizeSpec;
import com.maeiei.compositeOneMany.Spec;

public class TestCompositeOneMany {
	
	@Test
	public void selectByTest(){
		
		ProductRepository productRepository = new ProductRepository();
		
		Spec spec = new Spec();
		
		CompositeSpec compositeSpec = new CompositeSpec();
		
		compositeSpec.add(spec);
		
		ColorSpec ColorSpec = new ColorSpec();
		SizeSpec SizeSpec = new SizeSpec();
		
		CompositeSpec comList = new CompositeSpec();
		
		comList.add(ColorSpec);
		comList.add(SizeSpec);
		
		List<Product> productOneList = productRepository.selectBy(compositeSpec);
		List<Product> productManyList = productRepository.selectBy(comList);
		
		Product productOne = productOneList.get(0);
		Product productMany = productManyList.get(0);
		
		Assert.assertEquals("Spec", productOne.getName());
		Assert.assertEquals("Spec", productMany.getName());
	}
}
