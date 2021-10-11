import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RandomIntegersTest {

    private static IntStream counts() {
        return IntStream.of(
                128,
                256,
                512,
                1024,
                2048,
                4096,
                8192
        );
    }

    @MethodSource({"counts"})
    @ParameterizedTest
    void applyResourceStream__(final int count) throws IOException {
        RandomIntegers.applyResourceStream(
                count,
                s -> {
                    assertThat(s).isNotNull();
                    return null;
                }
        );
    }

    @MethodSource({"counts"})
    @ParameterizedTest
    void getResourceList__(final int count) throws URISyntaxException, IOException {
        final List<Integer> list = RandomIntegers.getResourceList(count);
        assertThat(list).hasSize(count);
    }
}
