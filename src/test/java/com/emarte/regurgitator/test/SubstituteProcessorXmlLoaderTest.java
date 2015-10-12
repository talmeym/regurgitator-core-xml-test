package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class SubstituteProcessorXmlLoaderTest extends XmlBaseTest {
	private SubstituteProcessorXmlLoader toTest = new SubstituteProcessorXmlLoader();

	@Test
	public void testMinimumXml() throws Exception {
		assertExpectation(getElement("classpath:/SubstituteProcessor_min.xml"), "com.emarte.regurgitator.core.SubstituteProcessor:['this','that']");
	}

	@Test
	public void testFullLoadXml() throws RegurgitatorException {
		ConfigurationFile.loadFile("classpath:/SubstituteProcessor_fullLoad.xml");
	}

	private void assertExpectation(Element element, String expected) throws RegurgitatorException {
		assertEquals(expected, toTest.load(element, new HashSet<Object>()).toString());
	}
}
