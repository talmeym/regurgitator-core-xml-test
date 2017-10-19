/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.GenerateParameterXmlLoader;
import com.emarte.regurgitator.core.RegurgitatorException;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class GenerateParameterXmlLoaderTest extends XmlLoaderTest {
    public GenerateParameterXmlLoaderTest() {
        super(new GenerateParameterXmlLoader());
    }

    @Test
    public void testMinimumXml() throws Exception {
        assertExpectation("classpath:/GenerateParameter_min.xml", "com.emarte.regurgitator.core.GenerateParameter:['generate-parameter-1',com.emarte.regurgitator.core.ParameterPrototype:['name',com.emarte.regurgitator.core.StringType:[],com.emarte.regurgitator.core.ConflictPolicy:REPLACE],'parameters',com.emarte.regurgitator.test.stuff.TestValueGenerator:[],null]");
    }

    @Test
    public void testMaximumXml() throws Exception {
        assertExpectation("classpath:/GenerateParameter_max.xml", "com.emarte.regurgitator.core.GenerateParameter:['generate-parameter-1',com.emarte.regurgitator.core.ParameterPrototype:['name',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'context',com.emarte.regurgitator.test.stuff.TestValueGenerator:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
    }

    @Test
    public void testMaximumFlatXml() throws Exception {
        assertExpectation("classpath:/GenerateParameter_max_flat.xml", "com.emarte.regurgitator.core.GenerateParameter:['generate-parameter-1',com.emarte.regurgitator.core.ParameterPrototype:['name',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'context',com.emarte.regurgitator.test.stuff.TestValueGenerator:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
    }

    @Test
    public void testMaximumHalfFlatGeneratorXml() throws Exception {
        assertExpectation("classpath:/GenerateParameter_maxHalfFlatGenerator.xml", "com.emarte.regurgitator.core.GenerateParameter:['generate-parameter-1',com.emarte.regurgitator.core.ParameterPrototype:['name',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'context',com.emarte.regurgitator.test.stuff.TestValueGenerator:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
    }

    @Test
    public void testMaximumHalfFlatProcessorXml() throws Exception {
        assertExpectation("classpath:/GenerateParameter_maxHalfFlatProcessor.xml", "com.emarte.regurgitator.core.GenerateParameter:['generate-parameter-1',com.emarte.regurgitator.core.ParameterPrototype:['name',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'context',com.emarte.regurgitator.test.stuff.TestValueGenerator:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
    }

    @Test
    public void testFullLoadXml() throws Exception {
        loadFile("classpath:/GenerateParameter_max.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testInvalidXmlMissingGenerator() throws Exception {
        loadFromFile("classpath:/GenerateParameter_missingGenerator.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testInvalidXmlMissingGeneratorClass() throws Exception {
        loadFromFile("classpath:/GenerateParameter_missingGeneratorClass.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testInvalidXmlMissingProcessorClass() throws Exception {
        loadFromFile("classpath:/GenerateParameter_missingProcessorClass.xml");
    }
}
