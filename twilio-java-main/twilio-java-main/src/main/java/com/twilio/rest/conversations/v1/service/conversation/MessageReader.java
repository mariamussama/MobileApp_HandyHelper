/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.conversations.v1.service.conversation;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class MessageReader extends Reader<Message> {

    private String pathChatServiceSid;
    private String pathConversationSid;
    private Message.OrderType order;
    private Integer pageSize;

    public MessageReader(
        final String pathChatServiceSid,
        final String pathConversationSid
    ) {
        this.pathChatServiceSid = pathChatServiceSid;
        this.pathConversationSid = pathConversationSid;
    }

    public MessageReader setOrder(final Message.OrderType order) {
        this.order = order;
        return this;
    }

    public MessageReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Message> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Message> firstPage(final TwilioRestClient client) {
        String path =
            "/v1/Services/{ChatServiceSid}/Conversations/{ConversationSid}/Messages";
        path =
            path.replace(
                "{" + "ChatServiceSid" + "}",
                this.pathChatServiceSid.toString()
            );
        path =
            path.replace(
                "{" + "ConversationSid" + "}",
                this.pathConversationSid.toString()
            );

        Request request = new Request(
            HttpMethod.GET,
            Domains.CONVERSATIONS.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Message> pageForRequest(
        final TwilioRestClient client,
        final Request request
    ) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "Message read failed: Unable to connect to server"
            );
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(
                response.getStream(),
                client.getObjectMapper()
            );
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "messages",
            response.getContent(),
            Message.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<Message> previousPage(
        final Page<Message> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.CONVERSATIONS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Message> nextPage(
        final Page<Message> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.CONVERSATIONS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Message> getPage(
        final String targetUrl,
        final TwilioRestClient client
    ) {
        Request request = new Request(HttpMethod.GET, targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (order != null) {
            request.addQueryParam("Order", order.toString());
        }
        if (pageSize != null) {
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
