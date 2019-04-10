/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.SubstituteProcessorXmlLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.test.CoreLoaderTestExpectations.SubstituteProcessor_min;

public class SubstituteProcessorXmlLoaderTest extends XmlLoaderTest {
    public SubstituteProcessorXmlLoaderTest() {
        super(new SubstituteProcessorXmlLoader());
    }

    @Test
    public void testMinimum() throws Exception {
        assertExpectation("classpath:/SubstituteProcessor_min.xml", SubstituteProcessor_min);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/SubstituteProcessor_fullLoad.xml");
    }
}
