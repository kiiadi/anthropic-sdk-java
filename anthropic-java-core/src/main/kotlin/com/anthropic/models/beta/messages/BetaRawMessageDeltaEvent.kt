// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.beta.messages

import com.anthropic.core.Enum
import com.anthropic.core.ExcludeMissing
import com.anthropic.core.JsonField
import com.anthropic.core.JsonMissing
import com.anthropic.core.JsonValue
import com.anthropic.core.checkRequired
import com.anthropic.errors.AnthropicInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BetaRawMessageDeltaEvent
private constructor(
    private val delta: JsonField<Delta>,
    private val type: JsonValue,
    private val usage: JsonField<BetaMessageDeltaUsage>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("delta") @ExcludeMissing delta: JsonField<Delta> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("usage")
        @ExcludeMissing
        usage: JsonField<BetaMessageDeltaUsage> = JsonMissing.of(),
    ) : this(delta, type, usage, mutableMapOf())

    /**
     * @throws AnthropicInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun delta(): Delta = delta.getRequired("delta")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("message_delta")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Billing and rate-limit usage.
     *
     * Anthropic's API bills and rate-limits by token counts, as tokens represent the underlying
     * cost to our systems.
     *
     * Under the hood, the API transforms requests into a format suitable for the model. The model's
     * output then goes through a parsing stage before becoming an API response. As a result, the
     * token counts in `usage` will not match one-to-one with the exact visible content of an API
     * request or response.
     *
     * For example, `output_tokens` will be non-zero, even for an empty string response from Claude.
     *
     * Total input tokens in a request is the summation of `input_tokens`,
     * `cache_creation_input_tokens`, and `cache_read_input_tokens`.
     *
     * @throws AnthropicInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun usage(): BetaMessageDeltaUsage = usage.getRequired("usage")

    /**
     * Returns the raw JSON value of [delta].
     *
     * Unlike [delta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<Delta> = delta

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<BetaMessageDeltaUsage> = usage

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BetaRawMessageDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .delta()
         * .usage()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaRawMessageDeltaEvent]. */
    class Builder internal constructor() {

        private var delta: JsonField<Delta>? = null
        private var type: JsonValue = JsonValue.from("message_delta")
        private var usage: JsonField<BetaMessageDeltaUsage>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaRawMessageDeltaEvent: BetaRawMessageDeltaEvent) = apply {
            delta = betaRawMessageDeltaEvent.delta
            type = betaRawMessageDeltaEvent.type
            usage = betaRawMessageDeltaEvent.usage
            additionalProperties = betaRawMessageDeltaEvent.additionalProperties.toMutableMap()
        }

        fun delta(delta: Delta) = delta(JsonField.of(delta))

        /**
         * Sets [Builder.delta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delta] with a well-typed [Delta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun delta(delta: JsonField<Delta>) = apply { this.delta = delta }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("message_delta")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * Billing and rate-limit usage.
         *
         * Anthropic's API bills and rate-limits by token counts, as tokens represent the underlying
         * cost to our systems.
         *
         * Under the hood, the API transforms requests into a format suitable for the model. The
         * model's output then goes through a parsing stage before becoming an API response. As a
         * result, the token counts in `usage` will not match one-to-one with the exact visible
         * content of an API request or response.
         *
         * For example, `output_tokens` will be non-zero, even for an empty string response from
         * Claude.
         *
         * Total input tokens in a request is the summation of `input_tokens`,
         * `cache_creation_input_tokens`, and `cache_read_input_tokens`.
         */
        fun usage(usage: BetaMessageDeltaUsage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [BetaMessageDeltaUsage] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun usage(usage: JsonField<BetaMessageDeltaUsage>) = apply { this.usage = usage }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [BetaRawMessageDeltaEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .delta()
         * .usage()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BetaRawMessageDeltaEvent =
            BetaRawMessageDeltaEvent(
                checkRequired("delta", delta),
                type,
                checkRequired("usage", usage),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BetaRawMessageDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        delta().validate()
        _type().let {
            if (it != JsonValue.from("message_delta")) {
                throw AnthropicInvalidDataException("'type' is invalid, received $it")
            }
        }
        usage().validate()
        validated = true
    }

    class Delta
    private constructor(
        private val stopReason: JsonField<StopReason>,
        private val stopSequence: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("stop_reason")
            @ExcludeMissing
            stopReason: JsonField<StopReason> = JsonMissing.of(),
            @JsonProperty("stop_sequence")
            @ExcludeMissing
            stopSequence: JsonField<String> = JsonMissing.of(),
        ) : this(stopReason, stopSequence, mutableMapOf())

        /**
         * @throws AnthropicInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun stopReason(): Optional<StopReason> =
            Optional.ofNullable(stopReason.getNullable("stop_reason"))

        /**
         * @throws AnthropicInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun stopSequence(): Optional<String> =
            Optional.ofNullable(stopSequence.getNullable("stop_sequence"))

        /**
         * Returns the raw JSON value of [stopReason].
         *
         * Unlike [stopReason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stop_reason")
        @ExcludeMissing
        fun _stopReason(): JsonField<StopReason> = stopReason

        /**
         * Returns the raw JSON value of [stopSequence].
         *
         * Unlike [stopSequence], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("stop_sequence")
        @ExcludeMissing
        fun _stopSequence(): JsonField<String> = stopSequence

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Delta].
             *
             * The following fields are required:
             * ```java
             * .stopReason()
             * .stopSequence()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Delta]. */
        class Builder internal constructor() {

            private var stopReason: JsonField<StopReason>? = null
            private var stopSequence: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(delta: Delta) = apply {
                stopReason = delta.stopReason
                stopSequence = delta.stopSequence
                additionalProperties = delta.additionalProperties.toMutableMap()
            }

            fun stopReason(stopReason: StopReason?) = stopReason(JsonField.ofNullable(stopReason))

            /** Alias for calling [Builder.stopReason] with `stopReason.orElse(null)`. */
            fun stopReason(stopReason: Optional<StopReason>) = stopReason(stopReason.getOrNull())

            /**
             * Sets [Builder.stopReason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stopReason] with a well-typed [StopReason] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stopReason(stopReason: JsonField<StopReason>) = apply {
                this.stopReason = stopReason
            }

            fun stopSequence(stopSequence: String?) =
                stopSequence(JsonField.ofNullable(stopSequence))

            /** Alias for calling [Builder.stopSequence] with `stopSequence.orElse(null)`. */
            fun stopSequence(stopSequence: Optional<String>) =
                stopSequence(stopSequence.getOrNull())

            /**
             * Sets [Builder.stopSequence] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stopSequence] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stopSequence(stopSequence: JsonField<String>) = apply {
                this.stopSequence = stopSequence
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Delta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .stopReason()
             * .stopSequence()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Delta =
                Delta(
                    checkRequired("stopReason", stopReason),
                    checkRequired("stopSequence", stopSequence),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Delta = apply {
            if (validated) {
                return@apply
            }

            stopReason()
            stopSequence()
            validated = true
        }

        class StopReason @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val END_TURN = of("end_turn")

                @JvmField val MAX_TOKENS = of("max_tokens")

                @JvmField val STOP_SEQUENCE = of("stop_sequence")

                @JvmField val TOOL_USE = of("tool_use")

                @JvmStatic fun of(value: String) = StopReason(JsonField.of(value))
            }

            /** An enum containing [StopReason]'s known values. */
            enum class Known {
                END_TURN,
                MAX_TOKENS,
                STOP_SEQUENCE,
                TOOL_USE,
            }

            /**
             * An enum containing [StopReason]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [StopReason] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                END_TURN,
                MAX_TOKENS,
                STOP_SEQUENCE,
                TOOL_USE,
                /**
                 * An enum member indicating that [StopReason] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    END_TURN -> Value.END_TURN
                    MAX_TOKENS -> Value.MAX_TOKENS
                    STOP_SEQUENCE -> Value.STOP_SEQUENCE
                    TOOL_USE -> Value.TOOL_USE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws AnthropicInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    END_TURN -> Known.END_TURN
                    MAX_TOKENS -> Known.MAX_TOKENS
                    STOP_SEQUENCE -> Known.STOP_SEQUENCE
                    TOOL_USE -> Known.TOOL_USE
                    else -> throw AnthropicInvalidDataException("Unknown StopReason: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws AnthropicInvalidDataException if this class instance's value does not have
             *   the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    AnthropicInvalidDataException("Value is not a String")
                }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is StopReason && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Delta && stopReason == other.stopReason && stopSequence == other.stopSequence && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(stopReason, stopSequence, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Delta{stopReason=$stopReason, stopSequence=$stopSequence, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaRawMessageDeltaEvent && delta == other.delta && type == other.type && usage == other.usage && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(delta, type, usage, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaRawMessageDeltaEvent{delta=$delta, type=$type, usage=$usage, additionalProperties=$additionalProperties}"
}
