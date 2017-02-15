package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class IdentifySessionXmlLoaderTest extends XmlLoaderTest {
	public IdentifySessionXmlLoaderTest() {
		super(new IdentifySessionXmlLoader());
	}

	@Test
	public void testSource() throws Exception {
		assertExpectation("classpath:/IdentifySession_source.xml", "com.emarte.regurgitator.core.IdentifySession:['identify-session-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['context:location'],null]]");
	}

	@Test
	public void testValue() throws Exception {
		assertExpectation("classpath:/IdentifySession_value.xml", "com.emarte.regurgitator.core.IdentifySession:['identify-session-1',com.emarte.regurgitator.core.ValueSource:[null,'value']]");
	}

	@Test
	public void testSourceAndValue() throws Exception {
		assertExpectation("classpath:/IdentifySession_sourceAndvalue.xml", "com.emarte.regurgitator.core.IdentifySession:['identify-session-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['context:location'],'value']]");
	}

	@Test
	public void testFullLoadXml() throws Exception {
		loadFile("classpath:/IdentifySession_source.xml");
	}

	@Test(expected = RegurgitatorException.class)
	public void testMissingSource() throws Exception {
		loadFromFile("classpath:/IdentifySession_missingSource.xml");
	}
}
