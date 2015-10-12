package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import org.dom4j.*;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class SequenceXmlLoaderTest extends XmlBaseTest {
	private SequenceXmlLoader toTest = new SequenceXmlLoader();

	@Test
	public void testMinimumXml() throws Exception {
		assertExpectation(getElement("classpath:/Sequence_min.xml"), "com.emarte.regurgitator.core.Sequence:['sequence-1',[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1']]]");
	}

	@Test
	public void testMaximumXml() throws Exception {
		assertExpectation(getElement("classpath:/Sequence_max.xml"), "com.emarte.regurgitator.core.Sequence:['sequence-1',[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-2'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-3']]]");
	}

	@Test
	public void testFullLoad() throws Exception {
		ConfigurationFile.loadFile("classpath:/Sequence_max.xml");
	}

	@Test(expected = DocumentException.class)
	public void testMissingStepXml() throws Exception {
		toTest.load(getElement("classpath:/Sequence_missingStep.xml"), new HashSet<Object>());
	}

	private void assertExpectation(Element element, String expected) throws RegurgitatorException {
		assertEquals(expected, toTest.load(element, new HashSet<Object>()).toString());
	}
}
