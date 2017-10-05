package com.emarte.regurgitator.test.stuff;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.Set;

public class TestValueBuilderXmlLoader implements XmlLoader<ValueBuilder> {
    @Override
    public ValueBuilder load(Element element, Set<Object> allIds) throws RegurgitatorException {
        return new TestValueBuilder();
    }
}
