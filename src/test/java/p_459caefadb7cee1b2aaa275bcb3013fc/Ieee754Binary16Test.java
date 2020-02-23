package p_459caefadb7cee1b2aaa275bcb3013fc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16.binary16IntToFloat;

@Slf4j
class Ieee754Binary16Test {

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

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void smallest_positive_subnormal_number() {
        final int binary16 = 0b0_00000_0000000001;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%1.20f", half));
        log.debug("expected: {}", "0.000000059605");
    }

    @Test
    void largest_subnormal_number() {
        final int binary16 = 0b0_00000_1111111111;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%1.20f", half));
        log.debug("expected: {}", "0.000060976");
    }

    @Test
    void smallest_positive_normalNumber() {
        final int binary16 = 0b0_00001_0000000000;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%1.10f", half));
        log.debug("expected: {}", "0.000061035");
    }

    @Test
    void largest_normal_number() {
        final int binary16 = 0b0_11110_1111111111;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%5.10f", half));
        log.debug("expected: {}", "65504");
    }

    @Test
    void largest_number_less_than_one() {
        final int binary16 = 0b0_01110_1111111111;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%1.20f", half));
        log.debug("expected: {}", "0.99951");
    }

    @Test
    void one() {
        final int binary16 = 0b0_01111_0000000000;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%1.20f", half));
        log.debug("expected: {}", "1");
    }

    @Test
    void smallest_number_larger_than_one() {
        final int binary16 = 0b0_01111_0000000001;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%1.20f", half));
        log.debug("expected: {}", "1.001");
    }

    @Test
    void equal_to_one_third() {
        final int binary16 = 0b0_01101_0101010101;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%1.20f", half));
        log.debug("expected: {}", "0.333251953125");
    }

    @Test
    void minus_two() {
        final int binary16 = 0b1_10000_0000000000;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%2.20f", half));
        log.debug("expected: {}", "-2");
    }

    @Test
    void positive_zero() {
        final int binary16 = 0b0_00000_0000000000;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%+2.20f", half));
        log.debug("expected: {}", "+0");
    }

    @Test
    void negative_zero() {
        final int binary16 = 0b1_00000_0000000000;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%+2.20f", half));
        log.debug("expected: {}", "-0");
    }

    @Test
    void positive_infinity() {
        final int binary16 = 0b0_11111_0000000000;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%f", half));
        log.debug("expected: {}", "Infinity");
    }

    @Test
    void negative_infinity() {
        final int binary16 = 0b1_11111_0000000000;
        final float half = binary16IntToFloat(binary16);
        log.debug("actual:   {}", format("%f", half));
        log.debug("expected: {}", "-Infinity");
    }
}