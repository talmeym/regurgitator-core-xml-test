package com.emarte.regurgitator.test.stuff;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

public class TestValueProcessorXmlLoader implements XmlLoader<ValueProcessor> {
	@Override
	public ValueProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
		return new TestValueProcessor();
	}
}
