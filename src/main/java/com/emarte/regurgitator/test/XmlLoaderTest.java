package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.xml.sax.*;

import java.io.*;
import java.util.HashSet;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static org.junit.Assert.assertEquals;

public class XmlLoaderTest {
	protected final XmlLoader toTest;

	public XmlLoaderTest(XmlLoader toTest) {
		this.toTest = toTest;
	}

	public Element getElement(String filePath) throws SAXException, DocumentException, IOException {
		SAXReader reader = new SAXReader();
		reader.setValidation(true);
		reader.setFeature("http://apache.org/xml/features/validation/schema", true);
		reader.setEntityResolver(new EntityResolver() {
			public InputSource resolveEntity(String publicId, String systemId) throws IOException {
				String resolvePath = "classpath:/" + systemId.substring(systemId.lastIndexOf("/") + 1);
				FileUtil.checkResource(resolvePath);
				return new InputSource(FileUtil.getInputStreamForFile(resolvePath));
			}
		});

		InputStream resourceAsStream = FileUtil.getInputStreamForFile(filePath);
		Document doc = reader.read(resourceAsStream);
		return (Element) doc.getRootElement().elements().get(0);
	}

	protected String loadFromFile(String filePath) throws RegurgitatorException, DocumentException, SAXException, IOException {
		return toTest.load(getElement(filePath), new HashSet<Object>()).toString();
	}

	protected final void assertExpectation(String filePath, String expected) throws RegurgitatorException, DocumentException, SAXException, IOException {
		assertEquals(expected, loadFromFile(filePath));
	}

	protected final void assertExpectationFullLoad(String filePath, String expected) throws RegurgitatorException {
		assertEquals(expected, loadFile(filePath).toString());
	}
}
