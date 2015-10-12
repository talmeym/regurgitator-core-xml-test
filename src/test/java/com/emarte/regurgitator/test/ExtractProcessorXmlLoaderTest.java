package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.*;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class ExtractProcessorXmlLoaderTest extends XmlBaseTest {
	private ExtractProcessorXmlLoader toTest = new ExtractProcessorXmlLoader();

	@Test
	public void testMinimumXml() throws Exception {
		assertExpectation(getElement("classpath:/ExtractProcessor_min.xml"), "com.emarte.regurgitator.core.ExtractProcessor:['this is {0} test',0]");
	}

	@Test(expected = DocumentException.class)
	public void testMissingFormatXml() throws Exception {
		toTest.load(getElement("classpath:/ExtractProcessor_missingFormat.xml"), new HashSet<Object>());
	}

	@Test
	public void testFullLoading() throws RegurgitatorException {
		ConfigurationFile.loadFile("classpath:/ExtractProcessor_fullLoad.xml");
	}

	private void assertExpectation(Element element, String expected) throws RegurgitatorException {
		assertEquals(expected, toTest.load(element, new HashSet<Object>()).toString());
	}
}
