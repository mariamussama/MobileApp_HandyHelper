/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Verify
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.verify.v2.service.ratelimit;

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
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Bucket extends Resource {

    private static final long serialVersionUID = 268114856070086L;

    public static BucketCreator creator(
        final String pathServiceSid,
        final String pathRateLimitSid,
        final Integer max,
        final Integer interval
    ) {
        return new BucketCreator(
            pathServiceSid,
            pathRateLimitSid,
            max,
            interval
        );
    }

    public static BucketDeleter deleter(
        final String pathServiceSid,
        final String pathRateLimitSid,
        final String pathSid
    ) {
        return new BucketDeleter(pathServiceSid, pathRateLimitSid, pathSid);
    }

    public static BucketFetcher fetcher(
        final String pathServiceSid,
        final String pathRateLimitSid,
        final String pathSid
    ) {
        return new BucketFetcher(pathServiceSid, pathRateLimitSid, pathSid);
    }

    public static BucketReader reader(
        final String pathServiceSid,
        final String pathRateLimitSid
    ) {
        return new BucketReader(pathServiceSid, pathRateLimitSid);
    }

    public static BucketUpdater updater(
        final String pathServiceSid,
        final String pathRateLimitSid,
        final String pathSid
    ) {
        return new BucketUpdater(pathServiceSid, pathRateLimitSid, pathSid);
    }

    /**
     * Converts a JSON String into a Bucket object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Bucket object represented by the provided JSON
     */
    public static Bucket fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Bucket.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Bucket object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Bucket object represented by the provided JSON
     */
    public static Bucket fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Bucket.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String rateLimitSid;
    private final String serviceSid;
    private final String accountSid;
    private final Integer max;
    private final Integer interval;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private Bucket(
        @JsonProperty("sid") final String sid,
        @JsonProperty("rate_limit_sid") final String rateLimitSid,
        @JsonProperty("service_sid") final String serviceSid,
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("max") final Integer max,
        @JsonProperty("interval") final Integer interval,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_updated") final String dateUpdated,
        @JsonProperty("url") final URI url
    ) {
        this.sid = sid;
        this.rateLimitSid = rateLimitSid;
        this.serviceSid = serviceSid;
        this.accountSid = accountSid;
        this.max = max;
        this.interval = interval;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getRateLimitSid() {
        return this.rateLimitSid;
    }

    public final String getServiceSid() {
        return this.serviceSid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final Integer getMax() {
        return this.max;
    }

    public final Integer getInterval() {
        return this.interval;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Bucket other = (Bucket) o;

        return (
            Objects.equals(sid, other.sid) &&
            Objects.equals(rateLimitSid, other.rateLimitSid) &&
            Objects.equals(serviceSid, other.serviceSid) &&
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(max, other.max) &&
            Objects.equals(interval, other.interval) &&
            Objects.equals(dateCreated, other.dateCreated) &&
            Objects.equals(dateUpdated, other.dateUpdated) &&
            Objects.equals(url, other.url)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            sid,
            rateLimitSid,
            serviceSid,
            accountSid,
            max,
            interval,
            dateCreated,
            dateUpdated,
            url
        );
    }
}