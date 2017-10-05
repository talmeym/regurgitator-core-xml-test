package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;
import java.io.*;
import java.util.HashSet;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.core.XmlConfigUtil.getFirstChild;
import static org.junit.Assert.assertEquals;

public class XmlLoaderTest {
    protected final XmlLoader toTest;

    public XmlLoaderTest(XmlLoader toTest) {
        this.toTest = toTest;
    }

    public Element getElement(String filePath) throws SAXException, ParserConfigurationException, IOException, RegurgitatorException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setValidating(true);
        dbFactory.setNamespaceAware(true);
        dbFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        dBuilder.setEntityResolver(new EntityResolver() {
            public InputSource resolveEntity(String publicId, String systemId) throws IOException {
                String resolvePath = "classpath:/" + systemId.substring(systemId.lastIndexOf("/") + 1);
                FileUtil.checkResource(resolvePath);
                return new InputSource(FileUtil.getInputStreamForFile(resolvePath));
            }
        });

        dBuilder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {

            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                throw new SAXException("Error: ", exception);
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                throw new SAXException("Error: ", exception);
            }
        });

        Document doc = dBuilder.parse(FileUtil.getInputStreamForFile(filePath));
        Element rootElement = doc.getDocumentElement();
        rootElement.normalize();
        return getFirstChild(rootElement);
    }

    protected String loadFromFile(String filePath) throws RegurgitatorException, SAXException, IOException, ParserConfigurationException {
        return toTest.load(getElement(filePath), new HashSet<Object>()).toString();
    }

    protected final void assertExpectation(String filePath, String expected) throws RegurgitatorException, SAXException, IOException, ParserConfigurationException {
        assertEquals(expected, loadFromFile(filePath));
    }

    protected final void assertExpectationFullLoad(String filePath, String expected) throws RegurgitatorException {
        assertEquals(expected, loadFile(filePath).toString());
    }
}
