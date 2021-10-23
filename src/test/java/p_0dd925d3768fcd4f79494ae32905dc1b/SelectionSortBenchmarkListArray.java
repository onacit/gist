package p_0dd925d3768fcd4f79494ae32905dc1b;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode({Mode.SingleShotTime})
@State(Scope.Benchmark)
@Slf4j
public class SelectionSortBenchmarkListArray {

    public static void main(final String... args) throws RunnerException {
        final Options options = new OptionsBuilder()
                .include(SelectionSortBenchmarkListArray.class.getName() + ".*")
                .build();
        new Runner(options).run();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Benchmark
    public void sort1() {
        SelectionSort.sort1(new ArrayList<>(unsorted), Comparator.naturalOrder());
    }

    @Benchmark
    public void sort2() {
        SelectionSort.sort2(new ArrayList<>(unsorted), Comparator.naturalOrder());
    }

    @Benchmark
    public void sort3() {
        SelectionSort.sort3(new ArrayList<>(unsorted), Comparator.naturalOrder());
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Setup
    public void onSetup() {
        unsorted = Collections.unmodifiableList(
                IntStream.range(0, 8192)
                        .map(i -> ThreadLocalRandom.current().nextInt())
                        .boxed()
                        .collect(Collectors.toList())
        );
    }

    @TearDown
    public void onTearDown() {
        unsorted = null;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private List<Integer> unsorted = null;
}