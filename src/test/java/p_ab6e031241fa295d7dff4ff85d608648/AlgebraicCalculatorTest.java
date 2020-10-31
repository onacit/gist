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

    @RepeatedTest(1024)
    void testAdd_positive_positive() {
        final int a = current().nextInt() & Integer.MAX_VALUE;
        final int b = current().nextInt() & Integer.MAX_VALUE;
        assertThat(algebraicCalculator.add(a, b))
                .isEqualTo(a + b);
    }

    @RepeatedTest(1024)
    void testAdd_negative_negative() {
        final int a = current().nextInt() & Integer.MIN_VALUE;
        final int b = current().nextInt() & Integer.MIN_VALUE;
        assertThat(algebraicCalculator.add(a, b))
                .isEqualTo(a + b);
    }

    @RepeatedTest(1024)
    void testAdd_positive_negative() {
        final int a = current().nextInt() & Integer.MAX_VALUE;
        final int b = current().nextInt() & Integer.MIN_VALUE;
        assertThat(algebraicCalculator.add(a, b))
                .isEqualTo(a + b);
    }

    @RepeatedTest(1024)
    void testAdd_negative_positive() {
        final int a = current().nextInt() & Integer.MIN_VALUE;
        final int b = current().nextInt() & Integer.MAX_VALUE;
        assertThat(algebraicCalculator.add(a, b))
                .isEqualTo(a + b);
    }

    @RepeatedTest(1024)
    void testAdd() {
        final int a = current().nextInt();
        final int b = current().nextInt();
        log.debug("{}, {}", a, b);
        assertThat(algebraicCalculator.add(a, b))
                .isEqualTo(a + b);
    }

    @Test
    void testAdd_max_max() {
        final int a = Integer.MAX_VALUE;
        final int b = Integer.MAX_VALUE;
        assertThat(algebraicCalculator.add(a, b))
                .isEqualTo(a + b);
    }

    @Test
    void testAdd_min_min() {
        final int a = Integer.MIN_VALUE;
        final int b = Integer.MIN_VALUE;
        assertThat(algebraicCalculator.add(a, b))
                .isEqualTo(a + b);
    }

    @Test
    void testAdd_max_min() {
        final int a = Integer.MAX_VALUE;
        final int b = Integer.MIN_VALUE;
        assertThat(algebraicCalculator.add(a, b))
                .isEqualTo(a + b);
    }

    private AlgebraicCalculator algebraicCalculator;
}