/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.ExtractProcessorXmlLoader;
import org.junit.Test;
import org.xml.sax.SAXException;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.test.CoreLoaderTestExpectations.ExtractProcessor_min;

public class ExtractProcessorXmlLoaderTest extends XmlLoaderTest {
    public ExtractProcessorXmlLoaderTest() {
        super(new ExtractProcessorXmlLoader());
    }

    @Test
    public void testMinimum() throws Exception {
        assertExpectation("classpath:/ExtractProcessor_min.xml", ExtractProcessor_min);
    }

    @Test(expected = SAXException.class)
    public void testMissingFormat() throws Exception {
        loadFromFile("classpath:/ExtractProcessor_missingFormat.xml");
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/ExtractProcessor_fullLoad.xml");
    }
}
