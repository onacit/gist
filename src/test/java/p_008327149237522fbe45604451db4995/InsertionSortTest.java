package p_008327149237522fbe45604451db4995;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class InsertionSortTest {

    private static Stream<List<Integer>> unsortedListsOfIntegers() {
        return Stream.of(
                Arrays.asList(2, 0, 3, 1),
                Arrays.asList(3, 7, 4, 9, 5, 2, 6, 1),
                IntStream.range(0, 128)
                        .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                        .collect(Collectors.toList())
        );
    }

    // ----------------------------------------------------------------------------------------------------------- sort1
    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort1__Integers_ArrayList(final List<Integer> unsorted) {
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort1(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .containsExactlyElementsOf(sorted1)
        ;
        for (int i = 0; i < sorted2.size(); i++) {
            assertThat(sorted2.get(i)).isSameAs(sorted1.get(i));
        }
    }

    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort1__Integers_LinkedList(final List<Integer> unsorted) {
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
    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort2__Integers_ArrayList(final List<Integer> unsorted) {
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort2(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .containsExactlyElementsOf(sorted1);
    }

    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort2__Integers_LinkedList(final List<Integer> unsorted) {
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
    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort3__Integers_ArrayList(final List<Integer> unsorted) {
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort3(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .containsExactlyElementsOf(sorted1);
    }

    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort3__Integers_LinkedList(final List<Integer> unsorted) {
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
    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort4__Integers_ArrayList(final List<Integer> unsorted) {
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort4(sorted2);
        assertThat(sorted2)
                .isSorted()
                .isSortedAccordingTo(Comparator.naturalOrder())
                .containsExactlyElementsOf(sorted1);
    }

    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort4__Integers_LinkedList(final List<Integer> unsorted) {
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