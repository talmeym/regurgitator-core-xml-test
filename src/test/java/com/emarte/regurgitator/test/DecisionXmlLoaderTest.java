/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.DecisionXmlLoader;
import com.emarte.regurgitator.core.RegurgitatorException;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class DecisionXmlLoaderTest extends XmlLoaderTest {
    public DecisionXmlLoaderTest() {
        super(new DecisionXmlLoader());
    }

    @Test
    public void testSuperMinimumXml() throws Exception {
        assertExpectation("classpath:/Decision_min.xml", "com.emarte.regurgitator.core.Decision:['decision-1',[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1']],[com.emarte.regurgitator.core.Rule:['rule-1',[com.emarte.regurgitator.core.Condition:['condition-1',com.emarte.regurgitator.core.ContextLocation:['context:location'],'value',true,com.emarte.regurgitator.core.ContainsBehaviour:[]]],'test-step-1']],com.emarte.regurgitator.core.FirstMatchBehaviour:[],null]");
    }

    @Test
    public void testMaximumXml() throws Exception {
        assertExpectation("classpath:/Decision_max.xml", "com.emarte.regurgitator.core.Decision:['decision-1',[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-2']],[com.emarte.regurgitator.core.Rule:['rule-1',[com.emarte.regurgitator.core.Condition:['condition-1',com.emarte.regurgitator.core.ContextLocation:['context:location1'],'value1',false,com.emarte.regurgitator.core.EqualsBehaviour:[]], com.emarte.regurgitator.core.Condition:['condition-2',com.emarte.regurgitator.core.ContextLocation:['context:location2'],'value2',true,com.emarte.regurgitator.test.stuff.TestConditionBehaviour:[]]],'test-step-1'], com.emarte.regurgitator.core.Rule:['rule-2',[com.emarte.regurgitator.core.Condition:['condition-3',com.emarte.regurgitator.core.ContextLocation:['context:location3'],'value3',false,com.emarte.regurgitator.core.EqualsBehaviour:[]], com.emarte.regurgitator.core.Condition:['condition-4',com.emarte.regurgitator.core.ContextLocation:['context:location4'],'value4',true,com.emarte.regurgitator.test.stuff.TestConditionBehaviour:[]]],'test-step-2']],com.emarte.regurgitator.test.stuff.TestRulesBehaviour:[],'test-step-2']");
    }

    @Test
    public void testSuperMaximalXml() throws Exception {
        assertExpectation("classpath:/Decision_max_max.xml", "com.emarte.regurgitator.core.Decision:['decision-1',[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-2']],[com.emarte.regurgitator.core.Rule:['rule-1',[com.emarte.regurgitator.core.Condition:['condition-1',com.emarte.regurgitator.core.ContextLocation:['context:location1'],'value1',false,com.emarte.regurgitator.core.EqualsBehaviour:[]], com.emarte.regurgitator.core.Condition:['condition-2',com.emarte.regurgitator.core.ContextLocation:['context:location2'],'value2',true,com.emarte.regurgitator.test.stuff.TestConditionBehaviour:[]]],'test-step-1'], com.emarte.regurgitator.core.Rule:['rule-2',[com.emarte.regurgitator.core.Condition:['condition-3',com.emarte.regurgitator.core.ContextLocation:['context:location3'],'value3',false,com.emarte.regurgitator.core.EqualsBehaviour:[]], com.emarte.regurgitator.core.Condition:['condition-4',com.emarte.regurgitator.core.ContextLocation:['context:location4'],'value4',true,com.emarte.regurgitator.test.stuff.TestConditionBehaviour:[]]],'test-step-2']],com.emarte.regurgitator.test.stuff.TestRulesBehaviour:[],'test-step-2']");
    }

    @Test
    public void testFullLoadXml() throws Exception {
        loadFile("classpath:/Decision_max.xml");
    }

    @Test(expected = RegurgitatorException.class)
    public void testMissingStepXml() throws Exception {
        loadFromFile("classpath:/Decision_missingStep.xml");
    }
}
