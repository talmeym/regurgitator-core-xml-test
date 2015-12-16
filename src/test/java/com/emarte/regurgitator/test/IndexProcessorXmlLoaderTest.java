package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class IndexProcessorXmlLoaderTest extends XmlBaseTest {
	private static final IndexProcessorXmlLoader toTest = new IndexProcessorXmlLoader();

	@Test
	public void testSource() throws Exception {
		assertExpectation(getElement("classpath:/IndexOfProcessor_source.xml"), "com.emarte.regurgitator.core.IndexProcessor:[com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['context:location'],null]]");
	}

	@Test
	public void testValue() throws Exception {
		assertExpectation(getElement("classpath:/IndexOfProcessor_value.xml"), "com.emarte.regurgitator.core.IndexProcessor:[com.emarte.regurgitator.core.ValueSource:[null,'value']]");
	}

	@Test
	public void testSourceAndValue() throws Exception {
		assertExpectation(getElement("classpath:/IndexOfProcessor_sourceAndValue.xml"), "com.emarte.regurgitator.core.IndexProcessor:[com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['context:location'],'value']]");
	}

	private void assertExpectation(Element element, String expected) throws RegurgitatorException {
		assertEquals(expected, toTest.load(element, new HashSet<Object>()).toString());
	}
}
