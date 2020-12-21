package p_b06c3f33ece93939e55f379ac569f468;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.Year;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;
import static p_b06c3f33ece93939e55f379ac569f468.StemsAndBranchesForYearTest.of2020庚子;

@Slf4j
class StemsAndBranchesForMonthTest { // 月建Test

    static 干支.月建 of2020庚子04辛巳() {
        final 干支.歲次 歲次 = of2020庚子();
        if (current().nextBoolean()) {
            final 天干 stem = 天干.valueOf("辛");
            final 地支 branch = 地支.valueOf("巳");
            final 干支 ganzhi = 干支.valueOf(stem, branch);
            return new 干支.月建(ganzhi, 歲次, Month.APRIL);
        } else {
            final 天干 stem = 天干.valueOfKoreanName("신");
            final 地支 branch = 地支.valueOfKoreanName("사");
            final 干支 ganzhi = 干支.valueOf(stem, branch);
            return new 干支.月建(ganzhi, 歲次, Month.APRIL);
        }
    }

    @Test
    void test_of2020庚子04辛巳() {
        final 干支.月建 月建 = of2020庚子04辛巳();
        assertThat(月建.getGanzhi()).isNotNull().isEqualTo(干支.valueOf(天干.valueOf("辛"), 地支.valueOf("巳")));
        assertThat(月建.getYear()).isNotNull().isEqualTo(Year.of(2020));
        assertThat(月建.getMonth()).isNotNull().isEqualTo(Month.APRIL);
        assertThat(月建.isLeapMonth()).isFalse();
    }
}