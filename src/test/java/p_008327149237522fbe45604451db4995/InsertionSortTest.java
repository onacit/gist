package p_008327149237522fbe45604451db4995;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class InsertionSortTest {

    // ----------------------------------------------------------------------------------------------------------- sort1
    @Test
    void sort1__Integers_ArrayList() {
        final List<Integer> unsorted = IntStream.range(0, 128)
                .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                .collect(Collectors.toList());
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort1(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .containsExactlyElementsOf(sorted1)
        ;
    }

    @Test
    void sort1__Integers_LinkedList() {
        final List<Integer> unsorted = IntStream.range(0, 128)
                .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                .collect(Collectors.toList());
        final List<Integer> sorted1 = new LinkedList<>(new ArrayList<>(unsorted));
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new LinkedList<>(new ArrayList<>(unsorted));
        InsertionSort.sort1(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .containsExactlyElementsOf(sorted1);
    }

    // ----------------------------------------------------------------------------------------------------------- sort2
    @Test
    void sort2__Integers_ArrayList() {
        final List<Integer> unsorted = IntStream.range(0, 128)
                .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                .collect(Collectors.toList());
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort2(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .containsExactlyElementsOf(sorted1);
    }

    @Test
    void sort2__Integers_LinkedList() {
        final List<Integer> unsorted = IntStream.range(0, 16)
                .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                .collect(Collectors.toList());
        final List<Integer> sorted1 = new LinkedList<>(new ArrayList<>(unsorted));
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new LinkedList<>(new ArrayList<>(unsorted));
        InsertionSort.sort2(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .containsExactlyElementsOf(sorted1);
    }

    // ----------------------------------------------------------------------------------------------------------- sort3
    @Test
    void sort3__Integers_ArrayList() {
        final List<Integer> unsorted = IntStream.range(0, 128)
                .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                .collect(Collectors.toList());
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort3(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .containsExactlyElementsOf(sorted1);
    }

    @Test
    void sort3__Integers_LinkedList() {
        final List<Integer> unsorted = IntStream.range(0, 128)
                .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                .collect(Collectors.toList());
        final List<Integer> sorted1 = new LinkedList<>(new ArrayList<>(unsorted));
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new LinkedList<>(new ArrayList<>(unsorted));
        InsertionSort.sort3(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .containsExactlyElementsOf(sorted1);
    }

    // ----------------------------------------------------------------------------------------------------------- sort3
    @Test
    void sort4__Integers_ArrayList() {
        final List<Integer> unsorted = IntStream.range(0, 128)
                .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                .collect(Collectors.toList());
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort4(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .containsExactlyElementsOf(sorted1);
    }

    @Test
    void sort4__Integers_LinkedList() {
        final List<Integer> unsorted = IntStream.range(0, 128)
                .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                .collect(Collectors.toList());
        final List<Integer> sorted1 = new LinkedList<>(new ArrayList<>(unsorted));
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new LinkedList<>(new ArrayList<>(unsorted));
        InsertionSort.sort4(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .containsExactlyElementsOf(sorted1);
    }
}