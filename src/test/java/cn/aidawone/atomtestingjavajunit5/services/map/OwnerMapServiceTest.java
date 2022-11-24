package cn.aidawone.atomtestingjavajunit5.services.map;

import cn.aidawone.atomtestingjavajunit5.controllers.test.ModuleTests;
import cn.aidawone.atomtestingjavajunit5.model.Owner;
import cn.aidawone.atomtestingjavajunit5.model.PetType;
import cn.aidawone.atomtestingjavajunit5.services.PetService;
import cn.aidawone.atomtestingjavajunit5.services.PetTypeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @description:
 * @author：zhanggr
 * @date: 2022/11/23
 */
@DisplayName("ownerService nested test")
class OwnerMapServiceTest implements ModuleTests {
    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();

        System.out.println("first setUp one");
        ownerMapService = new OwnerMapService(petTypeService, petService);
    }

    @Test
    @DisplayName("verify Zero Owner")
    void testOwnerZero() {
        int count = ownerMapService.findAll().size();
        assertThat(count).isZero();
    }

    @DisplayName("verify still zero Owner")
    @Test
    void testOwnerStillZero() {
        int count = ownerMapService.findAll().size();
        assertThat(count).isZero();
    }

    @Nested
    @DisplayName("verify pet create")
    class TestCreatePetTypes {
        @BeforeEach
        void setUp() {
            PetType petType = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "Cat");
            petTypeService.save(petType);
            petTypeService.save(petType2);
        }

        @DisplayName("Test Pet Count")
        @Test
        void testPetCount() {
            int petTypeCount = petTypeService.findAll().size();

            Assertions.assertThat(petTypeCount).isNotZero().isEqualTo(2);
        }

        @DisplayName("Save Owners Tests - ")
        @Nested
        class SaveOwnersTests {

            @BeforeEach
            void setUp() {
                System.out.println("nested setUp one");
                ownerMapService.save(new Owner(1L, "Before", "Each"));
            }

            @DisplayName("Save Owner")
            @Test
            void saveOwner() {
                Owner owner = new Owner(2L, "Joe", "Buck");

                Owner savedOwner = ownerMapService.save(owner);

                Assertions.assertThat(savedOwner).isNotNull();
            }

            @DisplayName("Save Owners Tests - ")
            @Nested
            class FindOwnersTests {

                @DisplayName("Find Owner")
                @Test
                void findOwner() {

                    Owner foundOwner = ownerMapService.findById(1L);

                    Assertions.assertThat(foundOwner).isNotNull();
                }

                @DisplayName("Find Owner Not Found")
                @Test
                void findOwnerNotFound() {

                    Owner foundOwner = ownerMapService.findById(2L);

                    Assertions.assertThat(foundOwner).isNull();
                }
            }
        }

    }
}