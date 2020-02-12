package com.example.mypet.service;

import com.example.mypet.domain.pet.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PetServiceTest {

    @Autowired
    PetService petService;

    @Test
    public void testSortPetFromClassification() {
        List<Pet> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setClassificationId(2);
        Pet pet2 = new Pet();
        pet2.setClassificationId(2);
        Pet pet3 = new Pet();
        pet3.setClassificationId(1);
        petList.add(pet1);
        petList.add(pet2);
        petList.add(pet3);
        long sort = 2;
        List<Pet> returnList = petService.sortPetFromClassification(petList, sort);
        assertEquals(2, returnList.size());
    }

}