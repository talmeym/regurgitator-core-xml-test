/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import uk.emarte.regurgitator.core.NumberGeneratorXmlLoader;
import org.junit.Test;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.*;

public class NumberGeneratorXmlLoaderTest extends XmlLoaderTest {
    public NumberGeneratorXmlLoaderTest() {
        super(new NumberGeneratorXmlLoader());
    }

    @Test
    public void testThis() throws Exception {
        assertExpectation("classpath:/NumberGenerator.xml", NumberGenerator);
    }

    @Test
    public void testMaximum() throws Exception {
        assertExpectation("classpath:/NumberGenerator_max.xml", NumberGenerator_max);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/NumberGenerator_fullLoad.xml");
    }
}
