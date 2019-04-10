/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.SizeProcessorXmlLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.test.CoreLoaderTestExpectations.SizeProcessor;
import static com.emarte.regurgitator.test.CoreLoaderTestExpectations.SizeProcessor_asIndex;

public class SizeProcessorXmlLoaderTest extends XmlLoaderTest {
    public SizeProcessorXmlLoaderTest() {
        super(new SizeProcessorXmlLoader());
    }

    @Test
    public void testThis() throws Exception {
        assertExpectation("classpath:/SizeProcessor.xml", SizeProcessor);
    }

    @Test
    public void testLastIndex() throws Exception {
        assertExpectation("classpath:/SizeProcessor_asIndex.xml", SizeProcessor_asIndex);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/SizeProcessor_fullLoad.xml");
    }
}
