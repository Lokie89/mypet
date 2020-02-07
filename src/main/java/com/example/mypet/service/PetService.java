package com.example.mypet.service;

import com.example.mypet.domain.pet.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

}
