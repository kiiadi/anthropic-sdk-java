// File generated from our OpenAPI spec by Stainless.

package com.anthropic.services

import com.anthropic.client.AnthropicClient
import com.anthropic.client.okhttp.AnthropicOkHttpClient
import com.anthropic.core.JsonValue
import com.anthropic.core.http.Headers
import com.anthropic.core.jsonMapper
import com.anthropic.errors.AnthropicError
import com.anthropic.errors.AnthropicException
import com.anthropic.errors.BadRequestException
import com.anthropic.errors.InternalServerException
import com.anthropic.errors.NotFoundException
import com.anthropic.errors.PermissionDeniedException
import com.anthropic.errors.RateLimitException
import com.anthropic.errors.UnauthorizedException
import com.anthropic.errors.UnexpectedStatusCodeException
import com.anthropic.errors.UnprocessableEntityException
import com.anthropic.models.CacheControlEphemeral
import com.anthropic.models.CitationCharLocationParam
import com.anthropic.models.MessageCreateParams
import com.anthropic.models.Metadata
import com.anthropic.models.Model
import com.anthropic.models.TextBlockParam
import com.anthropic.models.Tool
import com.anthropic.models.ToolChoiceAuto
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@WireMockTest
class ErrorHandlingTest {

    companion object {

        private val ERROR: AnthropicError =
            AnthropicError.builder()
                .putAdditionalProperty("errorProperty", JsonValue.from("42"))
                .build()

        private val ERROR_JSON: ByteArray = jsonMapper().writeValueAsBytes(ERROR)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: AnthropicClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            AnthropicOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("my-anthropic-api-key")
                .build()
    }

    @Test
    fun messagesCreate400() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<BadRequestException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .maxTokens(1024L)
                        .addUserMessage("Hello, world")
                        .model(Model.CLAUDE_3_7_SONNET_LATEST)
                        .metadata(
                            Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .systemOfTextBlockParams(
                            listOf(
                                TextBlockParam.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(CacheControlEphemeral.builder().build())
                                    .addCitation(
                                        CitationCharLocationParam.builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(ToolChoiceAuto.builder().disableParallelToolUse(true).build())
                        .addTool(
                            Tool.builder()
                                .inputSchema(
                                    Tool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(CacheControlEphemeral.builder().build())
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate401() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnauthorizedException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .maxTokens(1024L)
                        .addUserMessage("Hello, world")
                        .model(Model.CLAUDE_3_7_SONNET_LATEST)
                        .metadata(
                            Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .systemOfTextBlockParams(
                            listOf(
                                TextBlockParam.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(CacheControlEphemeral.builder().build())
                                    .addCitation(
                                        CitationCharLocationParam.builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(ToolChoiceAuto.builder().disableParallelToolUse(true).build())
                        .addTool(
                            Tool.builder()
                                .inputSchema(
                                    Tool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(CacheControlEphemeral.builder().build())
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate403() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<PermissionDeniedException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .maxTokens(1024L)
                        .addUserMessage("Hello, world")
                        .model(Model.CLAUDE_3_7_SONNET_LATEST)
                        .metadata(
                            Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .systemOfTextBlockParams(
                            listOf(
                                TextBlockParam.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(CacheControlEphemeral.builder().build())
                                    .addCitation(
                                        CitationCharLocationParam.builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(ToolChoiceAuto.builder().disableParallelToolUse(true).build())
                        .addTool(
                            Tool.builder()
                                .inputSchema(
                                    Tool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(CacheControlEphemeral.builder().build())
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate404() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<NotFoundException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .maxTokens(1024L)
                        .addUserMessage("Hello, world")
                        .model(Model.CLAUDE_3_7_SONNET_LATEST)
                        .metadata(
                            Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .systemOfTextBlockParams(
                            listOf(
                                TextBlockParam.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(CacheControlEphemeral.builder().build())
                                    .addCitation(
                                        CitationCharLocationParam.builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(ToolChoiceAuto.builder().disableParallelToolUse(true).build())
                        .addTool(
                            Tool.builder()
                                .inputSchema(
                                    Tool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(CacheControlEphemeral.builder().build())
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate422() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .maxTokens(1024L)
                        .addUserMessage("Hello, world")
                        .model(Model.CLAUDE_3_7_SONNET_LATEST)
                        .metadata(
                            Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .systemOfTextBlockParams(
                            listOf(
                                TextBlockParam.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(CacheControlEphemeral.builder().build())
                                    .addCitation(
                                        CitationCharLocationParam.builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(ToolChoiceAuto.builder().disableParallelToolUse(true).build())
                        .addTool(
                            Tool.builder()
                                .inputSchema(
                                    Tool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(CacheControlEphemeral.builder().build())
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate429() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<RateLimitException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .maxTokens(1024L)
                        .addUserMessage("Hello, world")
                        .model(Model.CLAUDE_3_7_SONNET_LATEST)
                        .metadata(
                            Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .systemOfTextBlockParams(
                            listOf(
                                TextBlockParam.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(CacheControlEphemeral.builder().build())
                                    .addCitation(
                                        CitationCharLocationParam.builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(ToolChoiceAuto.builder().disableParallelToolUse(true).build())
                        .addTool(
                            Tool.builder()
                                .inputSchema(
                                    Tool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(CacheControlEphemeral.builder().build())
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate500() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<InternalServerException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .maxTokens(1024L)
                        .addUserMessage("Hello, world")
                        .model(Model.CLAUDE_3_7_SONNET_LATEST)
                        .metadata(
                            Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .systemOfTextBlockParams(
                            listOf(
                                TextBlockParam.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(CacheControlEphemeral.builder().build())
                                    .addCitation(
                                        CitationCharLocationParam.builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(ToolChoiceAuto.builder().disableParallelToolUse(true).build())
                        .addTool(
                            Tool.builder()
                                .inputSchema(
                                    Tool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(CacheControlEphemeral.builder().build())
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate999() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .maxTokens(1024L)
                        .addUserMessage("Hello, world")
                        .model(Model.CLAUDE_3_7_SONNET_LATEST)
                        .metadata(
                            Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .systemOfTextBlockParams(
                            listOf(
                                TextBlockParam.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(CacheControlEphemeral.builder().build())
                                    .addCitation(
                                        CitationCharLocationParam.builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(ToolChoiceAuto.builder().disableParallelToolUse(true).build())
                        .addTool(
                            Tool.builder()
                                .inputSchema(
                                    Tool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(CacheControlEphemeral.builder().build())
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreateInvalidJsonBody() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<AnthropicException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .maxTokens(1024L)
                        .addUserMessage("Hello, world")
                        .model(Model.CLAUDE_3_7_SONNET_LATEST)
                        .metadata(
                            Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .systemOfTextBlockParams(
                            listOf(
                                TextBlockParam.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(CacheControlEphemeral.builder().build())
                                    .addCitation(
                                        CitationCharLocationParam.builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(ToolChoiceAuto.builder().disableParallelToolUse(true).build())
                        .addTool(
                            Tool.builder()
                                .inputSchema(
                                    Tool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(CacheControlEphemeral.builder().build())
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
