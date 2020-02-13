package com.example.mypet.service;

import com.example.mypet.domain.board.Board;
import com.example.mypet.domain.pet.Pet;

import java.util.List;
import java.util.stream.Collectors;

public enum PetSortCondition implements Sort<Pet>{

    SITUATION {
        public List<Pet> sort(List<Pet> petList) {
            return petList.stream().sorted().collect(Collectors.toList());
        }
    }, NAME {
        public List<Pet> sort(List<Pet> petList) {
            return petList.stream().sorted().collect(Collectors.toList());
        }
    }, AGE {
        public List<Pet> sort(List<Pet> petList) {
            return petList.stream().sorted().collect(Collectors.toList());
        }
    }, GENDER {
        public List<Pet> sort(List<Pet> petList) {
            return petList.stream().sorted().collect(Collectors.toList());
        }
    }, NEUTERED {
        public List<Pet> sort(List<Pet> petList) {
            return petList.stream().sorted().collect(Collectors.toList());
        }
    }, OPEN_DATE {
        public List<Pet> sort(List<Pet> petList) {
            return petList.stream().sorted().collect(Collectors.toList());
        }
    }, CLOSE_DATE {
        public List<Pet> sort(List<Pet> petList) {
            return petList.stream().sorted().collect(Collectors.toList());
        }
    }, CLASSIFICATION {
        public List<Pet> sort(List<Pet> petList) {
            return petList.stream().sorted().collect(Collectors.toList());
        }
    };

}
