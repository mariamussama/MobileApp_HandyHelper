/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Ip_messaging
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.ipmessaging.v2.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Map;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Channel extends Resource {

    private static final long serialVersionUID = 188288773259274L;

    public static ChannelCreator creator(final String pathServiceSid) {
        return new ChannelCreator(pathServiceSid);
    }

    public static ChannelDeleter deleter(
        final String pathServiceSid,
        final String pathSid
    ) {
        return new ChannelDeleter(pathServiceSid, pathSid);
    }

    public static ChannelFetcher fetcher(
        final String pathServiceSid,
        final String pathSid
    ) {
        return new ChannelFetcher(pathServiceSid, pathSid);
    }

    public static ChannelReader reader(final String pathServiceSid) {
        return new ChannelReader(pathServiceSid);
    }

    public static ChannelUpdater updater(
        final String pathServiceSid,
        final String pathSid
    ) {
        return new ChannelUpdater(pathServiceSid, pathSid);
    }

    /**
     * Converts a JSON String into a Channel object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Channel object represented by the provided JSON
     */
    public static Channel fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Channel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Channel object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Channel object represented by the provided JSON
     */
    public static Channel fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Channel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum ChannelType {
        PUBLIC("public"),
        PRIVATE("private");

        private final String value;

        private ChannelType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static ChannelType forValue(final String value) {
            return Promoter.enumFromString(value, ChannelType.values());
        }
    }

    public enum WebhookEnabledType {
        TRUE("true"),
        FALSE("false");

        private final String value;

        private WebhookEnabledType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static WebhookEnabledType forValue(final String value) {
            return Promoter.enumFromString(value, WebhookEnabledType.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String friendlyName;
    private final String uniqueName;
    private final String attributes;
    private final Channel.ChannelType type;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String createdBy;
    private final Integer membersCount;
    private final Integer messagesCount;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Channel(
        @JsonProperty("sid") final String sid,
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("service_sid") final String serviceSid,
        @JsonProperty("friendly_name") final String friendlyName,
        @JsonProperty("unique_name") final String uniqueName,
        @JsonProperty("attributes") final String attributes,
        @JsonProperty("type") final Channel.ChannelType type,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_updated") final String dateUpdated,
        @JsonProperty("created_by") final String createdBy,
        @JsonProperty("members_count") final Integer membersCount,
        @JsonProperty("messages_count") final Integer messagesCount,
        @JsonProperty("url") final URI url,
        @JsonProperty("links") final Map<String, String> links
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.friendlyName = friendlyName;
        this.uniqueName = uniqueName;
        this.attributes = attributes;
        this.type = type;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.createdBy = createdBy;
        this.membersCount = membersCount;
        this.messagesCount = messagesCount;
        this.url = url;
        this.links = links;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getServiceSid() {
        return this.serviceSid;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final String getUniqueName() {
        return this.uniqueName;
    }

    public final String getAttributes() {
        return this.attributes;
    }

    public final Channel.ChannelType getType() {
        return this.type;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getCreatedBy() {
        return this.createdBy;
    }

    public final Integer getMembersCount() {
        return this.membersCount;
    }

    public final Integer getMessagesCount() {
        return this.messagesCount;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Channel other = (Channel) o;

        return (
            Objects.equals(sid, other.sid) &&
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(serviceSid, other.serviceSid) &&
            Objects.equals(friendlyName, other.friendlyName) &&
            Objects.equals(uniqueName, other.uniqueName) &&
            Objects.equals(attributes, other.attributes) &&
            Objects.equals(type, other.type) &&
            Objects.equals(dateCreated, other.dateCreated) &&
            Objects.equals(dateUpdated, other.dateUpdated) &&
            Objects.equals(createdBy, other.createdBy) &&
            Objects.equals(membersCount, other.membersCount) &&
            Objects.equals(messagesCount, other.messagesCount) &&
            Objects.equals(url, other.url) &&
            Objects.equals(links, other.links)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            sid,
            accountSid,
            serviceSid,
            friendlyName,
            uniqueName,
            attributes,
            type,
            dateCreated,
            dateUpdated,
            createdBy,
            membersCount,
            messagesCount,
            url,
            links
        );
    }
}
