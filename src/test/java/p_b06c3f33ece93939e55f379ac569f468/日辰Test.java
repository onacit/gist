package p_b06c3f33ece93939e55f379ac569f468;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import p_b06c3f33ece93939e55f379ac569f468.干支.日辰;
import p_b06c3f33ece93939e55f379ac569f468.干支.月建;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static p_b06c3f33ece93939e55f379ac569f468.StemsAndBranchesForMonthTest.of2020庚子年04辛巳月;
import static p_b06c3f33ece93939e55f379ac569f468.StemsAndBranchesForMonthTest.of2020庚子年04閏四月;
import static p_b06c3f33ece93939e55f379ac569f468.StemsAndBranchesForMonthTest.of2020庚子年12戊子月;

@Slf4j
class StemsAndBranchesForDateTest { // 月建Test

    // ------------------------------------------------------------------------------------------------------ 2020-04-01
    static 日辰 of2020庚子年04辛巳月01丙申日() { // 경자년 신사월 병신일
        return new 日辰(干支.valueOfName("丙申"), of2020庚子年04辛巳月(), 1);
    }

    static 日辰 of2020庚子年04閏四月01丙寅日() { // 경자년 윤사월 병인일
        return new 日辰(干支.valueOfName("丙寅"), of2020庚子年04閏四月(), 1);
    }

    // -------------------------------------------------------------------------------- (陰) 2020-11-14 / (陽) 2020-12-28
    static 日辰 of2020庚子年11戊子月14乙巳日() { // 경자년 무자월 을사일
        return new 日辰(干支.valueOfName("乙巳"), of2020庚子年12戊子月(), 14);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static Stream<日辰> parameters() {
        return Stream.of(
                of2020庚子年04辛巳月01丙申日(),
                of2020庚子年04閏四月01丙寅日(),
                of2020庚子年11戊子月14乙巳日()
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("new 日辰(,![1..30],) -> IllegalArgumentException")
    @MethodSource({"p_b06c3f33ece93939e55f379ac569f468.StemsAndBranchesForMonthTest#parameters"})
    @ParameterizedTest
    void assertConstructorThrowsIllegalArgumentsExceptionForInvalidDayOfMonth(final 月建 月建) {
        final 干支 干支 = 月建.get歲次().get干支();
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new 日辰(干支, 月建, 0);
                }
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new 日辰(干支, 月建, 31);
                }
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testToString(final 日辰 日辰) {
        assertThat(日辰.toString()).isNotBlank();
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testEquals(final 日辰 日辰) {
        assertThat(日辰).isEqualTo(new 日辰(日辰.get干支(), 日辰.get月建(), 日辰.getDayOfMonth()));
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testHashCode(final 日辰 日辰) {
        final int hashCode = 日辰.hashCode();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testCompareTo(final 日辰 日辰) throws CloneNotSupportedException {
        assertThat(日辰.compareTo(日辰.clone())).isZero();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGet干支(final 日辰 日辰) {
        assertThat(日辰.get干支()).satisfies(v -> {
        });
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGetYear(final 日辰 日辰) {
        assertThat(日辰.getYear()).satisfies(v -> {
        });
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGetMonth(final 日辰 日辰) {
        assertThat(日辰.getMonth()).satisfies(v -> {
        });
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGetDayOfMonth(final 日辰 日辰) {
        assertThat(日辰.getDayOfMonth()).isBetween(1, 30);
    }
}