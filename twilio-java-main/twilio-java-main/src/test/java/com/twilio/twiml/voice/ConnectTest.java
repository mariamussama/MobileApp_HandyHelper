/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.converter.Promoter;
import com.twilio.http.HttpMethod;
import com.twilio.twiml.GenericNode;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.util.List;

/**
 * Test class for {@link Connect}
 */
public class ConnectTest {
    @Test
    public void testEmptyElement() {
        Connect elem = new Connect.Builder().build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Connect/>",
            elem.toXml()
        );
    }

    @Test
    public void testEmptyElementUrl() {
        Connect elem = new Connect.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CConnect%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithParams() {
        Connect elem = new Connect.Builder().action(URI.create("https://example.com")).method(HttpMethod.GET).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Connect action=\"https://example.com\" method=\"GET\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithExtraAttributes() {
        Connect elem = new Connect.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Connect a=\"b\" foo=\"bar\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithChildren() {
        Connect.Builder builder = new Connect.Builder();

        builder.room(new Room.Builder("name").participantIdentity("participant_identity").build());

        builder.autopilot(new Autopilot.Builder("name").build());

        builder.stream(new Stream.Builder()
                    .name("name")
                    .connectorName("connector_name")
                    .url("url")
                    .track(Stream.Track.INBOUND_TRACK)
                    .statusCallback("status_callback")
                    .statusCallbackMethod(Stream.StatusCallbackMethod.GET)
                    .build());

        builder.virtualAgent(new VirtualAgent.Builder()
                    .connectorName("connector_name")
                    .language("language")
                    .sentimentAnalysis(true)
                    .statusCallback("status_callback")
                    .statusCallbackMethod(HttpMethod.GET)
                    .build());

        builder.conversation(new Conversation.Builder()
                    .serviceInstanceSid("service_instance_sid")
                    .inboundAutocreation(true)
                    .routingAssignmentTimeout(1)
                    .inboundTimeout(1)
                    .url(URI.create("https://example.com"))
                    .method(HttpMethod.GET)
                    .record(Conversation.Record.DO_NOT_RECORD)
                    .trim(Conversation.Trim.TRIM_SILENCE)
                    .recordingStatusCallback(URI.create("https://example.com"))
                    .recordingStatusCallbackMethod(HttpMethod.GET)
                    .recordingStatusCallbackEvents(Promoter.listOfOne(Conversation.RecordingEvent.IN_PROGRESS))
                    .statusCallback(URI.create("https://example.com"))
                    .statusCallbackMethod(HttpMethod.GET)
                    .statusCallbackEvents(Promoter.listOfOne(Conversation.Event.CALL_INITIATED))
                    .build());

        Connect elem = builder.build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Connect>" +
                "<Room participantIdentity=\"participant_identity\">name</Room>" +
                "<Autopilot>name</Autopilot>" +
                "<Stream connectorName=\"connector_name\" name=\"name\" statusCallback=\"status_callback\" statusCallbackMethod=\"GET\" track=\"inbound_track\" url=\"url\"/>" +
                "<VirtualAgent connectorName=\"connector_name\" language=\"language\" sentimentAnalysis=\"true\" statusCallback=\"status_callback\" statusCallbackMethod=\"GET\"/>" +
                "<Conversation inboundAutocreation=\"true\" inboundTimeout=\"1\" method=\"GET\" record=\"do-not-record\" recordingStatusCallback=\"https://example.com\" recordingStatusCallbackEvent=\"in-progress\" recordingStatusCallbackMethod=\"GET\" routingAssignmentTimeout=\"1\" serviceInstanceSid=\"service_instance_sid\" statusCallback=\"https://example.com\" statusCallbackEvent=\"call-initiated\" statusCallbackMethod=\"GET\" trim=\"trim-silence\" url=\"https://example.com\"/>" +
            "</Connect>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithTextNode() {
        Connect.Builder builder = new Connect.Builder();

        builder.addText("Hey no tags!");

        Connect elem = builder.build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Connect>" +
            "Hey no tags!" +
            "</Connect>",
            elem.toXml()
        );
    }

    @Test
    public void testMixedContent() {
        GenericNode.Builder child = new GenericNode.Builder("Child");
        child.addText("content");

        Connect.Builder builder = new Connect.Builder();

        builder.addText("before");
        builder.addChild(child.build());
        builder.addText("after");

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Connect>" +
            "before" +
            "<Child>content</Child>" +
            "after" +
            "</Connect>",
            builder.build().toXml()
        );
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        Connect.Builder builder = new Connect.Builder();
        Connect elem = builder.addChild(node).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Connect>" +
            "<genericTag>" +
            "Some text" +
            "</genericTag>" +
            "</Connect>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithGenericNodeAttributes() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        GenericNode node = genericBuilder.option("key", "value").addText("someText").build();

        Connect.Builder builder = new Connect.Builder();
        Connect elem = builder.addChild(node).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Connect>" +
            "<genericTag key=\"value\">" +
            "someText" +
            "</genericTag>" +
            "</Connect>",
            elem.toXml()
        );
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Connect elem = new Connect.Builder().action(URI.create("https://example.com")).method(HttpMethod.GET).build();

        Assert.assertEquals(
            Connect.Builder.fromXml("<Connect action=\"https://example.com\" method=\"GET\"/>").build().toXml(),
            elem.toXml()
        );
    }

    @Test
    public void testXmlChildrenDeserialization() {
        final Connect.Builder builder = new Connect.Builder();

        builder.room(new Room.Builder("name").participantIdentity("participant_identity").build());

        builder.autopilot(new Autopilot.Builder("name").build());

        builder.stream(new Stream.Builder()
                    .name("name")
                    .connectorName("connector_name")
                    .url("url")
                    .track(Stream.Track.INBOUND_TRACK)
                    .statusCallback("status_callback")
                    .statusCallbackMethod(Stream.StatusCallbackMethod.GET)
                    .build());

        builder.virtualAgent(new VirtualAgent.Builder()
                    .connectorName("connector_name")
                    .language("language")
                    .sentimentAnalysis(true)
                    .statusCallback("status_callback")
                    .statusCallbackMethod(HttpMethod.GET)
                    .build());

        builder.conversation(new Conversation.Builder()
                    .serviceInstanceSid("service_instance_sid")
                    .inboundAutocreation(true)
                    .routingAssignmentTimeout(1)
                    .inboundTimeout(1)
                    .url(URI.create("https://example.com"))
                    .method(HttpMethod.GET)
                    .record(Conversation.Record.DO_NOT_RECORD)
                    .trim(Conversation.Trim.TRIM_SILENCE)
                    .recordingStatusCallback(URI.create("https://example.com"))
                    .recordingStatusCallbackMethod(HttpMethod.GET)
                    .recordingStatusCallbackEvents(Promoter.listOfOne(Conversation.RecordingEvent.IN_PROGRESS))
                    .statusCallback(URI.create("https://example.com"))
                    .statusCallbackMethod(HttpMethod.GET)
                    .statusCallbackEvents(Promoter.listOfOne(Conversation.Event.CALL_INITIATED))
                    .build());

        final Connect elem = builder.build();

        Assert.assertEquals(
            Connect.Builder.fromXml("<Connect>" +
                "<Room participantIdentity=\"participant_identity\">name</Room>" +
                "<Autopilot>name</Autopilot>" +
                "<Stream connectorName=\"connector_name\" name=\"name\" statusCallback=\"status_callback\" statusCallbackMethod=\"GET\" track=\"inbound_track\" url=\"url\"/>" +
                "<VirtualAgent connectorName=\"connector_name\" language=\"language\" sentimentAnalysis=\"true\" statusCallback=\"status_callback\" statusCallbackMethod=\"GET\"/>" +
                "<Conversation inboundAutocreation=\"true\" inboundTimeout=\"1\" method=\"GET\" record=\"do-not-record\" recordingStatusCallback=\"https://example.com\" recordingStatusCallbackEvent=\"in-progress\" recordingStatusCallbackMethod=\"GET\" routingAssignmentTimeout=\"1\" serviceInstanceSid=\"service_instance_sid\" statusCallback=\"https://example.com\" statusCallbackEvent=\"call-initiated\" statusCallbackMethod=\"GET\" trim=\"trim-silence\" url=\"https://example.com\"/>" +
            "</Connect>").build().toXml(),
            elem.toXml()
        );
    }

    @Test
    public void testXmlEmptyChildrenDeserialization() {
        final Connect.Builder builder = new Connect.Builder();

        builder.stream(new Stream.Builder().build());

        builder.virtualAgent(new VirtualAgent.Builder().build());

        builder.conversation(new Conversation.Builder().build());

        final Connect elem = builder.build();

        Assert.assertEquals(
            Connect.Builder.fromXml("<Connect>" +
                "<Stream/>" +
                "<VirtualAgent/>" +
                "<Conversation/>" +
            "</Connect>").build().toXml(),
            elem.toXml()
        );
    }
}