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
import util.RandomBytes;

import java.util.Arrays;

@BenchmarkMode({Mode.AverageTime})
@Slf4j
public class SelectionSortArrayBytesBenchmark {

    public static void main(final String... args) throws RunnerException {
        final Options options = new OptionsBuilder()
                .include(SelectionSortArrayBytesBenchmark.class.getName() + ".*")
                .build();
        new Runner(options).run();
    }

    @State(Scope.Benchmark)
    public static class ByteArray {

        @Setup
        public void setup() {
            a = RandomBytes.bytes(8192);
        }

        @TearDown
        public void tearDown() {
            a = null;
        }

        byte[] a() {
            return Arrays.copyOf(a, a.length);
        }

        private byte[] a;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Benchmark
    public void sort1(final ByteArray state) {
        SelectionSort.sort1(state.a());
    }

    @Benchmark
    public void sort2(final ByteArray state) {
        SelectionSort.sort2(state.a());
    }
}