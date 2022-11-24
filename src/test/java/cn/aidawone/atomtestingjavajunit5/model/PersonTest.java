package cn.aidawone.atomtestingjavajunit5.model;

import cn.aidawone.atomtestingjavajunit5.controllers.test.ModuleTests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @description:
 * @author：zhanggr
 * @date: 2022/11/22
 */
class PersonTest implements ModuleTests {
    @BeforeEach
    void setUp() {
    }

    @Test
    void groupAssertions() {
        //given
        Person person = new Person(1L, "john", "Buck");
        //then
        assertAll("tEST Props",
                () -> assertEquals("Buck", person.getLastName()),
                () -> assertEquals("1", person.getId().toString()),
                () -> assertEquals("john", person.getFirstName()));
    }

    @Test
    void groupAssertions_usingMessage() {
        //given
        Person person = new Person(1L, "john", "Buck");
        //then
        assertAll("tEST Props",
                () -> assertEquals("Buck", person.getLastName(), "This is lastName error"),
                () -> assertEquals("john", person.getFirstName(), "This is firstName error"));
    }

    @AfterEach
    void tearDown() {
    }
}
