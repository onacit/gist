package p_4cb92ba58cd8e8ab40d7e734e1f86ce1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import p_4cb92ba58cd8e8ab40d7e734e1f86ce1.MyersBriggsTypeIndicator.Attitude;
import p_4cb92ba58cd8e8ab40d7e734e1f86ce1.MyersBriggsTypeIndicator.JudgingFunction;
import p_4cb92ba58cd8e8ab40d7e734e1f86ce1.MyersBriggsTypeIndicator.LifestylePreference;
import p_4cb92ba58cd8e8ab40d7e734e1f86ce1.MyersBriggsTypeIndicator.PerceivingFunction;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MyersBriggsTypeIndicatorTest {

    @Test
    void valueOf_() {
        for (final Attitude a : Attitude.values()) {
            for (final PerceivingFunction p : PerceivingFunction.values()) {
                for (final JudgingFunction j : JudgingFunction.values()) {
                    for (final LifestylePreference l : LifestylePreference.values()) {
                        assertThat(MyersBriggsTypeIndicator.valueOf(a, p, j, l))
                                .isNotNull()
                                .satisfies(v -> {
                                    assertThat(v.attitude).isSameAs(a);
                                    assertThat(v.perceivingFunction).isSameAs(p);
                                    assertThat(v.judgingFunction).isSameAs(j);
                                    assertThat(v.lifestylePreference).isSameAs(l);
                                    assertThat(v).isSameAs(MyersBriggsTypeIndicator.valueOf(v.toString()));
                                });
                    }
                }
            }
        }
    }
}
