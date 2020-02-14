package com.example.mypet.service;

import com.example.mypet.domain.pet.Pet;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum PetSortCondition implements Sort<Pet> {

    SITUATION {
        public List<Pet> sort(List<Pet> petList, boolean ascending) {
            Comparator comparator = Comparator.comparingDouble(Pet::getSituationId);

            return petList.stream().sorted(Comparator.comparingDouble(Pet::getSituationId)).collect(Collectors.toList());
        }
    }, NAME {
        public List<Pet> sort(List<Pet> petList, boolean ascending) {
            return petList.stream().sorted(Comparator.comparing(Pet::getName)).collect(Collectors.toList());
        }
    }, AGE {
        public List<Pet> sort(List<Pet> petList, boolean ascending) {
            return petList.stream().sorted(Comparator.comparingInt(Pet::getAge)).collect(Collectors.toList());
        }
    }, GENDER {
        public List<Pet> sort(List<Pet> petList, boolean ascending) {
            return petList.stream().sorted(Comparator.comparing(Pet::getGender)).collect(Collectors.toList());
        }
    }, NEUTERED {
        public List<Pet> sort(List<Pet> petList, boolean ascending) {
            return petList.stream().sorted(Comparator.comparing(pet -> Boolean.valueOf(pet.isNeutered()))).collect(Collectors.toList());
        }
    }, OPEN_DATE {
        public List<Pet> sort(List<Pet> petList, boolean ascending) {
            return petList.stream().sorted(Comparator.comparing(pet -> Date.valueOf(pet.getOpenDate()))).collect(Collectors.toList());
        }
    }, CLOSE_DATE {
        public List<Pet> sort(List<Pet> petList, boolean ascending) {
            return petList.stream().sorted(Comparator.comparing(pet -> Date.valueOf(pet.getCloseDate()))).collect(Collectors.toList());
        }
    }, CLASSIFICATION {
        public List<Pet> sort(List<Pet> petList, boolean ascending) {
            return petList.stream().sorted(Comparator.comparingDouble(Pet::getClassificationId)).collect(Collectors.toList());
        }
    };

}
