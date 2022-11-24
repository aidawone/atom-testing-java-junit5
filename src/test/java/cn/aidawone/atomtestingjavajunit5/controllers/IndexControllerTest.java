package cn.aidawone.atomtestingjavajunit5.controllers;

import cn.aidawone.atomtestingjavajunit5.controllers.test.ControllerTests;
import cn.aidawone.atomtestingjavajunit5.controllers.test.ModuleTests;
import cn.aidawone.atomtestingjavajunit5.exception.ValueNotSupportedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author：zhanggr
 * @date: 2022/11/22
 */
class IndexControllerTest implements ControllerTests {

    private IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "wrong view Returned");

        assertThat(indexController.index()).isEqualTo("index");
    }

    @Test
    void oupsHandler_usingException_valueNotSupportException() {
        assertThrows(ValueNotSupportedException.class, () -> indexController.oupsHandler(), "value not supported");
    }
}