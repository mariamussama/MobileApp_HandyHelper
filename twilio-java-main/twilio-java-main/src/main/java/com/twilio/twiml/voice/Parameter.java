/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.twilio.twiml.TwiML;
import com.twilio.twiml.TwiMLException;

import java.util.HashMap;
import java.util.Map;

/**
 * TwiML wrapper for {@code <Parameter>}
 */
@JsonDeserialize(builder = Parameter.Builder.class)
public class Parameter extends TwiML {
    private final String name;
    private final String value;

    /**
     * For XML Serialization/Deserialization
     */
    private Parameter() {
        this(new Builder());
    }

    /**
     * Create a new {@code <Parameter>} element
     */
    private Parameter(Builder b) {
        super("Parameter", b);
        this.name = b.name;
        this.value = b.value;
    }

    /**
     * Attributes to set on the generated XML element
     *
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getName() != null) {
            attrs.put("name", this.getName());
        }
        if (this.getValue() != null) {
            attrs.put("value", this.getValue());
        }

        return attrs;
    }

    /**
     * The name of the custom parameter
     *
     * @return The name of the custom parameter
     */
    public String getName() {
        return name;
    }

    /**
     * The value of the custom parameter
     *
     * @return The value of the custom parameter
     */
    public String getValue() {
        return value;
    }

    /**
     * Create a new {@code <Parameter>} element
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends TwiML.Builder<Builder> {
        /**
         * Create and return a {@code <Parameter.Builder>} from an XML string
         */
        public static Builder fromXml(final String xml) throws TwiMLException {
            try {
                return OBJECT_MAPPER.readValue(xml, Builder.class);
            } catch (final JsonProcessingException jpe) {
                throw new TwiMLException(
                    "Failed to deserialize a Parameter.Builder from the provided XML string: " + jpe.getMessage());
            } catch (final Exception e) {
                throw new TwiMLException("Unhandled exception: " + e.getMessage());
            }
        }

        private String name;
        private String value;

        /**
         * The name of the custom parameter
         */
        @JacksonXmlProperty(isAttribute = true, localName = "name")
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * The value of the custom parameter
         */
        @JacksonXmlProperty(isAttribute = true, localName = "value")
        public Builder value(String value) {
            this.value = value;
            return this;
        }

        /**
         * Create and return resulting {@code <Parameter>} element
         */
        public Parameter build() {
            return new Parameter(this);
        }
    }
}