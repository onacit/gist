package g_4be11fad6d8165bde47b988c14705b64;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A class for testing {@link CountingSort} class.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
class CountingSortTest {

    @Test
    void sort1_sorted_bytes() {
        final byte[] unsorted = new byte[ThreadLocalRandom.current().nextInt(1, 1024)];
        ThreadLocalRandom.current().nextBytes(unsorted);
        final byte[] sorted1 = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(sorted1);
        final byte[] sorted2 = CountingSort.sort1(unsorted, null, null);
        assertThat(sorted2).isSorted()
                .isEqualTo(sorted1);
    }

    @Test
    void sort2_sorted_bytes() {
        final byte[] unsorted = new byte[ThreadLocalRandom.current().nextInt(1, 1024)];
        ThreadLocalRandom.current().nextBytes(unsorted);
        final byte[] sorted1 = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(sorted1);
        final byte[] sorted2 = CountingSort.sort2(unsorted, null, null);
        assertThat(sorted2).isSorted()
                .isEqualTo(sorted1);
    }
}