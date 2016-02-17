package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class IndexProcessorXmlLoaderTest extends XmlLoaderTest {
	public IndexProcessorXmlLoaderTest() {
		super(new IndexProcessorXmlLoader());
	}

	@Test
	public void testSource() throws Exception {
		assertExpectation("classpath:/IndexOfProcessor_source.xml", "com.emarte.regurgitator.core.IndexProcessor:[com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['context:location'],null]]");
	}

	@Test
	public void testValue() throws Exception {
		assertExpectation("classpath:/IndexOfProcessor_value.xml", "com.emarte.regurgitator.core.IndexProcessor:[com.emarte.regurgitator.core.ValueSource:[null,'value']]");
	}

	@Test
	public void testSourceAndValue() throws Exception {
		assertExpectation("classpath:/IndexOfProcessor_sourceAndValue.xml", "com.emarte.regurgitator.core.IndexProcessor:[com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['context:location'],'value']]");
	}

	@Test
	public void testFullLoad() throws RegurgitatorException {
		loadFile("classpath:/IndexProcessor_fullLoad.xml");
	}
}
