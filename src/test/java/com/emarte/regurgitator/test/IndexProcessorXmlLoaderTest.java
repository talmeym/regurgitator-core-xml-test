/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.IndexProcessorXmlLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.test.CoreLoaderTestExpectations.*;

public class IndexProcessorXmlLoaderTest extends XmlLoaderTest {
    public IndexProcessorXmlLoaderTest() {
        super(new IndexProcessorXmlLoader());
    }

    @Test
    public void testValue() throws Exception {
        // reuse IndexOfProcessor files
        assertExpectation("classpath:/IndexOfProcessor_value.xml", IndexProcessor_value);
    }

    @Test
    public void testSource() throws Exception {
        // reuse IndexOfProcessor files
        assertExpectation("classpath:/IndexOfProcessor_source.xml", IndexProcessor_source);
    }

    @Test
    public void testSourceAndValue() throws Exception {
        // reuse IndexOfProcessor files
        assertExpectation("classpath:/IndexOfProcessor_sourceAndValue.xml", IndexProcessor_sourceAndValue);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/IndexProcessor_fullLoad.xml");
    }
}
