/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.RemoveAtIndexProcessorXmlLoader;
import org.junit.Test;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.*;

public class RemoveAtIndexProcessorXmlLoaderTest extends XmlLoaderTest {
    public RemoveAtIndexProcessorXmlLoaderTest() {
        super(new RemoveAtIndexProcessorXmlLoader());
    }

    @Test
    public void testValue() throws Exception {
        assertExpectation("classpath:/RemoveAtIndexProcessor_Value.xml", RemoveAtIndexProcessor_value);
    }

    @Test
    public void testSource() throws Exception {
        assertExpectation("classpath:/RemoveAtIndexProcessor_source.xml", RemoveAtIndexProcessor_source);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/RemoveAtIndexProcessor_fullLoad.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testMissingIndexSource() throws Exception {
        loadFile("classpath:/RemoveAtIndexProcessor_missingIndexSource.xml");
    }
}
