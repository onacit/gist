package g_5b6693d05a1905e92a286b0f2314eb4f;

import com.google.common.math.IntMath;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
class EuclideanAlgorithmTest {

    @Test
    void gcd1__() {
    }

    @Test
    void gcd_() {
        final int a = ThreadLocalRandom.current().nextInt() & 0x7FFFFFFF;
        final int b = ThreadLocalRandom.current().nextInt() & 0x7FFFFFFF;
        log.debug("gcd({}, {}) = {}", a, b, IntMath.gcd(a, b));
    }
}