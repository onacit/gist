package p_b06c3f33ece93939e55f379ac569f468;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class EarthlyBranchesTest { // 干支Test

    @Test
    void test_NAME_REGEXP() {
        final Pattern pattern = Pattern.compile(地支.NAME_REGEXP);
        for (final 地支 value : 地支.values()) {
            assertThat(pattern.matcher(value.name()).matches()).isTrue();
        }
    }

    @Test
    void test_KOREAN_NAME_REGEXP() {
        final Pattern pattern = Pattern.compile(地支.NAME_REGEXP_KOREAN);
        for (final 地支 value : 地支.values()) {
            assertThat(pattern.matcher(value.koreanName()).matches()).isTrue();
        }
    }
}