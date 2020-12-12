package p_b06c3f33ece93939e55f379ac569f468;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class 干支Test {

    @Test
    void test_ALL_COMBINATIONS() {
        for (int i = 0; i < 干支.ALL_INSTANCES.size(); i++) {
            log.debug("[{}]: {}", i, 干支.ALL_INSTANCES.get(i));
        }
        assertThat(new HashSet<>(干支.ALL_INSTANCES).size()).isEqualTo(干支.ALL_INSTANCES.size());
    }

    @Test
    void testValueOf() {
        final 干支.天干[] 干们 = 干支.天干.values();
        final 干支.地支[] 支们 = 干支.地支.values();
        for (干支.天干 干 : 干们) {
            for (干支.地支 支 : 支们) {
                final 干支 value = 干支.valueOf(干, 支);
                assertThat(value).isNotNull().satisfies(v -> {
                    assertThat(干支.ALL_INSTANCES.indexOf(v)).isEqualTo(干支.indexOf(干, 支));
                });
            }
        }
    }
}