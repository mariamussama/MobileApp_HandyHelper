/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Video
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.video.v1;

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
import com.twilio.http.HttpMethod;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Composition extends Resource {

    private static final long serialVersionUID = 27450434271262L;

    public static CompositionCreator creator(final String roomSid) {
        return new CompositionCreator(roomSid);
    }

    public static CompositionDeleter deleter(final String pathSid) {
        return new CompositionDeleter(pathSid);
    }

    public static CompositionFetcher fetcher(final String pathSid) {
        return new CompositionFetcher(pathSid);
    }

    public static CompositionReader reader() {
        return new CompositionReader();
    }

    /**
     * Converts a JSON String into a Composition object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Composition object represented by the provided JSON
     */
    public static Composition fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Composition.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Composition object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Composition object represented by the provided JSON
     */
    public static Composition fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Composition.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum Format {
        MP4("mp4"),
        WEBM("webm");

        private final String value;

        private Format(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Format forValue(final String value) {
            return Promoter.enumFromString(value, Format.values());
        }
    }

    public enum Status {
        ENQUEUED("enqueued"),
        PROCESSING("processing"),
        COMPLETED("completed"),
        DELETED("deleted"),
        FAILED("failed");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    private final String accountSid;
    private final Composition.Status status;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateCompleted;
    private final ZonedDateTime dateDeleted;
    private final String sid;
    private final String roomSid;
    private final List<String> audioSources;
    private final List<String> audioSourcesExcluded;
    private final Map<String, Object> videoLayout;
    private final String resolution;
    private final Boolean trim;
    private final Composition.Format format;
    private final Integer bitrate;
    private final Long size;
    private final Integer duration;
    private final URI mediaExternalLocation;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Composition(
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("status") final Composition.Status status,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_completed") final String dateCompleted,
        @JsonProperty("date_deleted") final String dateDeleted,
        @JsonProperty("sid") final String sid,
        @JsonProperty("room_sid") final String roomSid,
        @JsonProperty("audio_sources") final List<String> audioSources,
        @JsonProperty(
            "audio_sources_excluded"
        ) final List<String> audioSourcesExcluded,
        @JsonProperty("video_layout") final Map<String, Object> videoLayout,
        @JsonProperty("resolution") final String resolution,
        @JsonProperty("trim") final Boolean trim,
        @JsonProperty("format") final Composition.Format format,
        @JsonProperty("bitrate") final Integer bitrate,
        @JsonProperty("size") final Long size,
        @JsonProperty("duration") final Integer duration,
        @JsonProperty(
            "media_external_location"
        ) final URI mediaExternalLocation,
        @JsonProperty("status_callback") final URI statusCallback,
        @JsonProperty(
            "status_callback_method"
        ) final HttpMethod statusCallbackMethod,
        @JsonProperty("url") final URI url,
        @JsonProperty("links") final Map<String, String> links
    ) {
        this.accountSid = accountSid;
        this.status = status;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateCompleted =
            DateConverter.iso8601DateTimeFromString(dateCompleted);
        this.dateDeleted = DateConverter.iso8601DateTimeFromString(dateDeleted);
        this.sid = sid;
        this.roomSid = roomSid;
        this.audioSources = audioSources;
        this.audioSourcesExcluded = audioSourcesExcluded;
        this.videoLayout = videoLayout;
        this.resolution = resolution;
        this.trim = trim;
        this.format = format;
        this.bitrate = bitrate;
        this.size = size;
        this.duration = duration;
        this.mediaExternalLocation = mediaExternalLocation;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.url = url;
        this.links = links;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final Composition.Status getStatus() {
        return this.status;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateCompleted() {
        return this.dateCompleted;
    }

    public final ZonedDateTime getDateDeleted() {
        return this.dateDeleted;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getRoomSid() {
        return this.roomSid;
    }

    public final List<String> getAudioSources() {
        return this.audioSources;
    }

    public final List<String> getAudioSourcesExcluded() {
        return this.audioSourcesExcluded;
    }

    public final Map<String, Object> getVideoLayout() {
        return this.videoLayout;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final Boolean getTrim() {
        return this.trim;
    }

    public final Composition.Format getFormat() {
        return this.format;
    }

    public final Integer getBitrate() {
        return this.bitrate;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final URI getMediaExternalLocation() {
        return this.mediaExternalLocation;
    }

    public final URI getStatusCallback() {
        return this.statusCallback;
    }

    public final HttpMethod getStatusCallbackMethod() {
        return this.statusCallbackMethod;
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

        Composition other = (Composition) o;

        return (
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(status, other.status) &&
            Objects.equals(dateCreated, other.dateCreated) &&
            Objects.equals(dateCompleted, other.dateCompleted) &&
            Objects.equals(dateDeleted, other.dateDeleted) &&
            Objects.equals(sid, other.sid) &&
            Objects.equals(roomSid, other.roomSid) &&
            Objects.equals(audioSources, other.audioSources) &&
            Objects.equals(audioSourcesExcluded, other.audioSourcesExcluded) &&
            Objects.equals(videoLayout, other.videoLayout) &&
            Objects.equals(resolution, other.resolution) &&
            Objects.equals(trim, other.trim) &&
            Objects.equals(format, other.format) &&
            Objects.equals(bitrate, other.bitrate) &&
            Objects.equals(size, other.size) &&
            Objects.equals(duration, other.duration) &&
            Objects.equals(
                mediaExternalLocation,
                other.mediaExternalLocation
            ) &&
            Objects.equals(statusCallback, other.statusCallback) &&
            Objects.equals(statusCallbackMethod, other.statusCallbackMethod) &&
            Objects.equals(url, other.url) &&
            Objects.equals(links, other.links)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountSid,
            status,
            dateCreated,
            dateCompleted,
            dateDeleted,
            sid,
            roomSid,
            audioSources,
            audioSourcesExcluded,
            videoLayout,
            resolution,
            trim,
            format,
            bitrate,
            size,
            duration,
            mediaExternalLocation,
            statusCallback,
            statusCallbackMethod,
            url,
            links
        );
    }
}
