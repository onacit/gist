package p_b06c3f33ece93939e55f379ac569f468;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class StemsAndBranchesTest { // 干支Test

    @Test
    void test_VALUES() {
        for (int i = 0; i < 干支.VALUES.size(); i++) {
            log.debug("[{}]: {}", format("%1$2d", i), 干支.VALUES.get(i));
        }
        assertThat(new HashSet<>(干支.VALUES).size()).isEqualTo(干支.VALUES.size());
    }

    @Test
    void testOf() {
        final 天干[] 干们 = 天干.values();
        final 地支[] 支们 = 地支.values();
        for (天干 干 : 干们) {
            for (地支 支 : 支们) {
                final 干支 value = 干支.of(干, 支);
                assertThat(value).isNotNull().satisfies(v -> {
                    assertThat(干支.VALUES.indexOf(v)).isEqualTo(干支.index(干, 支));
                });
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void testGetPrevious() {
        for (final 干支 干支 : 干支.VALUES) {
            assertThat(干支.getPrevious()).isNotNull();
        }
    }

    @Test
    void testGetNext() {
        for (final 干支 干支 : 干支.VALUES) {
            assertThat(干支.getNex()).isNotNull();
        }
    }
}