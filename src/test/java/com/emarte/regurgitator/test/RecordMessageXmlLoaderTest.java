package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RecordMessageXmlLoader;
import org.junit.Test;

public class RecordMessageXmlLoaderTest extends XmlLoaderTest {
    public RecordMessageXmlLoaderTest() {
        super(new RecordMessageXmlLoader());
    }

    @Test
    public void testMin() throws Exception {
        assertExpectation("classpath:/RecordMessage_min.xml", "com.emarte.regurgitator.core.RecordMessage:['record-message-1',null]");
    }

    @Test
    public void testFolder() throws Exception {
        assertExpectation("classpath:/RecordMessage_folder.xml", "com.emarte.regurgitator.core.RecordMessage:['record-message-1','/folder/folder']");
    }
}
