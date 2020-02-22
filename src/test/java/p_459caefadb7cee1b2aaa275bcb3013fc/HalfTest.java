package p_459caefadb7cee1b2aaa275bcb3013fc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static java.lang.Math.pow;
import static java.lang.String.format;
import static java.util.concurrent.ThreadLocalRandom.current;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Half.intBitsToHalf;

@Slf4j
class HalfTest {

    // -----------------------------------------------------------------------------------------------------------------
    private static void printBinary32(final int value) {
        System.out.printf("%1$1s %2$-8s %3$-23s%n",
                          Integer.toBinaryString(value >>> 31),
                          Integer.toBinaryString((value >> 23) & 0b11111111),
                          Integer.toBinaryString(value & 0b11111111111111111111111));
    }

    private static void printBinary16(final int value) {
        System.out.printf("%1$1s %2$-8s %3$-23s%n",
                          Integer.toBinaryString((value >>> 15) & 0b1),
                          Integer.toBinaryString((value >> 10) & 0b11111),
                          Integer.toBinaryString(value & 0b1111111111));
    }

    // -----------------------------------------------------------------------------------------------------------------
    void POSITIVE_INFINITY() {
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void testPositiveZero() {
        {
            final int intBits = 0b0_0000000_0000000000_0000000000_000;
            final float actual = Float.intBitsToFloat(intBits);
            log.debug("positive zero bits to float: {}", actual);
        }
        {
            final int intBits = 0b0_00000_0000000000;
            final float actual = intBitsToHalf(intBits);
            log.debug("positive zero bits to half: {}", actual);
            assertEquals(+0.0f, actual);
        }
    }

    @Test
    void testNegativeZero() {
        {
            final int intBits = 0b1_00000000_0000000000_0000000000_000;
            final float actual = Float.intBitsToFloat(intBits);
            log.debug("negative zero bits to float: {}", actual);
        }
        {
            final int intBits = 0b1_00000_0000000000;
            final float actual = intBitsToHalf(intBits);
            log.debug("negative zero bits to half: {}", actual);
            assertEquals(-0.0f, actual);
        }
    }

    @Test
    void testPositiveInfinity() {
        {
            final int intBits = 0b0_11111111_0000000000_0000000000_000;
            final float actual = Float.intBitsToFloat(intBits);
            log.debug("positive infinity bits to float: {}", actual);
        }
        {
            final int intBits = 0b0_11111_0000000000;
            final float actual = intBitsToHalf(intBits);
            log.debug("positive infinity bits to half: {}", actual);
            assertEquals(Float.POSITIVE_INFINITY, actual);
        }
    }

    @Test
    void testNegativeInfinity() {
        {
            final int intBits = 0b1_11111111_0000000000_0000000000_000;
            final float actual = Float.intBitsToFloat(intBits);
            log.debug("negative infinity bits to float: {}", actual);
        }
        {
            final int intBits = 0b1_11111_0000000000;
            final float actual = intBitsToHalf(intBits);
            log.debug("negative infinity bits to half: {}", actual);
            assertEquals(Float.NEGATIVE_INFINITY, actual);
        }
    }

    private static int randomSignificantOtherThanZero(final int size) {
        while (true) {
            int value = current().nextInt();
            value >>>= (Integer.SIZE - size);
            if (value != 0) {
                return value;
            }
        }
    }

    @Test
    void testSubnormal() {
        //final int sign = current().nextBoolean() ? 0 : 1;
        //final int significand = randomSignificantOtherThanZero(10) << 13;
        final int sign = 0;
        final int significand = 0b100000000_0000000000_0;
//        {
        log.debug("x: {}", pow(2, -126) / pow(2, -14));
        log.debug("x: {}", pow(2, 14) / pow(2, 126));
        final double binary32 = pow(2, -126) * .5;
        final double binary16 = pow(2, -14) * .5;
        log.debug("binary32: {}", format("%10.100f", binary32));
        log.debug("binary16: {}", format("%10.100f", binary16));
        log.debug("a:        {}", format("%10.100f", binary16 * (pow(2, 14) / pow(2, 126))));
//        }
        {
            final int intBits = (sign << 31) | significand;
            printBinary32(intBits);
            final float actual = Float.intBitsToFloat(intBits);
            log.debug("subnormal bits to single: {}", format("%10.100f", actual));
        }
        {
            final int intBits = (sign << 15) | (significand >> 13);
            printBinary16(intBits);
            final float actual = intBitsToHalf(intBits);
            log.debug("subnormal bits to half:   {}", format("%10.100f", actual));
        }
    }

    @Test
    void smallest_positive_subnormal_number() {
        final int binary16 = 0b0_00000_0000000001;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%1.20f", half));
        log.debug("expected: {}", "0.000000059605");
    }

    @Test
    void largest_subnormal_number() {
        final int binary16 = 0b0_00000_1111111111;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%1.20f", half));
        log.debug("expected: {}", "0.000060976");
    }

    @Test
    void smallest_positive_normalNumber() {
        final int binary16 = 0b0_00001_0000000000;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%1.10f", half));
        log.debug("expected: {}", "0.000061035");
    }

    @Test
    void largest_normal_number() {
        final int binary16 = 0b0_11110_1111111111;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%5.10f", half));
        log.debug("expected: {}", "65504");
    }

    @Test
    void largest_number_less_than_one() {
        final int binary16 = 0b0_01110_1111111111;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%1.20f", half));
        log.debug("expected: {}", "0.99951");
    }

    @Test
    void one() {
        final int binary16 = 0b0_01111_0000000000;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%1.20f", half));
        log.debug("expected: {}", "1");
    }

    @Test
    void smallest_number_larger_than_one() {
        final int binary16 = 0b0_01111_0000000001;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%1.20f", half));
        log.debug("expected: {}", "1.001");
    }

    @Test
    void equal_to_one_third() {
        final int binary16 = 0b0_01101_0101010101;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%1.20f", half));
        log.debug("expected: {}", "0.333251953125");
    }

    @Test
    void minus_two() {
        final int binary16 = 0b1_10000_0000000000;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%2.20f", half));
        log.debug("expected: {}", "-2");
    }

    @Test
    void positive_zero() {
        final int binary16 = 0b0_00000_0000000000;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%+2.20f", half));
        log.debug("expected: {}", "+0");
    }

    @Test
    void negative_zero() {
        final int binary16 = 0b1_00000_0000000000;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%+2.20f", half));
        log.debug("expected: {}", "-0");
    }

    @Test
    void positive_infinity() {
        final int binary16 = 0b0_11111_0000000000;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%f", half));
        log.debug("expected: {}", "Infinity");
    }

    @Test
    void negative_infinity() {
        final int binary16 = 0b1_11111_0000000000;
        final float half = intBitsToHalf(binary16);
        log.debug("actual:   {}", format("%f", half));
        log.debug("expected: {}", "-Infinity");
    }
}