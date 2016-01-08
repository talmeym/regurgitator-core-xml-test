package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class SubstituteProcessorXmlLoaderTest extends XmlLoaderTest {
	public SubstituteProcessorXmlLoaderTest() {
		super(new SubstituteProcessorXmlLoader());
	}

	@Test
	public void testMinimumXml() throws Exception {
		assertExpectation("classpath:/SubstituteProcessor_min.xml", "com.emarte.regurgitator.core.SubstituteProcessor:['this','that']");
	}

	@Test
	public void testFullLoadXml() throws RegurgitatorException {
		loadFile("classpath:/SubstituteProcessor_fullLoad.xml");
	}
}
