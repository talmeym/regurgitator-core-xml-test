/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import org.junit.Test;
import uk.emarte.regurgitator.core.UuidGeneratorXmlLoader;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.UuidGenerator;

public class UuidGeneratorXmlLoaderTest extends XmlLoaderTest {
    public UuidGeneratorXmlLoaderTest() {
        super(new UuidGeneratorXmlLoader());
    }

    @Test
    public void testLoader() throws Exception {
        assertExpectation("classpath:/UuidGenerator.xml", UuidGenerator);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/UuidGenerator_fullLoad.xml");
    }
}
