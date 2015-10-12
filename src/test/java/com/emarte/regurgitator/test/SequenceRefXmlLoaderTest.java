package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class SequenceRefXmlLoaderTest extends XmlBaseTest {
	private SequenceRefXmlLoader toTest = new SequenceRefXmlLoader();

	@Test
	public void testMinimumXml() throws Exception {
		assertExpectation(getElement("classpath:/SequenceRef_min.xml"), "com.emarte.regurgitator.core.Sequence:['regurgitator-configuration-1',[com.emarte.regurgitator.core.CreateParameter:['create-param-1',com.emarte.regurgitator.core.ParameterPrototype:['toTest1',com.emarte.regurgitator.core.StringType:[],com.emarte.regurgitator.core.ConflictPolicy:REPLACE],'parameters',com.emarte.regurgitator.core.ContextLocation:['context:location'],null,null]]]");
	}

	@Test
	public void testFullLoadXml() throws Exception {
		ConfigurationFile.loadFile("classpath:/SequenceRef_min.xml");
	}

	private void assertExpectation(Element element, String expected) throws RegurgitatorException {
		assertEquals(expected, toTest.load(element, new HashSet<Object>()).toString());
	}
}
