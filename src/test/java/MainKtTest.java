import org.junit.jupiter.api.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.google.common.truth.Truth.assertThat;

@DisplayName("Private Function With Reflection")
class MainKtTest {

    private static Method method;

    @BeforeAll
    static void setup() throws NoSuchMethodException {
        method = MainKt.class.getDeclaredMethod("equalDigitFrequency", int.class, int.class);
        method.setAccessible(true);
    }

    @Nested
    @TestMethodOrder(MethodOrderer.DisplayName.class)
    @DisplayName("equalDigitFrequency()")
    class EqualDigitFrequencyTest {

        @Test
        @DisplayName("The numbers are the same")
        void test1() throws InvocationTargetException, IllegalAccessException {
            var result = (boolean) method.invoke(method, 0, 0);
            assertThat(result).isTrue();

            result = (boolean) method.invoke(method, 99, 99);
            assertThat(result).isTrue();

            result = (boolean) method.invoke(method, 1004, 1004);
            assertThat(result).isTrue();

            result = (boolean) method.invoke(method, 123456789, 123456789);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("The digital frequency is the same but the numbers are not the same")
        void test2() throws InvocationTargetException, IllegalAccessException {
            var result = (boolean) method.invoke(method, 1122, 2211);
            assertThat(result).isTrue();

            result = (boolean) method.invoke(method, 1122, 1221);
            assertThat(result).isTrue();

            result = (boolean) method.invoke(method, 1122, 2112);
            assertThat(result).isTrue();

            result = (boolean) method.invoke(method, 1122, 1212);
            assertThat(result).isTrue();

            result = (boolean) method.invoke(method, 1122, 2121);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("The numbers aren't the same")
        void test3() throws InvocationTargetException, IllegalAccessException {
            var result = (boolean) method.invoke(method, 0, 1);
            assertThat(result).isFalse();

            result = (boolean) method.invoke(method, 1234524255, 1254342452);
            assertThat(result).isFalse();

            result = (boolean) method.invoke(method, 1111, 1114);
            assertThat(result).isFalse();

            result = (boolean) method.invoke(method, 5522, 22222);
            assertThat(result).isFalse();
        }
    }
}
