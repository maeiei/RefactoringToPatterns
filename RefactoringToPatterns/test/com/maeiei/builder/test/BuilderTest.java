package com.maeiei.builder.test;

import org.junit.Assert;
import org.junit.Test;

import com.maeiei.builder.TagBuilder;

public class BuilderTest {

	@Test
	public void testBuilderOneNode() {
		String expectedXml = 
				"<flavors>" + "</flavors>";
		
		String actualXml = new TagBuilder("flavors").toXml();
		
		Assert.assertEquals(expectedXml, actualXml);
	}
	@Test
	public void testBuilderOneChild() {
		String expectedXml = 
				"<flavors>" +
					"<flavor>" +
					"</flavor>" +	
				"</flavors>";
		
		TagBuilder tagBuilder = new TagBuilder("flavors");
		tagBuilder.addChild("flavor");
		
		String actualXml = tagBuilder.toXml();
		
		Assert.assertEquals(expectedXml, actualXml);
	}
	@Test
	public void testBuilderOfChildren() {
		String expectedXml = 
			"<flavors>" +
				"<flavor>" +
					"<requirements>" +
						"<requirement>" +
						"</requirement>" +
					"</requirements>" +
				"</flavor>" +
			"</flavors>";
		
		TagBuilder tagBuilder = new TagBuilder("flavors");
		tagBuilder.addChild("flavor");
		tagBuilder.addChild("requirements");
		tagBuilder.addChild("requirement");
		
		String actualXml = tagBuilder.toXml();
		
		Assert.assertEquals(expectedXml, actualXml);
	}
	@Test
	public void testBuilderOfSibling() {
		String expectedXml = 
			"<flavors>" +
				"<flavor1>" +
				"</flavor1>" +
				"<flavor2>" +
				"</flavor2>" +
			"</flavors>";
		
		TagBuilder tagBuilder = new TagBuilder("flavors");
		tagBuilder.addChild("flavor1");
		tagBuilder.addSibling("flavor2");
		
		String actualXml = tagBuilder.toXml();
		
		Assert.assertEquals(expectedXml, actualXml);
	}
	@Test
	public void testBuilderOfDoubleSibling() {
		String expectedXml = 
			"<flavors>" +
				"<flavor1>" +
					"<requirements1>" +
					"</requirements1>" +
				"</flavor1>" +
				"<flavor2>" +
					"<requirements2>" +
					"</requirements2>" +
				"</flavor2>" +
			"</flavors>";
		
		TagBuilder tagBuilder = new TagBuilder("flavors");
		tagBuilder.addToParent("flavors", "flavor1");
		tagBuilder.addChild("requirements1");
		tagBuilder.addToParent("flavors", "flavor2");
		tagBuilder.addChild("requirements2");
		String actualXml = tagBuilder.toXml();
		
		Assert.assertEquals(expectedXml, actualXml);
	}
	@Test
	public void testBuilderParentNameNotFound() {
		
		try {
			TagBuilder tagBuilder = new TagBuilder("flavors");
			tagBuilder.addToParent("flavrs", "flavor1");
			tagBuilder.addChild("requirements1");
			
			Assert.fail("不可能运行！");
			Assert.fail("不允许在不存在的父节点上增加");
		} catch (RuntimeException e) {
			String expectedErrorMessage = "miss parent tag: flavrs";
			Assert.assertEquals(expectedErrorMessage, e.getMessage());
		}
	}
	@Test
	public void testAttributesAndValues() {
		
		String expectedXml = 
				"<orders>" +
					"<order id='321'>" +
					"<product id='f1234' color='red' size='medium'>" +
						"<price currency='USD'>" +
							"8.95" + 
						"</price>" +
						"<price currency='JAP'>" +
							"9.15" + 
						"</price>" +	
						"Fire Truck" +
					"</product>" + 
					"</order>" +
				"</orders>";
		
		TagBuilder tagBuilder = new TagBuilder("orders");
		
		tagBuilder.addChild("order");
		tagBuilder.addAttributes("id", "321");
		tagBuilder.addChild("product");
		tagBuilder.addAttributes("id", "f1234");
		tagBuilder.addAttributes("color", "red");
		tagBuilder.addAttributes("size", "medium");
		tagBuilder.addValue("Fire Truck");
		tagBuilder.addChild("price");
		tagBuilder.addAttributes("currency", "USD");	
		tagBuilder.addValue("8.95");
		tagBuilder.addSibling("price");
		tagBuilder.addAttributes("currency", "JAP");	
		tagBuilder.addValue("9.15");
		
		Assert.assertEquals(expectedXml, tagBuilder.toXml());
	}
	@Test
	public void testToStringBufferSize() {
		
		TagBuilder tagBuilder = new TagBuilder("orders");
		
		tagBuilder.addChild("order");
		tagBuilder.addAttributes("id", "321");
		tagBuilder.addChild("product");
		tagBuilder.addAttributes("id", "f1234");
		tagBuilder.addAttributes("color", "red");
		tagBuilder.addAttributes("size", "medium");
		tagBuilder.addValue("Fire Truck");
		tagBuilder.addChild("price");
		tagBuilder.addAttributes("currency", "USD");	
		tagBuilder.addValue("8.95");
		tagBuilder.addSibling("price");
		tagBuilder.addAttributes("currency", "JAP");	
		tagBuilder.addValue("9.15");
		
		int stringSize = tagBuilder.toXml().length();
		int computedSize = tagBuilder.bufferSize();
		
		Assert.assertEquals(stringSize, computedSize);
	}
}
