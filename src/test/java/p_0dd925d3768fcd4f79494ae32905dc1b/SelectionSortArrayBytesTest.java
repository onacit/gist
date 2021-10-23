package p_0dd925d3768fcd4f79494ae32905dc1b;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;

class SelectionSortArrayBytesTest {

    private static byte[] random() {
        final byte[] array = new byte[current().nextInt(2, 1024)];
        current().nextBytes(array);
        return array;
    }

    private static Stream<byte[]> arrays() {
        return Stream.of(
                new byte[0],
                new byte[] {(byte) current().nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE + 1)},
                random()
        );
    }

    @MethodSource({"arrays"})
    @ParameterizedTest
    void sort1_Sorted_Given(final byte[] a) {
        current().nextBytes(a);
        SelectionSort.sort1(a);
        assertThat(a).isSorted();
    }

    @MethodSource({"arrays"})
    @ParameterizedTest
    void sort2_Sorted_Given(final byte[] a) {
        current().nextBytes(a);
        SelectionSort.sort2(a);
        assertThat(a).isSorted();
    }
}