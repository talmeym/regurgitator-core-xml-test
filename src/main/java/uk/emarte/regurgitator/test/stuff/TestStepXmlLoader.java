/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test.stuff;

import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.core.Step;
import uk.emarte.regurgitator.core.XmlLoader;
import org.w3c.dom.Element;

import java.util.Set;

import static uk.emarte.regurgitator.core.XmlConfigUtil.loadId;

public class TestStepXmlLoader implements XmlLoader<Step> {
    @Override
    public Step load(Element element, Set<Object> allIds) throws RegurgitatorException {
        return new TestStep(loadId(element, allIds));
    }
}
