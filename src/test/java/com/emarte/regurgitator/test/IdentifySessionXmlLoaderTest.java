package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.IdentifySessionXmlLoader;
import org.dom4j.DocumentException;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class IdentifySessionXmlLoaderTest extends XmlLoaderTest {
	public IdentifySessionXmlLoaderTest() {
		super(new IdentifySessionXmlLoader());
	}

	@Test
	public void testMinimumXml() throws Exception {
		assertExpectation("classpath:/IdentifySession_min.xml", "com.emarte.regurgitator.core.IdentifySession:['identify-session-1',com.emarte.regurgitator.core.ContextLocation:['context:location']]");
	}

	@Test
	public void testFullLoadXml() throws Exception {
		loadFile("classpath:/IdentifySession_min.xml");
	}

	@Test(expected = DocumentException.class)
	public void testMissingSource() throws Exception {
		loadFromFile("classpath:/IdentifySession_missingSource.xml");
	}
}
