package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class IsolateXmlLoaderTest extends XmlBaseTest {
	private IsolateXmlLoader toTest = new IsolateXmlLoader();

	@Test
	public void testMin() throws Exception {
		assertExpectation(getElement("classpath:/Isolate_min.xml"), "com.emarte.regurgitator.core.Isolate:['isolate-1',com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'],false]");
	}

	@Test
	public void testMax() throws Exception {
		assertExpectation(getElement("classpath:/Isolate_max.xml"), "com.emarte.regurgitator.core.Isolate:['isolate-1',com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'],true]");
	}

	private void assertExpectation(Element element, String expected) throws RegurgitatorException {
		assertEquals(expected, toTest.load(element, new HashSet<Object>()).toString());
	}
}
