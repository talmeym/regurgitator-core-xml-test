/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import org.junit.Test;
import uk.emarte.regurgitator.core.SubstituteProcessorXmlLoader;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.SubstituteProcessor_min;

public class SubstituteProcessorXmlLoaderTest extends XmlLoaderTest {
    public SubstituteProcessorXmlLoaderTest() {
        super(new SubstituteProcessorXmlLoader());
    }

    @Test
    public void testMinimum() throws Exception {
        assertExpectation("classpath:/SubstituteProcessor_min.xml", SubstituteProcessor_min);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/SubstituteProcessor_fullLoad.xml");
    }
}
