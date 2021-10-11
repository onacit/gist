package p_0dd925d3768fcd4f79494ae32905dc1b;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SelectionSortTest {

    private static Stream<List<Integer>> unsortedListsOfIntegers() {
        return Stream.of(
                IntStream.of(2, 0, 3, 1).mapToObj(Integer::new).collect(Collectors.toList()),
                IntStream.of(2, 0, 0, 3, 1).mapToObj(Integer::new).collect(Collectors.toList()),
                IntStream.of(3, 7, 4, 9, 5, 2, 6, 1).mapToObj(Integer::new).collect(Collectors.toList()),
                IntStream.range(0, 128)
                        .map(i -> ThreadLocalRandom.current().nextInt())
                        .mapToObj(Integer::new)
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
        final Comparator<Integer> comparator = Comparator.naturalOrder();
        SelectionSort.sort1(sorted2, comparator);
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1) // nothing else in the same order
        ;
    }

    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort1__Integers_LinkedList(final List<Integer> unsorted) {
        final List<Integer> sorted1 = new LinkedList<>(new ArrayList<>(unsorted));
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new LinkedList<>(new ArrayList<>(unsorted));
        final Comparator<Integer> comparator = Comparator.naturalOrder();
        SelectionSort.sort1(sorted2, comparator);
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1)
        ;
    }

    // ----------------------------------------------------------------------------------------------------------- sort2
    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort2__Integers_ArrayList(final List<Integer> unsorted) {
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        final Comparator<Integer> comparator = Comparator.naturalOrder();
        SelectionSort.sort2(sorted2, comparator);
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1) // nothing else in the same order
        ;
    }

    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort2__Integers_LinkedList(final List<Integer> unsorted) {
        final List<Integer> sorted1 = new LinkedList<>(new ArrayList<>(unsorted));
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new LinkedList<>(new ArrayList<>(unsorted));
        final Comparator<Integer> comparator = Comparator.naturalOrder();
        SelectionSort.sort2(sorted2, comparator);
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1)
        ;
    }

    // ----------------------------------------------------------------------------------------------------------- sort3
    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort3__Integers_ArrayList(final List<Integer> unsorted) {
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        final Comparator<Integer> comparator = Comparator.naturalOrder();
        SelectionSort.sort3(sorted2, comparator);
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1) // nothing else in the same order
        ;
    }

    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort3__Integers_LinkedList(final List<Integer> unsorted) {
        final List<Integer> sorted1 = new LinkedList<>(new ArrayList<>(unsorted));
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new LinkedList<>(new ArrayList<>(unsorted));
        final Comparator<Integer> comparator = Comparator.naturalOrder();
        SelectionSort.sort3(sorted2, comparator);
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1)
        ;
    }
}