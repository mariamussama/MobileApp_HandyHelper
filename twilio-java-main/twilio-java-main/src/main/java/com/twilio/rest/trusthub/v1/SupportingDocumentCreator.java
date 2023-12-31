/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Trusthub
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.trusthub.v1;

import com.twilio.base.Creator;
import com.twilio.constant.EnumConstants;
import com.twilio.converter.Converter;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.util.Map;
import java.util.Map;

public class SupportingDocumentCreator extends Creator<SupportingDocument> {

    private String friendlyName;
    private String type;
    private Map<String, Object> attributes;

    public SupportingDocumentCreator(
        final String friendlyName,
        final String type
    ) {
        this.friendlyName = friendlyName;
        this.type = type;
    }

    public SupportingDocumentCreator setFriendlyName(
        final String friendlyName
    ) {
        this.friendlyName = friendlyName;
        return this;
    }

    public SupportingDocumentCreator setType(final String type) {
        this.type = type;
        return this;
    }

    public SupportingDocumentCreator setAttributes(
        final Map<String, Object> attributes
    ) {
        this.attributes = attributes;
        return this;
    }

    @Override
    public SupportingDocument create(final TwilioRestClient client) {
        String path = "/v1/SupportingDocuments";

        path =
            path.replace(
                "{" + "FriendlyName" + "}",
                this.friendlyName.toString()
            );
        path = path.replace("{" + "Type" + "}", this.type.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.TRUSTHUB.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "SupportingDocument creation failed: Unable to connect to server"
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

        return SupportingDocument.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        if (type != null) {
            request.addPostParam("Type", type);
        }
        if (attributes != null) {
            request.addPostParam("Attributes", Converter.mapToJson(attributes));
        }
    }
}
