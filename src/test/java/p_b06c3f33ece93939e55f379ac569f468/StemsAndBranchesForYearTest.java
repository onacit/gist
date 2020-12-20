package p_b06c3f33ece93939e55f379ac569f468;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class StemsAndBranchesForYearTest { // 干支Test

    static 干支.歲次 of2020() {
        if (current().nextBoolean()) {
            final 天干 stem = 天干.valueOf("庚");
            final 地支 branch = 地支.valueOf("子");
            final 干支 ganzhi = 干支.of(stem, branch);
            return new 干支.歲次(ganzhi, Year.of(2020));
        } else {
            final 天干 stem = 天干.valueOfKoreanName("경");
            final 地支 branch = 地支.valueOfKoreanName("자");
            final 干支 ganzhi = 干支.of(stem, branch);
            return new 干支.歲次(ganzhi, Year.of(2020));
        }
    }

    @Test
    void test_2020() {
        final 干支.歲次 歲次 = of2020();
        assertThat(歲次.getGanzhi()).isNotNull().isEqualTo(干支.of(天干.valueOf("庚"), 地支.valueOf("子")));
        assertThat(歲次.getYear()).isNotNull().isEqualTo(Year.of(2020));
    }
}