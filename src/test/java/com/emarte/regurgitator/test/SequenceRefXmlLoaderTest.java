package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.SequenceRefXmlLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class SequenceRefXmlLoaderTest extends XmlLoaderTest {
	public SequenceRefXmlLoaderTest() {
		super(new SequenceRefXmlLoader());
	}

	@Test
	public void testMinimumXml() throws Exception {
		assertExpectation("classpath:/SequenceRef_min.xml", "com.emarte.regurgitator.core.Sequence:['regurgitator-configuration-1',[com.emarte.regurgitator.core.CreateParameter:['create-param-1',com.emarte.regurgitator.core.ParameterPrototype:['toTest1',com.emarte.regurgitator.core.StringType:[],com.emarte.regurgitator.core.ConflictPolicy:REPLACE],'parameters',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['context:location'],null],null]]]");
	}

	@Test
	public void testFullLoadXml() throws Exception {
		loadFile("classpath:/SequenceRef_min.xml");
	}
}
