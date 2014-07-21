package com.maeiei.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.maeiei.factory.ClassA;
import com.maeiei.factory.ClassB;
import com.maeiei.factory.ClassInterface;

public abstract class AbstractClassTest {

	protected abstract ClassInterface createClass();

	@Test
	public void testA() {

		ClassInterface a = createClass();

		String str = a.method();

		assertEquals("method of A", str);
	}

	@Test
	public void testB() {

		ClassInterface b = createClass();

		String strB = b.method();

		assertEquals("method of B", strB);
	}
}

class ClassBTest extends AbstractClassTest {

	@Override
	public ClassInterface createClass() {

		return new ClassB();
	}

}

class ClassATest extends AbstractClassTest {

	public ClassInterface createClass() {

		return new ClassA();
	}
}
