package com.emarte.regurgitator.test.stuff;

import com.emarte.regurgitator.core.*;
import org.w3c.dom.Element;

import java.util.Set;

import static com.emarte.regurgitator.core.XmlConfigUtil.loadId;

public class TestStepXmlLoader implements XmlLoader<Step> {
	@Override
	public Step load(Element element, Set<Object> allIds) throws RegurgitatorException {
		return new TestStep(loadId(element, allIds));
	}
}
