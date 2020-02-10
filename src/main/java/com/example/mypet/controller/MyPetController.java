package com.example.mypet.controller;

import com.example.mypet.service.PetService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPetController {
    private final PetService petService;

    public MyPetController(PetService petService) {
        this.petService = petService;
    }

}
