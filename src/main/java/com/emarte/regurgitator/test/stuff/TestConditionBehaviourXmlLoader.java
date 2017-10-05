package com.emarte.regurgitator.test.stuff;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.Set;

public class TestConditionBehaviourXmlLoader implements XmlLoader<TestConditionBehaviour> {
    @Override
    public TestConditionBehaviour load(Element element, Set<Object> allIds) throws RegurgitatorException {
        return new TestConditionBehaviour();
    }
}
