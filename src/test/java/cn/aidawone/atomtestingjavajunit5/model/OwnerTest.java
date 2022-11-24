package cn.aidawone.atomtestingjavajunit5.model;

import java.util.HashSet;
import java.util.stream.Stream;

import cn.aidawone.atomtestingjavajunit5.common.OwnerType;
import cn.aidawone.atomtestingjavajunit5.controllers.test.ControllerTests;
import cn.aidawone.atomtestingjavajunit5.custom.CustomArgsProvider;
import cn.aidawone.atomtestingjavajunit5.model.Pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author：zhanggr
 * @date: 2022/11/22
 */
@Disabled("disable")
class OwnerTest implements ControllerTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testOwnerValue_valueEquals() {
        Owner owner = new Owner(1l, "joining", "birthDate");
        owner.setAddress("dizhi");
        owner.setCity("date");
        owner.setTelephone("137");
        HashSet<Pet> pets = new HashSet<>();
        owner.setPets(pets);


        assertAll("Properties test ", () -> assertAll("Persion properties test", () -> assertEquals("joining", owner.getFirstName(), "Persion firstName is not equal to"), () -> assertEquals("birthDate", owner.getLastName(), "Persion lastName is not equal to")), () -> assertAll("Owner properties test", () -> assertEquals("dizhi", owner.getAddress(), "Owner address is not equal to"), () -> assertEquals("date", owner.getCity(), "Owner city is not equal to"), () -> assertEquals("137", owner.getTelephone(), "owner phone is not equal to")));
        //hamcrest test
        assertThat(owner.getCity(), is("date"));
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @DisplayName("value source -")
    @ValueSource(strings = {"string", "integer", "aidawone"})
    void testValuesSource(String value) {
        System.out.println(value);
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @DisplayName("enum source -")
    @EnumSource(value = OwnerType.class)
    void testValuesEnumSource(OwnerType value) {
        System.out.println(value);
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @DisplayName("csc source -")
    @CsvSource({"FL, 1, 1", "OH, 2, 2", "MI, 1, 1,"})
    void testCsvInput(String startName, int in1, int int2) {
        System.out.println(startName + ":" + in1 + ":" + int2);
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @DisplayName("csc file source -")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void testFileCsvInput(String startName, int in1, int int2) {
        System.out.println(startName + ":" + in1 + ":" + int2);
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @DisplayName("method  source -")
    @MethodSource(value = "getArgument")
    void testMethodInput(String startName, int in1, int int2) {
        System.out.println(startName + ":" + in1 + ":" + int2);
    }

    static Stream<Arguments> getArgument() {
        return Stream.of(
                Arguments.of("FL", 1, 1),
                Arguments.of("OH", 2, 2),
                Arguments.of("MI", 1, 1)
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @DisplayName("method  source -")
    @ArgumentsSource(value = CustomArgsProvider.class)
    void testfromClassInput(String startName, int in1, int int2) {
        System.out.println(startName + ":" + in1 + ":" + int2);
    }
}