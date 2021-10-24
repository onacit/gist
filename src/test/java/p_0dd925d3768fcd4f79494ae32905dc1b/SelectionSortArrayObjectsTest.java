package p_0dd925d3768fcd4f79494ae32905dc1b;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;

class SelectionSortArrayObjectsTest {

    private static Integer[] random() {
        return IntStream.range(2, current().nextInt(3, 1024))
                .map(i -> current().nextInt())
                .boxed()
                .toArray(Integer[]::new);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                        new Integer[0],
                        new Integer[] {current().nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE + 1)},
                        random()
                )
                .map(v -> Arguments.of((Object) v));
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void sort1_Sorted_Given(final Integer[] a) {
        Comparator<Integer> comparator = Integer::compare;
        if (current().nextBoolean()) {
            comparator = comparator.reversed();
        }
        SelectionSortArrayObjects.sort1(a, 0, a.length, comparator);
        assertThat(a)
                .isSortedAccordingTo(comparator);
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void sort2_Sorted_Given(final Integer[] a) {
        Comparator<Integer> comparator = Integer::compare;
        if (current().nextBoolean()) {
            comparator = comparator.reversed();
        }
        SelectionSortArrayObjects.sort2(a, 0, a.length, comparator);
        assertThat(a)
                .isSortedAccordingTo(comparator);
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void sort3_Sorted_Given(final Integer[] a) {
        Comparator<Integer> comparator = Integer::compare;
        if (current().nextBoolean()) {
            comparator = comparator.reversed();
        }
        SelectionSortArrayObjects.sort3(a, 0, a.length, comparator, current().nextBoolean());
        assertThat(a)
                .isSortedAccordingTo(comparator);
    }
}