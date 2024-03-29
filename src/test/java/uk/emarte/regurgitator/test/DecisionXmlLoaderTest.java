/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import org.junit.Test;
import uk.emarte.regurgitator.core.DecisionXmlLoader;
import uk.emarte.regurgitator.core.RegurgitatorException;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.*;

public class DecisionXmlLoaderTest extends XmlLoaderTest {
    public DecisionXmlLoaderTest() {
        super(new DecisionXmlLoader());
    }

    @Test
    public void testMinimum() throws Exception {
        assertExpectation("classpath:/Decision_min.xml", Decision_min);
    }

    @Test
    public void testMaximum() throws Exception {
        assertExpectation("classpath:/Decision_max.xml", Decision_max);
    }

    @Test
    public void testMaximumMaximum() throws Exception {
        assertExpectation("classpath:/Decision_maxMax.xml", Decision_maxMax);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/Decision_max.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testMissingStep() throws Exception {
        loadFromFile("classpath:/Decision_missingStep.xml");
    }
}
