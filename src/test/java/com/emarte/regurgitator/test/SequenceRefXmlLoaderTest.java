/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.SequenceRefXmlLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.test.CoreLoaderTestExpectations.*;

public class SequenceRefXmlLoaderTest extends XmlLoaderTest {
    public SequenceRefXmlLoaderTest() {
        super(new SequenceRefXmlLoader());
    }

    @Test
    public void testMinimum() throws Exception {
        assertExpectation("classpath:/SequenceRef_min.xml", SequenceRef_min);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/SequenceRef_min.xml");
    }
}
