package cn.aidawone.atomtestingjavajunit5.controllers;

import cn.aidawone.atomtestingjavajunit5.controllers.test.ModuleRepeatedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

/**
 * @description:
 * @author：zhanggr
 * @date: 2022/11/24
 */
public class PersionRepeatedTest implements ModuleRepeatedTest {
    @RepeatedTest(value = 10, name = "{displayName} :: repetition {currentRepetition} of {totalRepetitions}")
    @DisplayName("repeated test")
    void testRepeatability() {
        System.out.println("testRepeatability");
    }

    @RepeatedTest(5)
    void testRepeatedInfo(TestInfo testInfo, RepetitionInfo repetitionInfo, TestReporter testReporter) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
        System.out.println(repetitionInfo.getTotalRepetitions());

        testReporter.publishEntry("test");
        testReporter.publishEntry("key", "Buck");
    }

    @RepeatedTest(value = 5, name = "{displayName} :: repetition {currentRepetition} of {totalRepetitions}")
    @DisplayName("my assigmentRepeat")
    void testAssigmentRepeat() {
        System.out.println("assigmentRepeat");
    }
}
