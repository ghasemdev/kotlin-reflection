import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer.MethodName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.jvm.isAccessible

@DisplayName("Private Function With Reflection")
@TestMethodOrder(MethodName::class)
internal class FooTest {

    val foo = Foo().invokePrivateFunction("getMassage") as? String

    private inline fun <reified T> T.invokePrivateFunction(name: String, vararg args: Any?): Any? =
        T::class
            .declaredMemberFunctions
            .firstOrNull { it.name == name }
            ?.apply { isAccessible = true }
            ?.call(this, *args)

    @Nested
    @DisplayName("foo()")
    inner class Something {

        @Test
        fun `run foo function`() {
            assertThat(foo).isEqualTo("Hello world!!!")
        }
    }
}
