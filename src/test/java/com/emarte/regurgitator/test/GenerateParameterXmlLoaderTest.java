package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.*;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class GenerateParameterXmlLoaderTest extends XmlBaseTest {
	private GenerateParameterXmlLoader toTest = new GenerateParameterXmlLoader();

	@Test
	public void testMinimumXml() throws Exception {
		assertExpectation(getElement("classpath:/GenerateParameter_min.xml"), "com.emarte.regurgitator.core.GenerateParameter:['generate-parameter-1',com.emarte.regurgitator.core.ParameterPrototype:['name',com.emarte.regurgitator.core.StringType:[],com.emarte.regurgitator.core.ConflictPolicy:REPLACE],'parameters',com.emarte.regurgitator.core.UuidGenerator:[],null]");
	}

	@Test
	public void testMaximumXml() throws Exception {
		assertExpectation(getElement("classpath:/GenerateParameter_max.xml"), "com.emarte.regurgitator.core.GenerateParameter:['generate-parameter-1',com.emarte.regurgitator.core.ParameterPrototype:['name',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'context',com.emarte.regurgitator.test.stuff.TestValueGenerator:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
	}

	@Test
	public void testMaximumFlatXml() throws Exception {
		assertExpectation(getElement("classpath:/GenerateParameter_max_flat.xml"), "com.emarte.regurgitator.core.GenerateParameter:['generate-parameter-1',com.emarte.regurgitator.core.ParameterPrototype:['name',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'context',com.emarte.regurgitator.test.stuff.TestValueGenerator:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
	}

	@Test
	public void testMaximumHalfFlatGeneratorXml() throws Exception {
		assertExpectation(getElement("classpath:/GenerateParameter_maxHalfFlatGenerator.xml"), "com.emarte.regurgitator.core.GenerateParameter:['generate-parameter-1',com.emarte.regurgitator.core.ParameterPrototype:['name',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'context',com.emarte.regurgitator.test.stuff.TestValueGenerator:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
	}

	@Test
	public void testMaximumHalfFlatProcessorXml() throws Exception {
		assertExpectation(getElement("classpath:/GenerateParameter_maxHalfFlatProcessor.xml"), "com.emarte.regurgitator.core.GenerateParameter:['generate-parameter-1',com.emarte.regurgitator.core.ParameterPrototype:['name',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'context',com.emarte.regurgitator.test.stuff.TestValueGenerator:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
	}

	@Test
	public void testFullLoadXml() throws Exception {
		ConfigurationFile.loadFile("classpath:/GenerateParameter_max.xml");
	}

	private void assertExpectation(Element element, String expected) throws RegurgitatorException {
		assertEquals(expected, toTest.load(element, new HashSet<Object>()).toString());
	}

	@Test(expected = RegurgitatorException.class)
	public void testInvalidXmlMissingGenerator() throws Exception {
		toTest.load(getElement("classpath:/GenerateParameter_missingGenerator.xml"), new HashSet<Object>());
	}

	@Test(expected = RegurgitatorException.class)
	public void testInvalidXmlMissingGeneratorClass() throws Exception {
		toTest.load(getElement("classpath:/GenerateParameter_missingGeneratorClass.xml"), new HashSet<Object>());
	}

	@Test(expected = RegurgitatorException.class)
	public void testInvalidXmlMissingProcessorClass() throws Exception {
		toTest.load(getElement("classpath:/GenerateParameter_missingProcessorClass.xml"), new HashSet<Object>());
	}
}
