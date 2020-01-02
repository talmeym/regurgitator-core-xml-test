/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.core.XmlLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.core.FileUtil.getInputStreamForFile;
import static com.emarte.regurgitator.core.XmlConfigUtil.getFirstChild;
import static org.junit.Assert.assertEquals;

public class XmlLoaderTest {
    private final XmlLoader toTest;

    public XmlLoaderTest(XmlLoader toTest) {
        this.toTest = toTest;
    }

    protected String loadFromFile(String filePath) throws RegurgitatorException, SAXException, IOException, ParserConfigurationException {
        return toTest.load(getElement(filePath), new HashSet<Object>()).toString();
    }

    private Element getElement(String filePath) throws SAXException, ParserConfigurationException, IOException, RegurgitatorException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setValidating(true);
        dbFactory.setNamespaceAware(true);
        dbFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        dBuilder.setEntityResolver(new EntityResolver() {
            public InputSource resolveEntity(String publicId, String systemId) throws IOException {
                String resolvePath = "classpath:/" + systemId.substring(systemId.lastIndexOf("/") + 1);
                return new InputSource(getInputStreamForFile(resolvePath));
            }
        });

        dBuilder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) {

            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                throw new SAXException("Error: ", exception);
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                throw new SAXException("Fatal Error: ", exception);
            }
        });

        Document doc = dBuilder.parse(getInputStreamForFile(filePath));
        Element rootElement = doc.getDocumentElement();
        rootElement.normalize();
        return getFirstChild(rootElement);
    }

    protected final void assertExpectation(String filePath, String expected) throws RegurgitatorException, SAXException, IOException, ParserConfigurationException {
        assertEquals(expected, loadFromFile(filePath));
    }

    protected final void assertExpectationFullLoad(String filePath, String expected) throws RegurgitatorException {
        assertEquals(expected, loadFile(filePath).toString());
    }
}
