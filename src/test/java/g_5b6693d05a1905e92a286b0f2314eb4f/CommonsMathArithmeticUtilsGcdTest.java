package g_5b6693d05a1905e92a286b0f2314eb4f;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

// https://javadoc.io/doc/com.google.guava/guava/latest/com/google/common/math/IntMath.html
@Slf4j
class CommonsMathArithmeticUtilsGcdTest {

    private static Stream<Arguments> atLeastOneNegative() {
        int a = current().nextInt() | Integer.MIN_VALUE;
        int b = current().nextInt() | Integer.MIN_VALUE;
        if (current().nextBoolean()) {
            a |= Integer.MIN_VALUE;
            b |= Integer.MIN_VALUE;
        } else if (current().nextBoolean()) {
            a |= Integer.MIN_VALUE;
        } else {
            b |= Integer.MIN_VALUE;
        }
        return Stream.of(Arguments.of(a, b));
    }

    // -----------------------------------------------------------------------------------------------------------------
    // The invocations gcd(Integer.MIN_VALUE, Integer.MIN_VALUE), gcd(Integer.MIN_VALUE, 0)
    // and gcd(0, Integer.MIN_VALUE) throw an ArithmeticException,
    // because the result would be 2^31, which is too large for an int value.
    @Test
    void gcd_ArithmeticException_MIN_VALUE() {
        assertThatThrownBy(() -> ArithmeticUtils.gcd(Integer.MIN_VALUE, Integer.MIN_VALUE))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> ArithmeticUtils.gcd(Integer.MIN_VALUE, 0))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> ArithmeticUtils.gcd(0, Integer.MIN_VALUE))
                .isInstanceOf(ArithmeticException.class);
    }

    // The result of gcd(x, x), gcd(0, x) and gcd(x, 0) is the absolute value of x, except for the special cases above.
    @Test
    void gcd_Zero_OneZero() {
        {
            final int a = current().nextInt() ^ Integer.MIN_VALUE;
            assertThat(ArithmeticUtils.gcd(a, a)).isEqualTo(Math.abs(a));
        }
        {
            final int a = current().nextInt() ^ Integer.MIN_VALUE;
            final int b = 0;
            assertThat(ArithmeticUtils.gcd(a, b)).isEqualTo(Math.abs(a));
        }
        {
            final int a = 0;
            final int b = current().nextInt() ^ Integer.MIN_VALUE;
            assertThat(ArithmeticUtils.gcd(a, b)).isEqualTo(Math.abs(b));
        }
    }

    // The invocation gcd(0, 0) is the only one which returns 0.
    @Test
    void gcd_Zero_BothZero() {
        assertThat(ArithmeticUtils.gcd(0, 0))
                .isZero();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @RepeatedTest(5)
    void gcd__MIN_VALUE_With_NonZero() {
        {
            final int a = current().nextInt() ^ Integer.MIN_VALUE;
            final int b = Integer.MIN_VALUE;
            log.debug("gcd({}, {}): {}", a, b, ArithmeticUtils.gcd(a, b));
        }
        {
            final int a = Integer.MIN_VALUE;
            final int b = current().nextInt() ^ Integer.MIN_VALUE;
            log.debug("gcd({}, {}): {}", a, b, ArithmeticUtils.gcd(a, b));
        }
    }
}