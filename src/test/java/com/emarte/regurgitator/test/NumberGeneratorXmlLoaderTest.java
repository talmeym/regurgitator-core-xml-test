package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class NumberGeneratorXmlLoaderTest extends XmlLoaderTest {
	public NumberGeneratorXmlLoaderTest() {
		super(new NumberGeneratorXmlLoader());
	}

	@Test
	public void testThis() throws Exception {
		assertExpectation("classpath:/NumberGenerator.xml", "com.emarte.regurgitator.core.NumberGenerator:[null]");
	}

	@Test
	public void testMax() throws Exception {
		assertExpectation("classpath:/NumberGenerator_max.xml", "com.emarte.regurgitator.core.NumberGenerator:[1234]");
	}

	@Test
	public void testFullLoad() throws Exception {
		loadFile("classpath:/NumberGenerator_fullLoad.xml");
	}
}
