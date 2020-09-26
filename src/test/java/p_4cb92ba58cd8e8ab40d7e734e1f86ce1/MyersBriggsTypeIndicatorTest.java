package p_4cb92ba58cd8e8ab40d7e734e1f86ce1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import p_4cb92ba58cd8e8ab40d7e734e1f86ce1.MyersBriggsTypeIndicator.Attitude;
import p_4cb92ba58cd8e8ab40d7e734e1f86ce1.MyersBriggsTypeIndicator.JudgingFunction;
import p_4cb92ba58cd8e8ab40d7e734e1f86ce1.MyersBriggsTypeIndicator.LifestylePreference;
import p_4cb92ba58cd8e8ab40d7e734e1f86ce1.MyersBriggsTypeIndicator.PerceivingFunction;

@Slf4j
class MyersBriggsTypeIndicatorTest {

    @Test
    void a() {
        for (final Attitude a : Attitude.values()) {
            for (final PerceivingFunction p : PerceivingFunction.values()) {
                for (final JudgingFunction j : JudgingFunction.values()) {
                    for (final LifestylePreference l : LifestylePreference.values()) {
                        final MyersBriggsTypeIndicator v = new MyersBriggsTypeIndicator(a, p, j, l);
                        final String word = v.toFourLetterTestResult();
                        log.debug("word: {}", word);
                    }
                }
            }
        }
    }
}