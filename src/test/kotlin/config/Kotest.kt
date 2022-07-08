@file:OptIn(ExperimentalKotest::class)
@file:Suppress("unused")

package config

import io.kotest.common.ExperimentalKotest
import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension

object Kotest : AbstractProjectConfig() {

    override var testCoroutineDispatcher = true
    override val coroutineDebugProbes = true

    override fun extensions(): List<Extension> = listOf(TimerListener)
}