/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import uk.emarte.regurgitator.core.SizeProcessorXmlLoader;
import org.junit.Test;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.SizeProcessor;
import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.SizeProcessor_asIndex;

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
