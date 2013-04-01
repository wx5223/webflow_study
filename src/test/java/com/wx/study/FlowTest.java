package com.wx.study;

import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

/** 
 * @Description
 * @date 2013-3-21
 * @author WangXin
 */
public class FlowTest extends AbstractXmlFlowExecutionTests
{

    @Override
    protected FlowDefinitionResource getResource(
            FlowDefinitionResourceFactory resourceFactory)
    {
        return null;
    }

}

