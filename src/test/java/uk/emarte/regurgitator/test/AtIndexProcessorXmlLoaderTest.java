/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import org.junit.Test;
import uk.emarte.regurgitator.core.AtIndexProcessorXmlLoader;
import uk.emarte.regurgitator.core.RegurgitatorException;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.*;

public class AtIndexProcessorXmlLoaderTest extends XmlLoaderTest {
    public AtIndexProcessorXmlLoaderTest() {
        super(new AtIndexProcessorXmlLoader());
    }

    @Test
    public void testValue() throws Exception {
        assertExpectation("classpath:/AtIndexProcessor_value.xml", AtIndexProcessor_value);
    }

    @Test
    public void testSource() throws Exception {
        assertExpectation("classpath:/AtIndexProcessor_source.xml", AtIndexProcessor_source);
    }

    @Test
    public void testSourceAndValue() throws Exception {
        assertExpectation("classpath:/AtIndexProcessor_sourceAndValue.xml", AtIndexProcessor_sourceAndValue);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/AtIndexProcessor_fullLoad.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testMissingSourceAndValue() throws Exception {
        loadFile("classpath:/AtIndexProcessor_missingSourceAndValue.xml");
    }
}
