/* * Copyright (C) 2017 Miles Talmey. * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT). */package com.emarte.regurgitator.test;import com.emarte.regurgitator.core.CreateResponseXmlLoader;import com.emarte.regurgitator.core.RegurgitatorException;import org.junit.Test;import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;public class CreateResponseXmlLoaderTest extends XmlLoaderTest {    public CreateResponseXmlLoaderTest() {        super(new CreateResponseXmlLoader());    }    @Test    public void testValue() throws Exception {        assertExpectation("classpath:/CreateResponse_value.xml", "com.emarte.regurgitator.core.CreateResponse:['create-response-1',com.emarte.regurgitator.core.ValueSource:[null,'value'],null]");    }    @Test    public void testFile() throws Exception {        assertExpectation("classpath:/CreateResponse_file.xml", "com.emarte.regurgitator.core.CreateResponse:['create-response-1',com.emarte.regurgitator.core.ValueSource:[null,'file-value'],null]");    }    @Test    public void testSource() throws Exception {        assertExpectation("classpath:/CreateResponse_source.xml", "com.emarte.regurgitator.core.CreateResponse:['create-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['context:location'],null],null]");    }    @Test    public void testSourceAndValue() throws Exception {        assertExpectation("classpath:/CreateResponse_sourceAndValue.xml", "com.emarte.regurgitator.core.CreateResponse:['create-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['context:location'],'value'],null]");    }    @Test    public void testSourceAndFile() throws Exception {        assertExpectation("classpath:/CreateResponse_sourceAndFile.xml", "com.emarte.regurgitator.core.CreateResponse:['create-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['context:location'],'file-value'],null]");    }    @Test    public void testProcessor() throws Exception {        assertExpectation("classpath:/CreateResponse_processor.xml", "com.emarte.regurgitator.core.CreateResponse:['create-response-1',com.emarte.regurgitator.core.ValueSource:[null,'value'],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");    }    @Test    public void testProcessorConfig() throws Exception {        assertExpectation("classpath:/CreateResponse_processorConfig.xml", "com.emarte.regurgitator.core.CreateResponse:['create-response-1',com.emarte.regurgitator.core.ValueSource:[null,'value'],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");    }    @Test    public void testFullLoadXml() throws Exception {        loadFile("classpath:/CreateResponse_file.xml");    }    @Test(expected = RegurgitatorException.class)    public void testValueAndFileException() throws Exception {        loadFromFile("classpath:/CreateResponse_valueAndFile.xml");    }    @Test(expected = RegurgitatorException.class)    public void testNothingException() throws Exception {        loadFromFile("classpath:/CreateResponse_nothing.xml");    }    @Test(expected = RegurgitatorException.class)    public void testMissingFileException() throws Exception {        loadFromFile("classpath:/CreateResponse_missingFile.xml");    }}