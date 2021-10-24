package p_0dd925d3768fcd4f79494ae32905dc1b;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;

class SelectionSortListTest {

    private static Stream<List<Integer>> unsortedListsOfIntegers() {
        return Stream.of(
                IntStream.of(2, 0, 3, 1).mapToObj(Integer::new).collect(Collectors.toList()),
                IntStream.of(2, 0, 0, 3, 1).mapToObj(Integer::new).collect(Collectors.toList()),
                IntStream.of(3, 7, 4, 9, 5, 2, 6, 1).mapToObj(Integer::new).collect(Collectors.toList()),
                IntStream.range(0, 1024)
                        .mapToObj(i -> current().nextBoolean() ? null : current().nextInt())
                        .map(v -> v == null ? null : new Integer(v.intValue()))
                        .collect(Collectors.toList())
        );
    }

    // ----------------------------------------------------------------------------------------------------------- sort1
    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort1__Integers_ArrayList(final List<Integer> unsorted) {
        final Comparator<Integer> comparator = Comparator.nullsFirst(Comparator.naturalOrder());
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        sorted1.sort(comparator);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        SelectionSortList.sort1(sorted2, comparator);
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1) // nothing else in the same order
        ;
    }

    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort1__Integers_LinkedList(final List<Integer> unsorted) {
        final Comparator<Integer> comparator = Comparator.nullsFirst(Comparator.naturalOrder());
        final List<Integer> sorted1 = new LinkedList<>(new ArrayList<>(unsorted));
        sorted1.sort(comparator);
        final List<Integer> sorted2 = new LinkedList<>(new ArrayList<>(unsorted));
        SelectionSortList.sort1(sorted2, comparator);
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
        final Comparator<Integer> comparator = Comparator.nullsFirst(Comparator.naturalOrder());
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        sorted1.sort(comparator);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        SelectionSortList.sort2(sorted2, comparator);
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1) // nothing else in the same order
        ;
    }

    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort2__Integers_LinkedList(final List<Integer> unsorted) {
        final Comparator<Integer> comparator = Comparator.nullsFirst(Comparator.naturalOrder());
        final List<Integer> sorted1 = new LinkedList<>(new ArrayList<>(unsorted));
        sorted1.sort(comparator);
        final List<Integer> sorted2 = new LinkedList<>(new ArrayList<>(unsorted));
        SelectionSortList.sort2(sorted2, comparator);
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
        final Comparator<Integer> comparator = Comparator.nullsFirst(Comparator.naturalOrder());
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        sorted1.sort(comparator);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        SelectionSortList.sort3(sorted2, comparator);
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1) // nothing else in the same order
        ;
    }

    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort3__Integers_LinkedList(final List<Integer> unsorted) {
        final Comparator<Integer> comparator = Comparator.nullsFirst(Comparator.naturalOrder());
        final List<Integer> sorted1 = new LinkedList<>(new ArrayList<>(unsorted));
        sorted1.sort(comparator);
        final List<Integer> sorted2 = new LinkedList<>(new ArrayList<>(unsorted));
        SelectionSortList.sort3(sorted2, comparator);
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1)
        ;
    }

    // ----------------------------------------------------------------------------------------------------------- sort4
    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort4__Integers_ArrayList(final List<Integer> unsorted) {
        final Comparator<Integer> comparator = Comparator.nullsFirst(Comparator.naturalOrder());
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        sorted1.sort(comparator);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        SelectionSortList.sort4(sorted2, comparator, current().nextBoolean());
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1) // nothing else in the same order
        ;
    }

    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort4__Integers_LinkedList(final List<Integer> unsorted) {
        final Comparator<Integer> comparator = Comparator.nullsFirst(Comparator.naturalOrder());
        final List<Integer> sorted1 = new LinkedList<>(new ArrayList<>(unsorted));
        sorted1.sort(comparator);
        final List<Integer> sorted2 = new LinkedList<>(new ArrayList<>(unsorted));
        SelectionSortList.sort4(sorted2, comparator, current().nextBoolean());
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1)
        ;
    }

    // ----------------------------------------------------------------------------------------------------------- sort5
    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort5__Integers_ArrayList(final List<Integer> unsorted) {
        final Comparator<Integer> comparator = Comparator.nullsFirst(Comparator.naturalOrder());
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        sorted1.sort(comparator);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        SelectionSortList.sort5(sorted2, comparator, current().nextBoolean());
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1) // nothing else in the same order
        ;
    }

    @MethodSource({"unsortedListsOfIntegers"})
    @ParameterizedTest
    void sort5__Integers_LinkedList(final List<Integer> unsorted) {
        final Comparator<Integer> comparator = Comparator.nullsFirst(Comparator.naturalOrder());
        final List<Integer> sorted1 = new LinkedList<>(new ArrayList<>(unsorted));
        sorted1.sort(comparator);
        final List<Integer> sorted2 = new LinkedList<>(new ArrayList<>(unsorted));
        SelectionSortList.sort5(sorted2, comparator, current().nextBoolean());
        assertThat(sorted2)
                .isSortedAccordingTo(comparator)
                .usingElementComparator((o1, o2) -> o1 == o2 ? 0 : -1)
                .containsExactlyElementsOf(sorted1)
        ;
    }
}