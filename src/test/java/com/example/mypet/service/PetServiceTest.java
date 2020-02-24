package com.example.mypet.service;

import com.example.mypet.domain.pet.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetServiceTest {

    @Autowired
    PetService petService;

    @Test
    void getList() {
    }

    @Test
    void getList2() {
    }

    @Test
    void getPet() {
        Pet pet = petService.getPet(1);
        assertEquals(pet.getId(),1);
    }
}