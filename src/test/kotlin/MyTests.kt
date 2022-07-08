@file:OptIn(ExperimentalCoroutinesApi::class)

import io.kotest.core.spec.style.DescribeSpec
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import kotlin.time.Duration.Companion.hours

class MyTests : DescribeSpec({

    beforeEach { println("Hello from $it") }
    afterEach { println("Goodbye from $it") }

    describe("score") {
        it("start as zero") {
            runTest { delay(5.hours) }
        }

        describe("with a strike") {
            it("adds ten") {}
            it("carries strike to the next frame") {}
        }

        describe("for the opposite team") {
            it("Should negate one score") {}
        }
    }
})