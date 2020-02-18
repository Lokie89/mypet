package com.example.mypet.service.filter;

import com.example.mypet.domain.pet.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FilterServiceTest {

    @Autowired
    FilterService filterService;

    @Test
    public void testFilterService(){
        List<Pet> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setAge(50);
        Pet pet2 = new Pet();
        pet2.setAge(30);
        petList.add(pet1);
        petList.add(pet2);
        List<Pet> filterPet = filterService.filterPet(petList, "AGE", 30);
        assertEquals(30, filterPet.get(0).getAge());
    }
}