package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.*;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class IdentifySessionXmlLoaderTest extends XmlBaseTest {
	private IdentifySessionXmlLoader toTest = new IdentifySessionXmlLoader();

	@Test
	public void testMinimumXml() throws Exception {
		assertExpectation(getElement("classpath:/IdentifySession_min.xml"), "com.emarte.regurgitator.core.IdentifySession:['identify-session-1',com.emarte.regurgitator.core.ContextLocation:['context:location']]");
	}

	@Test
	public void testFullLoadXml() throws Exception {
		ConfigurationFile.loadFile("classpath:/IdentifySession_min.xml");
	}

	@Test(expected = DocumentException.class)
	public void testMissingSource() throws Exception {
		toTest.load(getElement("classpath:/IdentifySession_missingSource.xml"), new HashSet<Object>());
	}

	private void assertExpectation(Element element, String expected) throws RegurgitatorException {
		assertEquals(expected, toTest.load(element, new HashSet<Object>()).toString());
	}
}
