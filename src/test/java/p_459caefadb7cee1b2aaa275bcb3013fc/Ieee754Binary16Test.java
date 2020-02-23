package p_459caefadb7cee1b2aaa275bcb3013fc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static java.lang.Float.NEGATIVE_INFINITY;
import static java.lang.Float.POSITIVE_INFINITY;
import static java.lang.Float.floatToIntBits;
import static java.lang.Float.isInfinite;
import static java.lang.Integer.toBinaryString;
import static java.lang.String.format;
import static java.util.concurrent.ThreadLocalRandom.current;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16.MASK_EXPONENT;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16.MASK_EXPONENT_32;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16.MASK_SIGNIFICAND;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16.MASK_SIGNIFICAND_32;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16.SIZE_SIGNIFICAND;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16.SIZE_SIGNIFICAND_BINARY32;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16.binary16ShortBitsToFloat;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16.floatToBinary16ShortBits;

@Slf4j
public class Ieee754Binary16Test {

    // -----------------------------------------------------------------------------------------------------------------
    private static String formatBinary32(final int value) {
        return format("%1$1s %2$8s %3$23s",
                      toBinaryString(value >>> (Integer.SIZE - 1)),
                      toBinaryString((value & MASK_EXPONENT_32) >> SIZE_SIGNIFICAND_BINARY32),
                      toBinaryString(value & MASK_SIGNIFICAND_32)
        );
    }

    private static String formatBinary16(final int value) {
        return format("%1$1s %2$8s %3$23s",
                      toBinaryString(value >>> (Integer.SIZE - 1)),
                      toBinaryString((value & MASK_EXPONENT) >> SIZE_SIGNIFICAND),
                      toBinaryString(value & MASK_SIGNIFICAND)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void smallest_positive_subnormal_number() {
        log.debug("documented: {}", "0.000000059605");
        final short expected = 0b0_00000_0000000001;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = binary16ShortBitsToFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), f);
        final short actual = floatToBinary16ShortBits(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
    }

    @Test
    void largest_subnormal_number() {
        log.debug("documented: {}", "0.000060976");
        final short expected = 0b0_00000_1111111111;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = binary16ShortBitsToFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), f);
        final short actual = floatToBinary16ShortBits(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
    }

    @Test
    void smallest_positive_normal_number() {
        log.debug("documented: {}", "0.000061035");
        final short expected = 0b0_00001_0000000000;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = binary16ShortBitsToFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), f);
        final short actual = floatToBinary16ShortBits(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
    }

    @Test
    void largest_normal_number() {
        final short expected = 0b0_11110_1111111111;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = binary16ShortBitsToFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), f);
        final short actual = floatToBinary16ShortBits(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
    }

    @Test
    void largest_number_less_than_one() {
        log.debug("documented: {}", "0.99951");
        final short expected = 0b0_01110_1111111111;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = binary16ShortBitsToFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), f);
        final short actual = floatToBinary16ShortBits(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
        assertTrue(+1.0f > f);
    }

    @Test
    void one() {
        log.debug("documented: {}", "1");
        final short expected = 0b0_01111_0000000000;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = binary16ShortBitsToFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), f);
        final short actual = floatToBinary16ShortBits(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
        assertEquals(+1.0f, f);
    }

    @Test
    void smallest_number_larger_than_one() {
        log.debug("documented: {}", "1.001");
        final short expected = 0b0_01111_0000000001;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = binary16ShortBitsToFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), f);
        final short actual = floatToBinary16ShortBits(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
    }

    @Test
    void equal_to_one_third() {
        log.debug("documented: {}", "0.333251953125");
        final short expected = 0b0_01101_0101010101;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = binary16ShortBitsToFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), f);
        final short actual = floatToBinary16ShortBits(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
    }

    @Test
    void minus_two() {
        final short expected = (short) 0b1_10000_0000000000;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = binary16ShortBitsToFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), f);
        assertEquals(-2.0f, f);
        final short actual = floatToBinary16ShortBits(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
    }

    @Test
    void positive_zero() {
        final short expected = 0b0_00000_0000000000;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = binary16ShortBitsToFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), f);
        assertEquals(+.0f, f);
        final short actual = floatToBinary16ShortBits(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
    }

    @Test
    void negative_zero() {
        final short expected = (short) 0b1_00000_0000000000;
        log.debug("expected: {} {}", formatBinary16(expected), expected);
        final float f = binary16ShortBitsToFloat(expected);
        log.debug("float:    {} {}", formatBinary32(floatToIntBits(f)), f);
        assertEquals(-.0f, f);
        final short actual = floatToBinary16ShortBits(f);
        log.debug("actual:   {} {}", formatBinary16(actual), actual);
        assertEquals(expected, actual);
    }

    @Test
    void positive_infinity() {
        final short expected = 0b0_11111_0000000000;
        final float f = binary16ShortBitsToFloat(expected);
        assertTrue(isInfinite(f));
        assertEquals(POSITIVE_INFINITY, f);
        final short actual = floatToBinary16ShortBits(f);
        assertEquals(expected, actual);
    }

    @Test
    void negative_infinity() {
        final short expected = (short) 0b1_11111_0000000000;
        final float f = binary16ShortBitsToFloat(expected);
        assertTrue(isInfinite(f));
        assertEquals(NEGATIVE_INFINITY, f);
        final short actual = floatToBinary16ShortBits(f);
        assertEquals(actual, expected);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @RepeatedTest(1)
    void test() {
//        final int expected = current().nextInt() & 0xFFFF;
//        final float f1 = binary16IntBitsToFloat(expected);
        final float f1 = current().nextFloat();
        final short actual1 = floatToBinary16ShortBits(f1);
        final short actual2 = floatToBinary16ShortBits(f1);
        log.debug("actual1: {} {}", formatBinary16(actual1), actual1);
        log.debug("actual2: {} {}", formatBinary16(actual2), actual2);
    }
}