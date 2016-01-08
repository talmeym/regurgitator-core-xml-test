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
		assertExpectation("classpath:/numberGenerator.xml", "com.emarte.regurgitator.core.NumberGenerator:[1234]");
	}

	@Test
	public void testFullLoad() throws DocumentException, SAXException, IOException, RegurgitatorException {
		loadFile("classpath:/numberGenerator_fullLoad.xml");
	}
}
