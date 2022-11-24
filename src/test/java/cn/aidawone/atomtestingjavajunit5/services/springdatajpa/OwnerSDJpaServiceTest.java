package cn.aidawone.atomtestingjavajunit5.services.springdatajpa;

import cn.aidawone.atomtestingjavajunit5.controllers.test.ControllerTests;
import cn.aidawone.atomtestingjavajunit5.model.Owner;
import jdk.jfr.Enabled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @description:
 * @author：zhanggr
 * @date: 2022/11/23
 */
//@Disabled("disable test")
class OwnerSDJpaServiceTest implements ControllerTests {

    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        service = new OwnerSDJpaService(null, null, null);
    }

    @Test
    @Disabled
    void findByLastName() {
        Owner aidawone = service.findByLastName("aidawone");
        assertNotNull(aidawone, "owner not found");
    }

    @Test
    @DisplayName("i can findall ")
    void findAllByLastNameLike() {
    }

    @Test
    @Disabled("Demo2 of timeout")
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(1000);
            System.out.println("I go here");
        });
    }

    @Test
    @Disabled("Demo of timeout")
    void testTimeOutPremise() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I go here");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("AIDAWONE".equalsIgnoreCase(System.getenv("DEV")));
        System.out.println("test");
    }

    @Test
    void testAssumptionTrue_unsing_ture() {
        assumeTrue("AIDAWONE".equalsIgnoreCase("AIDAWONE"));
        System.out.println("test demo");
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeMacOS() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testWindow() {
    }


    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testJava11() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "aidawone")
    @Test
    void testIfUserFreeze_aidawoneEqual() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "aidawone2")
    @Test
    void testIfUserFreeze() {
    }
}