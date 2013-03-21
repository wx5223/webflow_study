package com.wx.study;

import org.springframework.binding.mapping.Mapper;
import org.springframework.binding.mapping.MappingResults;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.core.collection.AttributeMap;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.engine.EndState;
import org.springframework.webflow.engine.Flow;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

/**
 * @Description
 * @date 2013-3-19
 * @author WangXin
 */
public class BookingFlowExecutionTests extends AbstractXmlFlowExecutionTests
{

    /**
     * If your flow has dependencies on externally managed services, also
     * override configureFlowBuilderContext(MockFlowBuilderContext) to register
     * stubs or mocks of those services:
     */
    /*
     * @Override protected void configureFlowBuilderContext(
     * MockFlowBuilderContext builderContext) {
     * builderContext.registerBean("bookingService", new StubBookingService());
     * }
     */

    /**
     * If your flow extends from another flow, or has states that extend other
     * states, also override getModelResources(FlowDefinitionResourceFactory) to
     * return the path to the parent flows.
     */
    /*
     * @Override protected FlowDefinitionResource[] getModelResources(
     * FlowDefinitionResourceFactory resourceFactory) { return new
     * FlowDefinitionResource[] { resourceFactory
     * .createFileResource("src/main/webapp/WEB-INF/common/common.xml") }; }
     */

    @Override
    protected FlowDefinitionResource getResource(
            FlowDefinitionResourceFactory resourceFactory)
    {
        return resourceFactory
                .createFileResource("src/main/webapp/WEB-INF/hotels/booking/booking.xml");
    }

    public void testStartBookingFlow()
    {

        Book booking = createTestBooking();

        MutableAttributeMap input = new LocalAttributeMap();
        input.put("hotelId", "1");
        MockExternalContext context = new MockExternalContext();
        context.setCurrentUser("keith");
        startFlow(input, context);

        assertCurrentStateEquals("enterBookingDetails");
        assertTrue(getRequiredFlowAttribute("booking") instanceof Book);
    }

    public void testEnterBookingDetails_Proceed()
    {

        setCurrentState("enterBookingDetails");

        getFlowScope().put("booking", createTestBooking());

        MockExternalContext context = new MockExternalContext();
        context.setEventId("proceed");
        resumeFlow(context);

        assertCurrentStateEquals("reviewBooking");
    }

    public void testBookHotel()
    {

        setCurrentState("reviewHotel");

        Hotel hotel = new Hotel();
        hotel.setId(1L);
        hotel.setName("Jameson Inn");
        getFlowScope().put("hotel", hotel);

        getFlowDefinitionRegistry().registerFlowDefinition(
                createMockBookingSubflow());

        MockExternalContext context = new MockExternalContext();
        context.setEventId("book");
        resumeFlow(context);

        // verify flow ends on 'bookingConfirmed'
        assertFlowExecutionEnded();
        assertFlowExecutionOutcomeEquals("finish");
    }

    /**
     * To test calling a subflow, register a mock implementation of the subflow
     * that asserts input was passed in correctly and returns the correct
     * outcome for your test scenario.
     * 
     * @return
     * @return Flow
     */
    public Flow createMockBookingSubflow()
    {
        Flow mockBookingFlow = new Flow("booking");
        mockBookingFlow.setInputMapper(new Mapper()
        {
            public MappingResults map(Object source, Object target)
            {
                // assert that 1L was passed in as input
                assertEquals(1L, ((AttributeMap) source).get("hotelId"));
                return null;
            }
        });
        // immediately return the bookingConfirmed outcome so the caller can
        // respond
        new EndState(mockBookingFlow, "bookingConfirmed");
        return mockBookingFlow;
    }

    private Book createTestBooking()
    {
        return null;
    }

}
