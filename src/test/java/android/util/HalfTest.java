package android.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static java.lang.Float.floatToIntBits;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16Test.formatBinary16;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16Test.formatBinary32;

@Slf4j
public class HalfTest {

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void smallest_positive_subnormal_number() {
        log.debug("documented: {}", "0.000000059605");
        final short expected = 0b0_00000_0000000001;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = Half.toFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), format("%10.20f", f));
        final short actual = Half.toHalf(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
    }

    @Test
    void largest_subnormal_number() {
        log.debug("documented: {}", "0.000060976");
        final short expected = 0b0_00000_1111111111;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = Half.toFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), format("%10.20f", f));
        final short actual = Half.toHalf(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
    }
}
