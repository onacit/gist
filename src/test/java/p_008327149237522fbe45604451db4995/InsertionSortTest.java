package p_008327149237522fbe45604451db4995;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class InsertionSortTest {

    @Test
    void sort1__Integers() {
        final List<Integer> unsorted = IntStream.range(0, 16)
                .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                .collect(Collectors.toList());
        log.debug("unsorted: {}", unsorted);
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort1(sorted2);
        log.debug("sorted2: {}", sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .hasSameElementsAs(sorted1);
    }

    @Test
    void sort2__Integers() {
        final List<Integer> unsorted = IntStream.range(0, 16)
                .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                .collect(Collectors.toList());
        log.debug("unsorted: {}", unsorted);
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort2(sorted2);
        log.debug("sorted2: {}", sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .hasSameElementsAs(sorted1);
    }

    @Test
    void sort3__Integers() {
        final List<Integer> unsorted = IntStream.range(0, 128)
                .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                .collect(Collectors.toList());
//        final List<Integer> unsorted = Arrays.asList(2, 0, 3, 1);
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort3(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .hasSameElementsAs(sorted1);
    }

    @Test
    void sort__ints() {
        final List<Integer> unsorted = IntStream.range(0, 3)
                .map(i -> ThreadLocalRandom.current().nextInt(0, 10)).boxed()
                .collect(Collectors.toList());
//        final List<Integer> unsorted = Arrays.asList(2, 0, 3, 1);
        log.debug("unsorted: {}", unsorted);
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort(sorted2);
        log.debug("sorted2: {}", sorted2);
        assertThat(sorted2)
                .isSorted()
                .hasSameElementsAs(sorted1);
    }
}