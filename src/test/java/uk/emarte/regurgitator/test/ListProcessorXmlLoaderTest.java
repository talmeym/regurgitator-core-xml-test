/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import uk.emarte.regurgitator.core.ListProcessorXmlLoader;
import uk.emarte.regurgitator.core.RegurgitatorException;
import org.junit.Test;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.*;

public class ListProcessorXmlLoaderTest extends XmlLoaderTest {
    public ListProcessorXmlLoaderTest() {
        super(new ListProcessorXmlLoader());
    }

    @Test
    public void testThis() throws Exception {
        assertExpectation("classpath:/ListProcessor.xml", ListProcessor);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/ListProcessor_fullLoad.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testMissingProcessors() throws RegurgitatorException {
        loadFile("classpath:/ListProcessor_missingProcessors.xml");
    }
}
