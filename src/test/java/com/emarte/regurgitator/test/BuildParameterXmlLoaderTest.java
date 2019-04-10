/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.BuildParameterXmlLoader;
import com.emarte.regurgitator.core.RegurgitatorException;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.test.CoreLoaderTestExpectations.*;

public class BuildParameterXmlLoaderTest extends XmlLoaderTest {
    public BuildParameterXmlLoaderTest() {
        super(new BuildParameterXmlLoader());
    }

    @Test
    public void testMinimum() throws Exception {
        assertExpectation("classpath:/BuildParameter_min.xml", BuildParameter_min);
    }

    @Test
    public void testMinimumFlat() throws Exception {
        assertExpectation("classpath:/BuildParameter_minFlat.xml", BuildParameter_minFlat);
    }

    @Test
    public void testMaximum() throws Exception {
        assertExpectation("classpath:/BuildParameter_max.xml", BuildParameter_max);
    }

    @Test
    public void testMaximumFlat() throws Exception {
        assertExpectation("classpath:/BuildParameter_maxFlat.xml", BuildParameter_maxFlat);
    }

    @Test
    public void testMaximumHalfFlatBuilder() throws Exception {
        assertExpectation("classpath:/BuildParameter_maxHalfFlatBuilder.xml", BuildParameter_maxHalfFlatBuilder);
    }

    @Test
    public void testMaximumHalfFlatProcessor() throws Exception {
        assertExpectation("classpath:/BuildParameter_maxHalfFlatProcessor.xml", BuildParameter_maxHalfFlatProcessor);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/BuildParameter_max.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testInvalidXmlMissingBuilder() throws Exception {
        loadFromFile("classpath:/BuildParameter_missingBuilder.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testInvalidXmlMissingBuilderClass() throws Exception {
        loadFromFile("classpath:/BuildParameter_missingBuilderClass.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testInvalidXmlMissingProcessorClass() throws Exception {
        loadFromFile("classpath:/BuildParameter_missingProcessorClass.xml");
    }
}
