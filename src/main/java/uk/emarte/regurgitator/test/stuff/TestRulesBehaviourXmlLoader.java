/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test.stuff;

import uk.emarte.regurgitator.core.XmlLoader;
import org.w3c.dom.Element;

import java.util.Set;

public class TestRulesBehaviourXmlLoader implements XmlLoader<TestRulesBehaviour> {
    @Override
    public TestRulesBehaviour load(Element element, Set<Object> allIds) {
        return new TestRulesBehaviour();
    }
}
