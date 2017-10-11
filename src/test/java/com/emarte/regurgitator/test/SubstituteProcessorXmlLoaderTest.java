/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.core.SubstituteProcessorXmlLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class SubstituteProcessorXmlLoaderTest extends XmlLoaderTest {
    public SubstituteProcessorXmlLoaderTest() {
        super(new SubstituteProcessorXmlLoader());
    }

    @Test
    public void testMinimumXml() throws Exception {
        assertExpectation("classpath:/SubstituteProcessor_min.xml", "com.emarte.regurgitator.core.SubstituteProcessor:['this','that']");
    }

    @Test
    public void testFullLoadXml() throws RegurgitatorException {
        loadFile("classpath:/SubstituteProcessor_fullLoad.xml");
    }
}
