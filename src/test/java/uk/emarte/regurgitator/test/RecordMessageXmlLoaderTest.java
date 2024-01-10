/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import org.junit.Test;
import uk.emarte.regurgitator.core.RecordMessageXmlLoader;

import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.RecordMessage_folder;
import static uk.emarte.regurgitator.test.CoreLoaderTestExpectations.RecordMessage_min;

public class RecordMessageXmlLoaderTest extends XmlLoaderTest {
    public RecordMessageXmlLoaderTest() {
        super(new RecordMessageXmlLoader());
    }

    @Test
    public void testMinimum() throws Exception {
        assertExpectation("classpath:/RecordMessage_min.xml", RecordMessage_min);
    }

    @Test
    public void testFolder() throws Exception {
        assertExpectation("classpath:/RecordMessage_folder.xml", RecordMessage_folder);
    }
}
