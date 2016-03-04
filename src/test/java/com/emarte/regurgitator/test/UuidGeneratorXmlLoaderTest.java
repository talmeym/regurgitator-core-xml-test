package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.DocumentException;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class UuidGeneratorXmlLoaderTest extends XmlLoaderTest {
	public UuidGeneratorXmlLoaderTest() {
		super(new UuidGeneratorXmlLoader());
	}

	@Test
	public void testThis() throws DocumentException, SAXException, IOException, RegurgitatorException {
		assertExpectation("classpath:/UuidGenerator.xml", "com.emarte.regurgitator.core.UuidGenerator:[]");
	}

	@Test
	public void testFullLoad() throws DocumentException, SAXException, IOException, RegurgitatorException {
		loadFile("classpath:/UuidGenerator_fullLoad.xml");
	}
}
