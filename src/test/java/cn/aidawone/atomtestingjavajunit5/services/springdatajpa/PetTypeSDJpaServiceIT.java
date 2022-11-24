package cn.aidawone.atomtestingjavajunit5.services.springdatajpa;

import cn.aidawone.atomtestingjavajunit5.junitextensions.TimingExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * 集成
 *
 * @description:
 * @author：zhanggr
 * @date: 2022/11/24
 */
@ExtendWith(TimingExtension.class)
class PetTypeSDJpaServiceIT {

    @BeforeEach
    void setUp() {
        System.out.println("IT");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}