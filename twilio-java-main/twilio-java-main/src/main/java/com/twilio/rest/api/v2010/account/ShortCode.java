/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.http.HttpMethod;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ShortCode extends Resource {

    private static final long serialVersionUID = 169753160210519L;

    public static ShortCodeFetcher fetcher(final String pathSid) {
        return new ShortCodeFetcher(pathSid);
    }

    public static ShortCodeFetcher fetcher(
        final String pathAccountSid,
        final String pathSid
    ) {
        return new ShortCodeFetcher(pathAccountSid, pathSid);
    }

    public static ShortCodeReader reader() {
        return new ShortCodeReader();
    }

    public static ShortCodeReader reader(final String pathAccountSid) {
        return new ShortCodeReader(pathAccountSid);
    }

    public static ShortCodeUpdater updater(final String pathSid) {
        return new ShortCodeUpdater(pathSid);
    }

    public static ShortCodeUpdater updater(
        final String pathAccountSid,
        final String pathSid
    ) {
        return new ShortCodeUpdater(pathAccountSid, pathSid);
    }

    /**
     * Converts a JSON String into a ShortCode object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return ShortCode object represented by the provided JSON
     */
    public static ShortCode fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ShortCode.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a ShortCode object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return ShortCode object represented by the provided JSON
     */
    public static ShortCode fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ShortCode.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String friendlyName;
    private final String shortCode;
    private final String sid;
    private final HttpMethod smsFallbackMethod;
    private final URI smsFallbackUrl;
    private final HttpMethod smsMethod;
    private final URI smsUrl;
    private final String uri;

    @JsonCreator
    private ShortCode(
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("api_version") final String apiVersion,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_updated") final String dateUpdated,
        @JsonProperty("friendly_name") final String friendlyName,
        @JsonProperty("short_code") final String shortCode,
        @JsonProperty("sid") final String sid,
        @JsonProperty("sms_fallback_method") final HttpMethod smsFallbackMethod,
        @JsonProperty("sms_fallback_url") final URI smsFallbackUrl,
        @JsonProperty("sms_method") final HttpMethod smsMethod,
        @JsonProperty("sms_url") final URI smsUrl,
        @JsonProperty("uri") final String uri
    ) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.shortCode = shortCode;
        this.sid = sid;
        this.smsFallbackMethod = smsFallbackMethod;
        this.smsFallbackUrl = smsFallbackUrl;
        this.smsMethod = smsMethod;
        this.smsUrl = smsUrl;
        this.uri = uri;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final String getShortCode() {
        return this.shortCode;
    }

    public final String getSid() {
        return this.sid;
    }

    public final HttpMethod getSmsFallbackMethod() {
        return this.smsFallbackMethod;
    }

    public final URI getSmsFallbackUrl() {
        return this.smsFallbackUrl;
    }

    public final HttpMethod getSmsMethod() {
        return this.smsMethod;
    }

    public final URI getSmsUrl() {
        return this.smsUrl;
    }

    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ShortCode other = (ShortCode) o;

        return (
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(apiVersion, other.apiVersion) &&
            Objects.equals(dateCreated, other.dateCreated) &&
            Objects.equals(dateUpdated, other.dateUpdated) &&
            Objects.equals(friendlyName, other.friendlyName) &&
            Objects.equals(shortCode, other.shortCode) &&
            Objects.equals(sid, other.sid) &&
            Objects.equals(smsFallbackMethod, other.smsFallbackMethod) &&
            Objects.equals(smsFallbackUrl, other.smsFallbackUrl) &&
            Objects.equals(smsMethod, other.smsMethod) &&
            Objects.equals(smsUrl, other.smsUrl) &&
            Objects.equals(uri, other.uri)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountSid,
            apiVersion,
            dateCreated,
            dateUpdated,
            friendlyName,
            shortCode,
            sid,
            smsFallbackMethod,
            smsFallbackUrl,
            smsMethod,
            smsUrl,
            uri
        );
    }
}