package cn.aidawone.atomtestingjavajunit5.controllers;

import cn.aidawone.atomtestingjavajunit5.controllers.test.ModuleTests;
import cn.aidawone.atomtestingjavajunit5.fauxspring.impl.ModelImpl;
import cn.aidawone.atomtestingjavajunit5.model.Vet;
import cn.aidawone.atomtestingjavajunit5.services.SpecialtyService;
import cn.aidawone.atomtestingjavajunit5.services.VetService;
import cn.aidawone.atomtestingjavajunit5.services.map.SpecialityMapService;
import cn.aidawone.atomtestingjavajunit5.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @description:
 * @author：zhanggr
 * @date: 2022/11/23
 */
class VetControllerTest implements ModuleTests {

    VetService vetService;
    SpecialtyService specialtyService;
    VetController vetController;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);

        //init data
        Vet vet = new Vet(1L, "firstName", "lastName", null);
        Vet vet2 = new Vet(2L, "firstName2", "lastName2", null);
        vetService.save(vet);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        ModelImpl model = new ModelImpl();

        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);
        Set modelAtrributes = (Set) model.map.get("vets");
        assertThat(modelAtrributes.size()).isEqualTo(2);
    }
}