package cn.aidawone.atomtestingjavajunit5.controllers.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

/**
 * @description:
 * @author：zhanggr
 * @date: 2022/11/24
 */
@Tag("repeated")
public interface ModuleRepeatedTest {
    @BeforeEach
    default void beforeEachConsoleOutput(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Runing --" + testInfo.getDisplayName() + "- " + repetitionInfo.getCurrentRepetition());
    }
}
