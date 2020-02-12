package com.example.mypet.service;

import com.example.mypet.domain.classification.ClassificationRepository;
import com.example.mypet.domain.pet.Pet;
import com.example.mypet.domain.pet.PetRepository;
import com.example.mypet.domain.petsituations.PetSituationsRepository;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    protected List<Pet> sortPetFromClassification(List<Pet> petList, long classification) {
        petList = petList.stream().filter((pet) -> pet.getClassificationId() == classification).collect(Collectors.toList());
        return petList;
    }

    // https://codechacha.com/ko/java8-stream-sorted/
    protected List<Pet> sortPetFromSortCondition(List<Pet> petList, String sortCondition){
        return new ArrayList<>();
    }

    public List<Pet> getAllPetList(){
        return petRepository.findAll();
    }


}


