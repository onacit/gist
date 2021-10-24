package g_5b6693d05a1905e92a286b0f2314eb4f;

import com.google.common.math.IntMath;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

// https://javadoc.io/doc/com.google.guava/guava/latest/com/google/common/math/IntMath.html
@Slf4j
class GuavaIntMathGcdTest {

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

    @MethodSource({"atLeastOneNegative"})
    @ParameterizedTest
    void gcd_IllegalArgumentException_AtLeastOneNegative(final int a, final int b) {
        assertThatThrownBy(() -> IntMath.gcd(a, b))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void gcd_Zero_BothZero() {
        assertThat(IntMath.gcd(0, 0)).isZero();
    }

    @Test
    void gcd_Zero_OneZero() {
        {
            final int a = 0;
            final int b = current().nextInt() & Integer.MAX_VALUE;
            assertThat(IntMath.gcd(a, b)).isEqualTo(b);
        }
        {
            final int a = current().nextInt() & Integer.MAX_VALUE;
            final int b = 0;
            assertThat(IntMath.gcd(a, b)).isEqualTo(a);
        }
    }
}