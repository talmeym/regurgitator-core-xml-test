/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class IndexOfProcessorXmlLoaderTest extends XmlLoaderTest {
    public IndexOfProcessorXmlLoaderTest() {
        super(new IndexOfProcessorXmlLoader());
    }

    @Test
    public void testSource() throws Exception {
        assertExpectation("classpath:/IndexOfProcessor_source.xml", "com.emarte.regurgitator.core.IndexOfProcessor:[com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['context:location'],null],false]");
    }

    @Test
    public void testValue() throws Exception {
        assertExpectation("classpath:/IndexOfProcessor_value.xml", "com.emarte.regurgitator.core.IndexOfProcessor:[com.emarte.regurgitator.core.ValueSource:[null,'value'],false]");
    }

    @Test
    public void testSourceAndValue() throws Exception {
        assertExpectation("classpath:/IndexOfProcessor_sourceAndValue.xml", "com.emarte.regurgitator.core.IndexOfProcessor:[com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['context:location'],'value'],false]");
    }

    @Test
    public void testFullLoad() throws RegurgitatorException {
        loadFile("classpath:/IndexOfProcessor_fullLoad.xml");
    }
}
