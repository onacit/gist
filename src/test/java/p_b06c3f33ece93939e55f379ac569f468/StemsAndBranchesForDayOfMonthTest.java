package p_b06c3f33ece93939e55f379ac569f468;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.Year;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;
import static p_b06c3f33ece93939e55f379ac569f468.StemsAndBranchesForMonthTest.of202004;

@Slf4j
class StemsAndBranchesForDayOfMonthTest { // 月建Test

    static 干支.日辰 of20200423() {
        final 干支.月建 月建 = of202004();
        if (current().nextBoolean()) {
            final 天干 stem = 天干.valueOf("丙");
            final 地支 branch = 地支.valueOf("申");
            final 干支 ganzhi = 干支.of(stem, branch);
            return new 干支.日辰(ganzhi, 月建, 23);
        } else {
            final 天干 stem = 天干.valueOfKoreanName("병");
            final 地支 branch = 地支.valueOfKoreanName("신");
            final 干支 ganzhi = 干支.of(stem, branch);
            return new 干支.日辰(ganzhi, 月建, 23);
        }
    }

    @Test
    void test_20200423() {
        final 干支.日辰 日辰 = of20200423();
        assertThat(日辰.getGanzhi()).isNotNull().isEqualTo(干支.of(天干.valueOf("丙"), 地支.valueOf("申")));
        assertThat(日辰.getYear()).isNotNull().isEqualTo(Year.of(2020));
        assertThat(日辰.getMonth()).isNotNull().isEqualTo(Month.APRIL);
        assertThat(日辰.getDayOfMonth()).isEqualTo(23);
    }
}