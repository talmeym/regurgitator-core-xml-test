package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.junit.Test;
import org.xml.sax.SAXException;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class ExtractProcessorXmlLoaderTest extends XmlLoaderTest {
	public ExtractProcessorXmlLoaderTest() {
		super(new ExtractProcessorXmlLoader());
	}

	@Test
	public void testMinimumXml() throws Exception {
		assertExpectation("classpath:/ExtractProcessor_min.xml", "com.emarte.regurgitator.core.ExtractProcessor:['this is {0} test',0]");
	}

	@Test(expected = SAXException.class)
	public void testMissingFormatXml() throws Exception {
		loadFromFile("classpath:/ExtractProcessor_missingFormat.xml");
	}

	@Test
	public void testFullLoading() throws RegurgitatorException {
		loadFile("classpath:/ExtractProcessor_fullLoad.xml");
	}
}
