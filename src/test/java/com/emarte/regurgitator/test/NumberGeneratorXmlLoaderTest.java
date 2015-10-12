package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.*;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class NumberGeneratorXmlLoaderTest extends XmlBaseTest {
	private NumberGeneratorXmlLoader toTest = new NumberGeneratorXmlLoader();

	@Test
	public void testThis() throws DocumentException, SAXException, IOException, RegurgitatorException {
		assertExpectation(getElement("classpath:/numberGenerator.xml"), "com.emarte.regurgitator.core.NumberGenerator:[1234]");
	}

	@Test
	public void testFullLoad() throws DocumentException, SAXException, IOException, RegurgitatorException {
		ConfigurationFile.loadFile("classpath:/numberGenerator_fullLoad.xml");
	}

	private void assertExpectation(Element element, String expected) throws RegurgitatorException {
		assertEquals(expected, toTest.load(element, new HashSet<Object>()).toString());
	}
}
