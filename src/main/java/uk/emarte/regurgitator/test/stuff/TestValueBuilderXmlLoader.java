/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test.stuff;

import org.w3c.dom.Element;
import uk.emarte.regurgitator.core.ValueBuilder;
import uk.emarte.regurgitator.core.XmlLoader;

import java.util.Set;

public class TestValueBuilderXmlLoader implements XmlLoader<ValueBuilder> {
    @Override
    public ValueBuilder load(Element element, Set<Object> allIds) {
        return new TestValueBuilder();
    }
}
