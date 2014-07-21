package com.maeiei.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.maeiei.factory.ClassInterface;

public class ClassTest {
	
	AbstractClassTest abstractClassTest;
	
	@Before
	public void before() {
		abstractClassTest = new ClassATest();
	}

	@Test
	public void testA() {

		ClassInterface a = abstractClassTest.createClass();

		String str = a.method();

		assertEquals("method of A", str);
	}

	@Test
	public void testB() {

		ClassInterface a = abstractClassTest.createClass();

		String str = a.method();

		assertEquals("method of B", str);
	}

}
