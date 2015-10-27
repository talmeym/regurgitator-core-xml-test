package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class IndexOfProcessorXmlLoaderTest extends XmlBaseTest {
	private static final IndexOfProcessorXmlLoader toTest = new IndexOfProcessorXmlLoader();

	@Test
	public void testSource() throws Exception {
		assertExpectation(getElement("classpath:/IndexOfProcessor_source.xml"), "com.emarte.regurgitator.core.IndexOfProcessor:[com.emarte.regurgitator.core.ContextLocation:['context:location'],null,false]");
	}

	@Test
	public void testValue() throws Exception {
		assertExpectation(getElement("classpath:/IndexOfProcessor_value.xml"), "com.emarte.regurgitator.core.IndexOfProcessor:[null,'value',false]");
	}

	@Test
	public void testSourceAndValue() throws Exception {
		assertExpectation(getElement("classpath:/IndexOfProcessor_sourceAndValue.xml"), "com.emarte.regurgitator.core.IndexOfProcessor:[com.emarte.regurgitator.core.ContextLocation:['context:location'],'value',false]");
	}

	private void assertExpectation(Element element, String expected) throws RegurgitatorException {
		assertEquals(expected, toTest.load(element, new HashSet<Object>()).toString());
	}
}
