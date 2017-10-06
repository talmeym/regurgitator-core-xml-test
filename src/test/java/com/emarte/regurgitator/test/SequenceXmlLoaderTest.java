/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.SequenceXmlLoader;
import org.junit.Test;
import org.xml.sax.SAXException;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class SequenceXmlLoaderTest extends XmlLoaderTest {
    public SequenceXmlLoaderTest() {
        super(new SequenceXmlLoader());
    }

    @Test
    public void testMinimumXml() throws Exception {
        assertExpectation("classpath:/Sequence_min.xml", "com.emarte.regurgitator.core.Sequence:['sequence-1',[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1']],null]");
    }

    @Test
    public void testMaximumXml() throws Exception {
        assertExpectation("classpath:/Sequence_max.xml", "com.emarte.regurgitator.core.Sequence:['sequence-1',[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-2'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-3']],com.emarte.regurgitator.core.Isolate:[true,true]]");
    }

    @Test
    public void testIsolateXml() throws Exception {
        assertExpectation("classpath:/Sequence_isolate.xml", "com.emarte.regurgitator.core.Sequence:['sequence-1',[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-2'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-3']],com.emarte.regurgitator.core.Isolate:[false,false]]");
    }

    @Test
    public void testIsolateWithParamsXml() throws Exception {
        assertExpectation("classpath:/Sequence_isolateParams.xml", "com.emarte.regurgitator.core.Sequence:['sequence-1',[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-2'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-3']],com.emarte.regurgitator.core.Isolate:[false,true]]");
    }

    @Test
    public void testIsolateWithSessionXml() throws Exception {
        assertExpectation("classpath:/Sequence_isolateSession.xml", "com.emarte.regurgitator.core.Sequence:['sequence-1',[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-2'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-3']],com.emarte.regurgitator.core.Isolate:[true,false]]");
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/Sequence_max.xml");
    }

    @Test(expected = SAXException.class)
    public void testMissingStepXml() throws Exception {
        loadFromFile("classpath:/Sequence_missingStep.xml");
    }
}
