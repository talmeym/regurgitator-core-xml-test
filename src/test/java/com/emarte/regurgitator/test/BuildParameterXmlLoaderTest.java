package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class BuildParameterXmlLoaderTest extends XmlLoaderTest {
	public BuildParameterXmlLoaderTest() {
		super(new BuildParameterXmlLoader());
	}

	@Test
	public void testMinimumXml() throws Exception {
		assertExpectation("classpath:/BuildParameter_min.xml", "com.emarte.regurgitator.core.BuildParameter:['build-param-1',com.emarte.regurgitator.core.ParameterPrototype:['toTest1',com.emarte.regurgitator.core.StringType:[],com.emarte.regurgitator.core.ConflictPolicy:REPLACE],'parameters',com.emarte.regurgitator.test.stuff.TestValueBuilder:[],null]");
	}

	@Test
	public void testMinimumFlatXml() throws Exception {
		assertExpectation("classpath:/BuildParameter_minFlat.xml", "com.emarte.regurgitator.core.BuildParameter:['build-param-1',com.emarte.regurgitator.core.ParameterPrototype:['toTest1',com.emarte.regurgitator.core.StringType:[],com.emarte.regurgitator.core.ConflictPolicy:REPLACE],'parameters',com.emarte.regurgitator.test.stuff.TestValueBuilder:[],null]");
	}

	@Test
	public void testMaximumXml() throws Exception {
		assertExpectation("classpath:/BuildParameter_max.xml", "com.emarte.regurgitator.core.BuildParameter:['build-param-2',com.emarte.regurgitator.core.ParameterPrototype:['toTest2',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'something',com.emarte.regurgitator.test.stuff.TestValueBuilder:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
	}

	@Test
	public void testMaximumFlatXml() throws Exception {
		assertExpectation("classpath:/BuildParameter_max_flat.xml", "com.emarte.regurgitator.core.BuildParameter:['build-param-2',com.emarte.regurgitator.core.ParameterPrototype:['toTest2',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'something',com.emarte.regurgitator.test.stuff.TestValueBuilder:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
	}

	@Test
	public void testMaximumHalfFlatBuilderXml() throws Exception {
		assertExpectation("classpath:/BuildParameter_maxHalfFlatBuilder.xml", "com.emarte.regurgitator.core.BuildParameter:['build-param-2',com.emarte.regurgitator.core.ParameterPrototype:['toTest2',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'something',com.emarte.regurgitator.test.stuff.TestValueBuilder:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
	}

	@Test
	public void testMaximumHalfFlatProcessorXml() throws Exception {
		assertExpectation("classpath:/BuildParameter_maxHalfFlatProcessor.xml", "com.emarte.regurgitator.core.BuildParameter:['build-param-2',com.emarte.regurgitator.core.ParameterPrototype:['toTest2',com.emarte.regurgitator.core.NumberType:[],com.emarte.regurgitator.core.ConflictPolicy:LEAVE],'something',com.emarte.regurgitator.test.stuff.TestValueBuilder:[],com.emarte.regurgitator.test.stuff.TestValueProcessor:[]]");
	}

	@Test
	public void testFullLoadXml() throws Exception {
		loadFile("classpath:/BuildParameter_max.xml");
	}

	@Test(expected = RegurgitatorException.class)
	public void testInvalidXmlMissingBuilder() throws Exception {
		loadFromFile("classpath:/BuildParameter_missingBuilder.xml");
	}

	@Test(expected = RegurgitatorException.class)
	public void testInvalidXmlMissingBuilderClass() throws Exception {
		loadFromFile("classpath:/BuildParameter_missingBuilderClass.xml");
	}

	@Test(expected = RegurgitatorException.class)
	public void testInvalidXmlMissingProcessorClass() throws Exception {
		loadFromFile("classpath:/BuildParameter_missingProcessorClass.xml");
	}
}
