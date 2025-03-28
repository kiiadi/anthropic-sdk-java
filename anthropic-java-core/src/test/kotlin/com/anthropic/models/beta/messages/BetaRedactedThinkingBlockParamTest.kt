// File generated from our OpenAPI spec by Stainless.

package com.anthropic.models.beta.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaRedactedThinkingBlockParamTest {

    @Test
    fun create() {
        val betaRedactedThinkingBlockParam =
            BetaRedactedThinkingBlockParam.builder().data("data").build()

        assertThat(betaRedactedThinkingBlockParam.data()).isEqualTo("data")
    }
}
