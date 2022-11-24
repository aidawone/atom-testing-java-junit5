package cn.aidawone.atomtestingjavajunit5.controllers.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

/**
 * @description:
 * @author：zhanggr
 * @date: 2022/11/24
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("controllers")
public interface ControllerTests {
    @BeforeAll
    default  void beforeAll() {
        System.out.println("Let's start do thing here'");
    }
}
