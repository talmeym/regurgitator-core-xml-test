/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test.stuff;

import org.w3c.dom.Element;
import uk.emarte.regurgitator.core.ValueGenerator;
import uk.emarte.regurgitator.core.XmlLoader;

import java.util.Set;

public class TestValueGeneratorXmlLoader implements XmlLoader<ValueGenerator> {
    @Override
    public ValueGenerator load(Element element, Set<Object> allIds) {
        return new TestValueGenerator();
    }
}
