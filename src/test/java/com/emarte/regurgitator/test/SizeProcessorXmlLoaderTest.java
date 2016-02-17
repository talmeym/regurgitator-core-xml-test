package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class SizeProcessorXmlLoaderTest extends XmlLoaderTest {
	public SizeProcessorXmlLoaderTest() {
		super(new SizeProcessorXmlLoader());
	}

	@Test
	public void testXml() throws Exception {
		assertExpectation("classpath:/SizeProcessor.xml", "com.emarte.regurgitator.core.SizeProcessor:[false]");
	}

	@Test
	public void testLastIndex() throws Exception {
		assertExpectation("classpath:/SizeProcessor_asIndex.xml", "com.emarte.regurgitator.core.SizeProcessor:[true]");
	}

	@Test
	public void testFullLoad() throws RegurgitatorException {
		loadFile("classpath:/SizeProcessor_fullLoad.xml");
	}
}
