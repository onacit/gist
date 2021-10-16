package g_4be11fad6d8165bde47b988c14705b64;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

class CountingSortTest {

    @Test
    void sort_sorted_EmptyByteArray() {
        final byte[] unsorted = new byte[0];
        final byte[] sorted1 = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(sorted1);
        final byte[] sorted2 = CountingSort.sort(unsorted);
        assertThat(sorted2).isSorted()
                .isEqualTo(sorted1);
    }

    @Test
    void sort_sorted_OneByteArray() {
        final byte[] unsorted = new byte[] {
                (byte) (ThreadLocalRandom.current().nextInt() >>> 24)
        };
        final byte[] sorted1 = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(sorted1);
        final byte[] sorted2 = CountingSort.sort(unsorted);
        assertThat(sorted2).isSorted()
                .isEqualTo(sorted1);
    }

    @Test
    void sort_sorted_bytes() {
        final byte[] unsorted = new byte[ThreadLocalRandom.current().nextInt(1, 1024)];
        ThreadLocalRandom.current().nextBytes(unsorted);
        final byte[] sorted1 = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(sorted1);
        final byte[] sorted2 = CountingSort.sort(unsorted);
        assertThat(sorted2).isSorted()
                .isEqualTo(sorted1);
    }
}