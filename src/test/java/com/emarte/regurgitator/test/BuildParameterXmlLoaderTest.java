package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.*;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class BuildParameterXmlLoaderTest extends XmlBaseTest {
	private BuildParameterXmlLoader toTest = new BuildParameterXmlLoader();

	@Test
	public void testMinimumXml() throws Exception {
		assertExpectation(getElement("classpath:/BuildParameter_min.xml"), "com.emarte.regurgitator.core.BuildParameter:['build-param-1',com.emarte.regurgitator.core.ParameterPrototype:['toTest1',com.emarte.regurgitator.core.StringType:[],com.emarte.regurgitator.core.ConflictPolicy:REPLACE],'parameters',com.emarte.regurgitator.test.stuff.TestValueBuilder:[],null]");
	}

	@Test
	public void testMinimumFlatXml() throws Exception {
		assertExpectation(getElement("classpath:/BuildParameter_min_flat.xml"), "com.emarte.regurgitator.core.BuildParameter:['build-param-1',com.emarte.regurgitator.core.ParameterPrototype:['toTest1',com.emarte.regurgitator.core.StringType:[],com.emarte.regurgitator.core.ConflictPolicy:REPLACE],'parameters',com.emarte.regurgitator.test.stuff.TestValueBuilder:[],null]");
	}

	@Test
	public void testMaximumXml() throws Exception {
		assertExpectation(getElement("classpath:/BuildParameter_max.xml"), "com.emarte.regurgitator.core.BuildParameter:['build-param-2',com.emarte.regurgitator.core.ParameterPrototype:['toTest2',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'something',com.emarte.regurgitator.test.stuff.TestValueBuilder:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
	}

	@Test
	public void testMaximumFlatXml() throws Exception {
		assertExpectation(getElement("classpath:/BuildParameter_max_flat.xml"), "com.emarte.regurgitator.core.BuildParameter:['build-param-2',com.emarte.regurgitator.core.ParameterPrototype:['toTest2',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'something',com.emarte.regurgitator.test.stuff.TestValueBuilder:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
	}

	@Test
	public void testMaximumHalfFlatBuilderXml() throws Exception {
		assertExpectation(getElement("classpath:/BuildParameter_max_half_flat_builder.xml"), "com.emarte.regurgitator.core.BuildParameter:['build-param-2',com.emarte.regurgitator.core.ParameterPrototype:['toTest2',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'something',com.emarte.regurgitator.test.stuff.TestValueBuilder:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
	}

	@Test
	public void testMaximumHalfFlatProcessorXml() throws Exception {
		assertExpectation(getElement("classpath:/BuildParameter_max_half_flat_processor.xml"), "com.emarte.regurgitator.core.BuildParameter:['build-param-2',com.emarte.regurgitator.core.ParameterPrototype:['toTest2',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'something',com.emarte.regurgitator.test.stuff.TestValueBuilder:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
	}

	@Test
	public void testFullLoadXml() throws Exception {
		ConfigurationFile.loadFile("classpath:/BuildParameter_max.xml");
	}

	private void assertExpectation(Element element, String expected) throws RegurgitatorException {
		assertEquals(expected, toTest.load(element, new HashSet<Object>()).toString());
	}

	@Test(expected = RegurgitatorException.class)
	public void testInvalidXmlMissingBuilder() throws Exception {
		toTest.load(getElement("classpath:/BuildParameter_missingBuilder.xml"), new HashSet<Object>());
	}

	@Test(expected = RegurgitatorException.class)
	public void testInvalidXmlMissingBuilderClass() throws Exception {
		toTest.load(getElement("classpath:/BuildParameter_missingBuilderClass.xml"), new HashSet<Object>());
	}

	@Test(expected = RegurgitatorException.class)
	public void testInvalidXmlMissingProcessorClass() throws Exception {
		toTest.load(getElement("classpath:/BuildParameter_missingProcessorClass.xml"), new HashSet<Object>());
	}
}
