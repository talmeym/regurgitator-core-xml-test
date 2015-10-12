package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.FileUtil;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.xml.sax.*;

import java.io.*;

public class XmlBaseTest {
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
}
