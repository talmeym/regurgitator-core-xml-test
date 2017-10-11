/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test.stuff;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.core.XmlLoader;
import org.w3c.dom.Element;

import java.util.Set;

public class TestValueProcessorXmlLoader implements XmlLoader<TestValueProcessor> {
    @Override
    public TestValueProcessor load(Element element, Set<Object> allIds) throws RegurgitatorException {
        return new TestValueProcessor();
    }
}
