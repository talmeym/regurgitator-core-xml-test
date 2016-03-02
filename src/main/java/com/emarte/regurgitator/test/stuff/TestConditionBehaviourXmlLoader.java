package com.emarte.regurgitator.test.stuff;

import com.emarte.regurgitator.core.*;
import org.dom4j.Element;

import java.util.Set;

public class TestConditionBehaviourXmlLoader implements XmlLoader<TestConditionBehaviour> {
	@Override
	public TestConditionBehaviour load(Element element, Set<Object> allIds) throws RegurgitatorException {
		return new TestConditionBehaviour();
	}
}
