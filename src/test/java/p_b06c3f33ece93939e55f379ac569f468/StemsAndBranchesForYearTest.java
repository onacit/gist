package p_b06c3f33ece93939e55f379ac569f468;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class StemsAndBranchesForYearTest { // 干支Test

    static 干支.歲次 of2020庚子() {
        if (current().nextBoolean()) {
            final 天干 stem = 天干.valueOf("庚");
            final 地支 branch = 地支.valueOf("子");
            final 干支 ganzhi = 干支.valueOf(stem, branch);
            return new 干支.歲次(ganzhi, Year.of(2020));
        } else {
            final 天干 stem = 天干.valueOfKoreanName("경");
            final 地支 branch = 地支.valueOfKoreanName("자");
            final 干支 ganzhi = 干支.valueOf(stem, branch);
            return new 干支.歲次(ganzhi, Year.of(2020));
        }
    }

    @Test
    void test_of2020庚子() {
        final 干支.歲次 歲次 = of2020庚子();
        assertThat(歲次.getGanzhi()).isNotNull().isEqualTo(干支.valueOf(天干.valueOf("庚"), 地支.valueOf("子")));
        assertThat(歲次.getYear()).isNotNull().isEqualTo(Year.of(2020));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void testGetPrevious() {
        final 干支.歲次 庚子2020 = of2020庚子();
        final 干支 己亥 = 干支.valueOfName("己亥"); // 기해
        log.debug("己亥: {}", 己亥);
        assertThat(庚子2020.getPrevious()).isNotNull().isEqualTo(new 干支.歲次(己亥, Year.of(2019)));
    }

    @Test
    void testGetNext() {
        final 干支.歲次 庚子2020 = of2020庚子();
        final 干支 辛丑 = 干支.valueOfName("辛丑"); // 신축
        log.debug("辛丑: {}", 辛丑);
        assertThat(庚子2020.getNext()).isNotNull().isEqualTo(new 干支.歲次(辛丑, Year.of(2021)));
    }
}