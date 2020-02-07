package com.example.mypet.controller;

import com.example.mypet.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MyPetController {
    private final PetService petService;

    public MyPetController(PetService petService) {
        this.petService = petService;
    }

}
