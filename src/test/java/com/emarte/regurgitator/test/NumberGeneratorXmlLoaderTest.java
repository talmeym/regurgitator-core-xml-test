package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.DocumentException;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class NumberGeneratorXmlLoaderTest extends XmlLoaderTest {
	public NumberGeneratorXmlLoaderTest() {
		super(new NumberGeneratorXmlLoader());
	}

	@Test
	public void testThis() throws DocumentException, SAXException, IOException, RegurgitatorException {
		assertExpectation("classpath:/NumberGenerator.xml", "com.emarte.regurgitator.core.NumberGenerator:[null]");
	}

	@Test
	public void testMax() throws DocumentException, SAXException, IOException, RegurgitatorException {
		assertExpectation("classpath:/NumberGenerator_max.xml", "com.emarte.regurgitator.core.NumberGenerator:[1234]");
	}

	@Test
	public void testFullLoad() throws DocumentException, SAXException, IOException, RegurgitatorException {
		loadFile("classpath:/NumberGenerator_fullLoad.xml");
	}
}
