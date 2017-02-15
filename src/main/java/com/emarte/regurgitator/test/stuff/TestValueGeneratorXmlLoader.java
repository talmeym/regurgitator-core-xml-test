package com.emarte.regurgitator.test.stuff;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.Set;

public class TestValueGeneratorXmlLoader implements XmlLoader<ValueGenerator> {
	@Override
	public ValueGenerator load(Element element, Set<Object> allIds) throws RegurgitatorException {
		return new TestValueGenerator();
	}
}
