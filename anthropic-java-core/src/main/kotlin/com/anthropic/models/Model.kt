// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models

import com.anthropic.core.Enum
import com.anthropic.core.JsonField
import com.anthropic.errors.AnthropicInvalidDataException
import com.fasterxml.jackson.annotation.JsonCreator

/**
 * The model that will complete your prompt.\n\nSee
 * [models](https://docs.anthropic.com/en/docs/models-overview) for additional details and options.
 */
class Model
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        /** Fast and cost-effective model */
        @JvmField val CLAUDE_3_5_HAIKU_LATEST = of("claude-3-5-haiku-latest")

        /** Fast and cost-effective model */
        @JvmField val CLAUDE_3_5_HAIKU_20241022 = of("claude-3-5-haiku-20241022")

        /** Our most intelligent model */
        @JvmField val CLAUDE_3_5_SONNET_LATEST = of("claude-3-5-sonnet-latest")

        /** Our most intelligent model */
        @JvmField val CLAUDE_3_5_SONNET_20241022 = of("claude-3-5-sonnet-20241022")

        /** Our previous most intelligent model */
        @JvmField val CLAUDE_3_5_SONNET_20240620 = of("claude-3-5-sonnet-20240620")

        /** Excels at writing and complex tasks */
        @JvmField val CLAUDE_3_OPUS_LATEST = of("claude-3-opus-latest")

        /** Excels at writing and complex tasks */
        @JvmField val CLAUDE_3_OPUS_20240229 = of("claude-3-opus-20240229")

        /** Balance of speed and intelligence */
        @JvmField val CLAUDE_3_SONNET_20240229 = of("claude-3-sonnet-20240229")

        /** Our previous fast and cost-effective */
        @JvmField val CLAUDE_3_HAIKU_20240307 = of("claude-3-haiku-20240307")

        @JvmField val CLAUDE_2_1 = of("claude-2.1")

        @JvmField val CLAUDE_2_0 = of("claude-2.0")

        @JvmStatic fun of(value: String) = Model(JsonField.of(value))
    }

    /** An enum containing [Model]'s known values. */
    enum class Known {
        /** Fast and cost-effective model */
        CLAUDE_3_5_HAIKU_LATEST,
        /** Fast and cost-effective model */
        CLAUDE_3_5_HAIKU_20241022,
        /** Our most intelligent model */
        CLAUDE_3_5_SONNET_LATEST,
        /** Our most intelligent model */
        CLAUDE_3_5_SONNET_20241022,
        /** Our previous most intelligent model */
        CLAUDE_3_5_SONNET_20240620,
        /** Excels at writing and complex tasks */
        CLAUDE_3_OPUS_LATEST,
        /** Excels at writing and complex tasks */
        CLAUDE_3_OPUS_20240229,
        /** Balance of speed and intelligence */
        CLAUDE_3_SONNET_20240229,
        /** Our previous fast and cost-effective */
        CLAUDE_3_HAIKU_20240307,
        CLAUDE_2_1,
        CLAUDE_2_0,
    }

    /**
     * An enum containing [Model]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [Model] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        /** Fast and cost-effective model */
        CLAUDE_3_5_HAIKU_LATEST,
        /** Fast and cost-effective model */
        CLAUDE_3_5_HAIKU_20241022,
        /** Our most intelligent model */
        CLAUDE_3_5_SONNET_LATEST,
        /** Our most intelligent model */
        CLAUDE_3_5_SONNET_20241022,
        /** Our previous most intelligent model */
        CLAUDE_3_5_SONNET_20240620,
        /** Excels at writing and complex tasks */
        CLAUDE_3_OPUS_LATEST,
        /** Excels at writing and complex tasks */
        CLAUDE_3_OPUS_20240229,
        /** Balance of speed and intelligence */
        CLAUDE_3_SONNET_20240229,
        /** Our previous fast and cost-effective */
        CLAUDE_3_HAIKU_20240307,
        CLAUDE_2_1,
        CLAUDE_2_0,
        /** An enum member indicating that [Model] was instantiated with an unknown value. */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     *
     * Use the [known] method instead if you're certain the value is always known or if you want to
     * throw for the unknown case.
     */
    fun value(): Value =
        when (this) {
            CLAUDE_3_5_HAIKU_LATEST -> Value.CLAUDE_3_5_HAIKU_LATEST
            CLAUDE_3_5_HAIKU_20241022 -> Value.CLAUDE_3_5_HAIKU_20241022
            CLAUDE_3_5_SONNET_LATEST -> Value.CLAUDE_3_5_SONNET_LATEST
            CLAUDE_3_5_SONNET_20241022 -> Value.CLAUDE_3_5_SONNET_20241022
            CLAUDE_3_5_SONNET_20240620 -> Value.CLAUDE_3_5_SONNET_20240620
            CLAUDE_3_OPUS_LATEST -> Value.CLAUDE_3_OPUS_LATEST
            CLAUDE_3_OPUS_20240229 -> Value.CLAUDE_3_OPUS_20240229
            CLAUDE_3_SONNET_20240229 -> Value.CLAUDE_3_SONNET_20240229
            CLAUDE_3_HAIKU_20240307 -> Value.CLAUDE_3_HAIKU_20240307
            CLAUDE_2_1 -> Value.CLAUDE_2_1
            CLAUDE_2_0 -> Value.CLAUDE_2_0
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws AnthropicInvalidDataException if this class instance's value is a not a known member.
     */
    fun known(): Known =
        when (this) {
            CLAUDE_3_5_HAIKU_LATEST -> Known.CLAUDE_3_5_HAIKU_LATEST
            CLAUDE_3_5_HAIKU_20241022 -> Known.CLAUDE_3_5_HAIKU_20241022
            CLAUDE_3_5_SONNET_LATEST -> Known.CLAUDE_3_5_SONNET_LATEST
            CLAUDE_3_5_SONNET_20241022 -> Known.CLAUDE_3_5_SONNET_20241022
            CLAUDE_3_5_SONNET_20240620 -> Known.CLAUDE_3_5_SONNET_20240620
            CLAUDE_3_OPUS_LATEST -> Known.CLAUDE_3_OPUS_LATEST
            CLAUDE_3_OPUS_20240229 -> Known.CLAUDE_3_OPUS_20240229
            CLAUDE_3_SONNET_20240229 -> Known.CLAUDE_3_SONNET_20240229
            CLAUDE_3_HAIKU_20240307 -> Known.CLAUDE_3_HAIKU_20240307
            CLAUDE_2_1 -> Known.CLAUDE_2_1
            CLAUDE_2_0 -> Known.CLAUDE_2_0
            else -> throw AnthropicInvalidDataException("Unknown Model: $value")
        }

    fun asString(): String = _value().asStringOrThrow()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Model && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
