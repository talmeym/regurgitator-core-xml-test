/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class UuidGeneratorXmlLoaderTest extends XmlLoaderTest {
    public UuidGeneratorXmlLoaderTest() {
        super(new UuidGeneratorXmlLoader());
    }

    @Test
    public void testThis() throws Exception {
        assertExpectation("classpath:/UuidGenerator.xml", "com.emarte.regurgitator.core.UuidGenerator:[]");
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/UuidGenerator_fullLoad.xml");
    }
}
