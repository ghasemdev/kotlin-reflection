package config

import io.kotest.core.listeners.AfterEachListener
import io.kotest.core.listeners.BeforeEachListener
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult

object TimerListener : BeforeEachListener, AfterEachListener {

    private const val NANO_TO_MILLIS = 1_000_000F
    private var measureTime = 0L

    override suspend fun beforeEach(testCase: TestCase) {
        measureTime = System.nanoTime()
    }

    override suspend fun afterEach(testCase: TestCase, result: TestResult) {
        val duration = (System.nanoTime() - measureTime) / NANO_TO_MILLIS
        println("Duration of `${testCase.name.testName}` = ${"%.3f".format(duration)} ms")
    }
}