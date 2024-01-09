/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import uk.emarte.regurgitator.core.GenerateParameterXmlLoader;
import uk.emarte.regurgitator.core.RegurgitatorException;
import org.junit.Test;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.*;

public class GenerateParameterXmlLoaderTest extends XmlLoaderTest {
    public GenerateParameterXmlLoaderTest() {
        super(new GenerateParameterXmlLoader());
    }

    @Test
    public void testMinimum() throws Exception {
        assertExpectation("classpath:/GenerateParameter_min.xml", GenerateParameter_min);
    }

    @Test
    public void testMaximum() throws Exception {
        assertExpectation("classpath:/GenerateParameter_max.xml", GenerateParameter_max);
    }

    @Test
    public void testMaximumFlat() throws Exception {
        assertExpectation("classpath:/GenerateParameter_maxFlat.xml", GenerateParameter_maxFlat);
    }

    @Test
    public void testMaximumHalfFlatGenerator() throws Exception {
        assertExpectation("classpath:/GenerateParameter_maxHalfFlatGenerator.xml", GenerateParameter_maxHalfFlatGenerator);
    }

    @Test
    public void testMaximumHalfFlatProcessor() throws Exception {
        assertExpectation("classpath:/GenerateParameter_maxHalfFlatProcessor.xml", GenerateParameter_maxHalfFlatProcessor);
    }

    @Test
    public void testMultipleProcessors() throws Exception {
        assertExpectation("classpath:/GenerateParameter_multipleProcessors.xml", GenerateParameter_multipleProcessors);
    }

    @Test
    public void testMultipleProcessorsFlat() throws Exception {
        assertExpectation("classpath:/GenerateParameter_multipleProcessorsFlat.xml", GenerateParameter_multipleProcessorsFlat);
    }

    @Test
    public void testFullLoad() throws Exception {
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
