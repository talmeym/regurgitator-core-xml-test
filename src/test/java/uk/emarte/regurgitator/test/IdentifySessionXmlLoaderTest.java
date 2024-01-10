/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import org.junit.Test;
import uk.emarte.regurgitator.core.IdentifySessionXmlLoader;
import uk.emarte.regurgitator.core.RegurgitatorException;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.*;

public class IdentifySessionXmlLoaderTest extends XmlLoaderTest {
    public IdentifySessionXmlLoaderTest() {
        super(new IdentifySessionXmlLoader());
    }

    @Test
    public void testValue() throws Exception {
        assertExpectation("classpath:/IdentifySession_value.xml", IdentifySession_value);
    }

    @Test
    public void testSource() throws Exception {
        assertExpectation("classpath:/IdentifySession_source.xml", IdentifySession_source);
    }

    @Test
    public void testSourceAndValue() throws Exception {
        assertExpectation("classpath:/IdentifySession_sourceAndValue.xml", IdentifySession_sourceAndValue);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/IdentifySession_source.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testMissingSource() throws Exception {
        loadFromFile("classpath:/IdentifySession_missingSource.xml");
    }
}
