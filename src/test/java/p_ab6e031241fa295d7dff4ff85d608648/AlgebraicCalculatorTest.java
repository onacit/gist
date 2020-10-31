package p_ab6e031241fa295d7dff4ff85d608648;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class AlgebraicCalculatorTest {

    @BeforeEach
    private void beforeEach() {
        algebraicCalculator = new AlgebraicCalculator() {
        };
    }

    // ---------------------------------------------------------------------------------------------------- add(int,int)
    @RepeatedTest(1024)
    void addInt_positive_positive() {
        final int a = current().nextInt() & Integer.MAX_VALUE;
        final int b = current().nextInt() & Integer.MAX_VALUE;
        final int actual = algebraicCalculator.add(a, b);
        final int expected = a + b;
        assertThat(actual).isEqualTo(expected);
    }

    @RepeatedTest(1024)
    void addInt_negative_negative() {
        final int a = current().nextInt() & Integer.MIN_VALUE;
        final int b = current().nextInt() & Integer.MIN_VALUE;
        final int actual = algebraicCalculator.add(a, b);
        final int expected = a + b;
        assertThat(actual).isEqualTo(expected);
    }

    @RepeatedTest(1024)
    void addInt_positive_negative() {
        final int a = current().nextInt() & Integer.MAX_VALUE;
        final int b = current().nextInt() & Integer.MIN_VALUE;
        final int actual = algebraicCalculator.add(a, b);
        final int expected = a + b;
        assertThat(actual).isEqualTo(expected);
    }

    @RepeatedTest(1024)
    void addInt_negative_positive() {
        final int a = current().nextInt() & Integer.MIN_VALUE;
        final int b = current().nextInt() & Integer.MAX_VALUE;
        final int actual = algebraicCalculator.add(a, b);
        final int expected = a + b;
        assertThat(actual).isEqualTo(expected);
    }

    @RepeatedTest(1024)
    void addInt_random_random() {
        final int a = current().nextInt();
        final int b = current().nextInt();
        final int actual = algebraicCalculator.add(a, b);
        final int expected = a + b;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void addInt_min_min() {
        final int a = Integer.MIN_VALUE;
        final int b = Integer.MIN_VALUE;
        final int actual = algebraicCalculator.add(a, b);
        final int expected = a + b;
        assertThat(actual).isEqualTo(expected).isZero();
    }

    @Test
    void addInt_min_max() {
        final int a = Integer.MIN_VALUE;
        final int b = Integer.MAX_VALUE;
        final int actual = algebraicCalculator.add(a, b);
        final int expected = a + b;
        assertThat(actual).isEqualTo(expected).isEqualTo(-1);
    }

    @Test
    void addInt_max_min() {
        final int a = Integer.MAX_VALUE;
        final int b = Integer.MIN_VALUE;
        final int actual = algebraicCalculator.add(a, b);
        final int expected = a + b;
        assertThat(actual).isEqualTo(expected).isEqualTo(-1);
    }

    @Test
    void addInt_max_max() {
        final int a = Integer.MAX_VALUE;
        final int b = Integer.MAX_VALUE;
        final int actual = algebraicCalculator.add(a, b);
        final int expected = a + b;
        assertThat(actual).isEqualTo(expected).isEqualTo(-2);
    }

    // ----------------------------------------------------------------------------------------------- subtract(int,int)
    @RepeatedTest(1024)
    void subtractInt_positive_positive() {
        final int a = current().nextInt() & Integer.MAX_VALUE;
        final int b = current().nextInt() & Integer.MAX_VALUE;
        final int actual = algebraicCalculator.subtract(a, b);
        final int expected = a - b;
        assertThat(actual).isEqualTo(expected);
    }

    @RepeatedTest(1024)
    void subtractInt_negative_negative() {
        final int a = current().nextInt() & Integer.MIN_VALUE;
        final int b = current().nextInt() & Integer.MIN_VALUE;
        final int actual = algebraicCalculator.subtract(a, b);
        final int expected = a - b;
        assertThat(actual).isEqualTo(expected);
    }

    @RepeatedTest(1024)
    void subtractInt_positive_negative() {
        final int a = current().nextInt() & Integer.MAX_VALUE;
        final int b = current().nextInt() & Integer.MIN_VALUE;
        final int actual = algebraicCalculator.subtract(a, b);
        final int expected = a - b;
        assertThat(actual).isEqualTo(expected);
    }

    @RepeatedTest(1024)
    void subtractInt_negative_positive() {
        final int a = current().nextInt() & Integer.MIN_VALUE;
        final int b = current().nextInt() & Integer.MAX_VALUE;
        final int actual = algebraicCalculator.subtract(a, b);
        final int expected = a - b;
        assertThat(actual).isEqualTo(expected);
    }

    @RepeatedTest(1024)
    void subtractInt_random_random() {
        final int a = current().nextInt();
        final int b = current().nextInt();
        final int actual = algebraicCalculator.subtract(a, b);
        final int expected = a - b;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void subtractInt_min_min() {
        final int a = Integer.MIN_VALUE;
        final int b = Integer.MIN_VALUE;
        final int actual = algebraicCalculator.subtract(a, b);
        final int expected = a - b;
        assertThat(actual).isEqualTo(expected).isZero();
    }

    @Test
    void subtractInt_min_max() {
        final int a = Integer.MIN_VALUE;
        final int b = Integer.MAX_VALUE;
        final int actual = algebraicCalculator.subtract(a, b);
        final int expected = a - b;
        assertThat(actual).isEqualTo(expected).isOne();
    }

    /**
     * Asserts subtracting {@link Integer#MIN_VALUE} from {@link Integer#MAX_VALUE} results {@code -1}.
     */
    @Test
    void subtractInt_max_min() {
        final int a = Integer.MAX_VALUE;
        final int b = Integer.MIN_VALUE;
        final int actual = algebraicCalculator.subtract(a, b);
        final int expected = a - b;
        assertThat(actual).isEqualTo(expected).isEqualTo(-1);
    }

    /**
     * Asserts subtracting {@link Integer#MAX_VALUE} from {@link Integer#MAX_VALUE} results {@code 0}.
     */
    @Test
    void subtractInt_max_max() {
        final int a = Integer.MAX_VALUE;
        final int b = Integer.MAX_VALUE;
        final int actual = algebraicCalculator.subtract(a, b);
        final int expected = a - b;
        assertThat(actual).isEqualTo(expected).isZero();
    }

    // -----------------------------------------------------------------------------------------------------------------
    private AlgebraicCalculator algebraicCalculator;
}