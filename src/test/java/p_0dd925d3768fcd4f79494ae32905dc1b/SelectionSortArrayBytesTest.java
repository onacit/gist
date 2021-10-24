package p_0dd925d3768fcd4f79494ae32905dc1b;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class SelectionSortArrayBytesTest {

    private static byte[] random() {
        final byte[] array = new byte[current().nextInt(2, 1024)];
        current().nextBytes(array);
        return array;
    }

    private static Stream<byte[]> parameters() {
        return Stream.of(
                new byte[0],
                new byte[] {(byte) current().nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE + 1)},
                random()
        );
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void sort1_Sorted_Given(final byte[] a) {
        SelectionSortArrayBytes.sort1(a, 0, a.length);
        assertThat(a).isSorted();
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void sort2_Sorted_Given(final byte[] a) {
        SelectionSortArrayBytes.sort2(a, 0, a.length);
        assertThat(a).isSorted();
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void sort3_Sorted_Given(final byte[] a) {
        SelectionSortArrayBytes.sort3(a, 0, a.length);
        assertThat(a).isSorted();
    }
}