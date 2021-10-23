package p_0dd925d3768fcd4f79494ae32905dc1b;

import org.junit.jupiter.api.Test;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;

class SelectionSort_Bytes_Test {

    // --------------------------------------------------------------------------------------------------- sort1(byte[])
    @Test
    void sort1_Sorted_Empty() {
        final byte[] a = new byte[0];
        SelectionSort.sort1(a);
        assertThat(a).isSorted();
    }

    @Test
    void sort1_Sorted_OneByte() {
        final byte[] a = new byte[] {(byte) current().nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE + 1)};
        SelectionSort.sort1(a);
        assertThat(a).isSorted();
    }

    @Test
    void sort1_bytes() {
        final byte[] a = new byte[current().nextInt(2, 1024)];
        current().nextBytes(a);
        SelectionSort.sort1(a);
        assertThat(a).isSorted();
    }

    // --------------------------------------------------------------------------------------------------- sort1(byte[])

    @Test
    void sort2_Sorted_Empty() {
        final byte[] a = new byte[0];
        SelectionSort.sort2(a);
        assertThat(a).isSorted();
    }

    @Test
    void sort2_Sorted_OneByte() {
        final byte[] a = new byte[] {(byte) current().nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE + 1)};
        SelectionSort.sort2(a);
        assertThat(a).isSorted();
    }

    @Test
    void sort2_bytes() {
        final byte[] a = new byte[current().nextInt(2, 1024)];
        current().nextBytes(a);
        SelectionSort.sort2(a);
        assertThat(a).isSorted();
    }
}