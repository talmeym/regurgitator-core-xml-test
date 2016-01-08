package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.IsolateXmlLoader;
import org.junit.Test;

public class IsolateXmlLoaderTest extends XmlLoaderTest {
	public IsolateXmlLoaderTest() {
		super(new IsolateXmlLoader());
	}

	@Test
	public void testMin() throws Exception {
		assertExpectation("classpath:/Isolate_min.xml", "com.emarte.regurgitator.core.Isolate:['isolate-1',com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'],false,false]");
	}

	@Test
	public void testSession() throws Exception {
		assertExpectation("classpath:/Isolate_session.xml", "com.emarte.regurgitator.core.Isolate:['isolate-1',com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'],true,false]");
	}

	@Test
	public void testParameters() throws Exception {
		assertExpectation("classpath:/Isolate_parameters.xml", "com.emarte.regurgitator.core.Isolate:['isolate-1',com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'],false,true]");
	}
}
