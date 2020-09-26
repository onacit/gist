package p_459caefadb7cee1b2aaa275bcb3013fc;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Integer.toBinaryString;
import static java.lang.String.format;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16.MASK_EXPONENT_32;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16.MASK_SIGNIFICAND_32;
import static p_459caefadb7cee1b2aaa275bcb3013fc.Ieee754Binary16.SIZE_SIGNIFICAND_BINARY32;

@Slf4j
public class Ieee754Binary16Test {

    // -----------------------------------------------------------------------------------------------------------------
    public static String formatBinary32(final int value) {
        return format("%1$1s %2$8s %3$23s",
                      toBinaryString(value >>> (Integer.SIZE - 1)),
                      toBinaryString((value & MASK_EXPONENT_32) >> SIZE_SIGNIFICAND_BINARY32),
                      toBinaryString(value & MASK_SIGNIFICAND_32)
        );
    }
}