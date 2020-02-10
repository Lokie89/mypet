package com.example.mypet.service;

import com.example.mypet.domain.classification.ClassificationRepository;
import com.example.mypet.domain.pet.PetRepository;
import com.example.mypet.domain.petsituations.PetSituationsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PetService {

    private final PetRepository petRepository;
    private final PetSituationsRepository petSituationsRepository;
    private final ClassificationRepository classificationRepository;

    public PetService(PetRepository petRepository,
                      PetSituationsRepository petSituationsRepository,
                      ClassificationRepository classificationRepository) {
        this.petRepository = petRepository;
        this.petSituationsRepository = petSituationsRepository;
        this.classificationRepository = classificationRepository;
    }

}
