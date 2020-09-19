package p_aea6ebe8f23c7ea8b3bdc99a62169b07;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class MedianTest {

    @RepeatedTest(1024)
    void testGetMedianWithArrayInt() {
        final int[] elements = IntStream
                .rangeClosed(0, current().nextInt(128))
                .map(i -> current().nextInt())
                .toArray();
        Arrays.sort(elements);
        final double actual = Median.getMedian(elements);
        {
            final double expected = new org.apache.commons.math3.stat.descriptive.rank.Median()
                    .evaluate(Arrays.stream(elements).mapToDouble(v -> (double) v).toArray());
            assertEquals(expected, actual);
        }
        {
            final double expected = com.google.common.math.Quantiles.median().compute(elements);
            assertEquals(expected, actual);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @RepeatedTest(1024)
    void testGetMedianWithListInteger() {
        final int[] array = IntStream
                .rangeClosed(0, current().nextInt(128))
                .map(i -> current().nextInt())
                .toArray();
        Arrays.sort(array);
        final List<Integer> elements = Arrays.stream(array).boxed().collect(Collectors.toList());
        final double actual = Median.getMedian(elements, (e1, e2) -> ((double) e1 + (double) e2) / 2.0d);
        {
            final double expected = new org.apache.commons.math3.stat.descriptive.rank.Median()
                    .evaluate(Arrays.stream(array).mapToDouble(v -> (double) v).toArray());
            assertEquals(expected, actual);
        }
        {
            final double expected = com.google.common.math.Quantiles.median().compute(elements);
            assertEquals(expected, actual);
        }
    }
}