/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.SequenceXmlLoader;
import org.junit.Test;
import org.xml.sax.SAXException;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.test.CoreLoaderTestExpectations.*;

public class SequenceXmlLoaderTest extends XmlLoaderTest {
    public SequenceXmlLoaderTest() {
        super(new SequenceXmlLoader());
    }

    @Test
    public void testMinimum() throws Exception {
        assertExpectation("classpath:/Sequence_min.xml", Sequence_min);
    }

    @Test
    public void testMaximum() throws Exception {
        assertExpectation("classpath:/Sequence_max.xml", Sequence_max);
    }

    @Test
    public void testIsolate() throws Exception {
        assertExpectation("classpath:/Sequence_isolate.xml", Sequence_isolate);
    }

    @Test
    public void testIsolateWithParams() throws Exception {
        assertExpectation("classpath:/Sequence_isolateParams.xml", Sequence_isolateParams);
    }

    @Test
    public void testIsolateWithSession() throws Exception {
        assertExpectation("classpath:/Sequence_isolateSession.xml", Sequence_isolateSession);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/Sequence_max.xml");
    }

    @Test(expected = SAXException.class)
    public void testMissingStep() throws Exception {
        loadFromFile("classpath:/Sequence_missingStep.xml");
    }
}
