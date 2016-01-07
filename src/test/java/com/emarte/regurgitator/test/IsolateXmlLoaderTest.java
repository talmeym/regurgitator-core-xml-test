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
		assertExpectation(getElement("classpath:/Isolate_min.xml"), "com.emarte.regurgitator.core.Isolate:['isolate-1',com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'],false,false]");
	}

	@Test
	public void testSession() throws Exception {
		assertExpectation(getElement("classpath:/Isolate_session.xml"), "com.emarte.regurgitator.core.Isolate:['isolate-1',com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'],true,false]");
	}

	@Test
	public void testParameters() throws Exception {
		assertExpectation(getElement("classpath:/Isolate_parameters.xml"), "com.emarte.regurgitator.core.Isolate:['isolate-1',com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'],false,true]");
	}

	private void assertExpectation(Element element, String expected) throws RegurgitatorException {
		assertEquals(expected, toTest.load(element, new HashSet<Object>()).toString());
	}
}
