package p_008327149237522fbe45604451db4995;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class InsertionSortTest {

    @Test
    void sort__ints() {
        final List<Integer> unsorted = IntStream.range(0, 16)
                .map(i -> ThreadLocalRandom.current().nextInt()).boxed()
                .collect(Collectors.toList());
        final List<Integer> sorted1 = new ArrayList<>(unsorted);
        Collections.sort(sorted1);
        final List<Integer> sorted2 = new ArrayList<>(unsorted);
        InsertionSort.sort(sorted2);
        assertThat(sorted2)
                .isSorted()
                .hasSameElementsAs(sorted1);
    }
}