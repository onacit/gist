package g_2d743cfd472de915cbb86736f3be3c3c;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class JavaTimeUtilsTest {

    @Test
    void epochMilliToLocalDate__() {
        final long epochMilli = System.currentTimeMillis();
        {
            final ZoneId zoneId = ZoneId.systemDefault();
            final LocalDate actual = JavaTimeUtils.epochMilliToLocalDate(epochMilli, zoneId);
            final LocalDate expected = new Date(epochMilli).toInstant().atZone(zoneId).toLocalDate();
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(expected)
            ;
        }
        ZoneId.getAvailableZoneIds().stream().map(ZoneId::of).forEach(zoneId -> {
            final LocalDate actual = JavaTimeUtils.epochMilliToLocalDate(epochMilli, zoneId);
            final LocalDate expected = new Date(epochMilli).toInstant().atZone(zoneId).toLocalDate();
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(expected)
            ;
        });
    }

    @Test
    void localDateToEpochMilli__() {
        final LocalDate localDate = LocalDate.now();
        {
            final ZoneId zoneId = ZoneId.systemDefault();
            final Long actual = JavaTimeUtils.localDateToEpochMilli(localDate, zoneId);
            final Long expected = Date.from(localDate.atStartOfDay().atZone(zoneId).toInstant()).getTime();
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(expected)
            ;
        }
        ZoneId.getAvailableZoneIds().stream().map(ZoneId::of).forEach(zoneId -> {
            final Long actual = JavaTimeUtils.localDateToEpochMilli(localDate, zoneId);
            final Long expected = Date.from(localDate.atStartOfDay().atZone(zoneId).toInstant()).getTime();
            assertThat(actual)
                    .isNotNull()
                    .isEqualTo(expected)
            ;
        });
    }
}