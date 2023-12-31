/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Flex
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.flexapi.v1;

import com.twilio.base.Creator;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class WebChannelCreator extends Creator<WebChannel> {

    private String flexFlowSid;
    private String identity;
    private String customerFriendlyName;
    private String chatFriendlyName;
    private String chatUniqueName;
    private String preEngagementData;

    public WebChannelCreator(
        final String flexFlowSid,
        final String identity,
        final String customerFriendlyName,
        final String chatFriendlyName
    ) {
        this.flexFlowSid = flexFlowSid;
        this.identity = identity;
        this.customerFriendlyName = customerFriendlyName;
        this.chatFriendlyName = chatFriendlyName;
    }

    public WebChannelCreator setFlexFlowSid(final String flexFlowSid) {
        this.flexFlowSid = flexFlowSid;
        return this;
    }

    public WebChannelCreator setIdentity(final String identity) {
        this.identity = identity;
        return this;
    }

    public WebChannelCreator setCustomerFriendlyName(
        final String customerFriendlyName
    ) {
        this.customerFriendlyName = customerFriendlyName;
        return this;
    }

    public WebChannelCreator setChatFriendlyName(
        final String chatFriendlyName
    ) {
        this.chatFriendlyName = chatFriendlyName;
        return this;
    }

    public WebChannelCreator setChatUniqueName(final String chatUniqueName) {
        this.chatUniqueName = chatUniqueName;
        return this;
    }

    public WebChannelCreator setPreEngagementData(
        final String preEngagementData
    ) {
        this.preEngagementData = preEngagementData;
        return this;
    }

    @Override
    public WebChannel create(final TwilioRestClient client) {
        String path = "/v1/WebChannels";

        path =
            path.replace(
                "{" + "FlexFlowSid" + "}",
                this.flexFlowSid.toString()
            );
        path = path.replace("{" + "Identity" + "}", this.identity.toString());
        path =
            path.replace(
                "{" + "CustomerFriendlyName" + "}",
                this.customerFriendlyName.toString()
            );
        path =
            path.replace(
                "{" + "ChatFriendlyName" + "}",
                this.chatFriendlyName.toString()
            );

        Request request = new Request(
            HttpMethod.POST,
            Domains.FLEXAPI.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "WebChannel creation failed: Unable to connect to server"
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

        return WebChannel.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (flexFlowSid != null) {
            request.addPostParam("FlexFlowSid", flexFlowSid);
        }
        if (identity != null) {
            request.addPostParam("Identity", identity);
        }
        if (customerFriendlyName != null) {
            request.addPostParam("CustomerFriendlyName", customerFriendlyName);
        }
        if (chatFriendlyName != null) {
            request.addPostParam("ChatFriendlyName", chatFriendlyName);
        }
        if (chatUniqueName != null) {
            request.addPostParam("ChatUniqueName", chatUniqueName);
        }
        if (preEngagementData != null) {
            request.addPostParam("PreEngagementData", preEngagementData);
        }
    }
}
