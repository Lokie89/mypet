package com.example.mypet.service.sort;

import com.example.mypet.domain.pet.Pet;

import java.util.Comparator;

public enum SortTypePet implements SortType<Pet> {

    ID {
        @Override
        public Comparator<Pet> getComparator() {
            return Comparator.comparingDouble(Pet::getId);
        }
    },

    SITUATION {
        @Override
        public Comparator<Pet> getComparator() {
            return Comparator.comparingDouble(Pet::getSituationId);
        }
    },

    NAME {
        @Override
        public Comparator<Pet> getComparator() {
            return Comparator.comparing(Pet::getName);
        }
    },

    AGE {
        @Override
        public Comparator<Pet> getComparator() {
            return Comparator.comparingInt(Pet::getAge);
        }
    },

    GENDER {
        @Override
        public Comparator<Pet> getComparator() {
            return Comparator.comparingDouble(Pet::getGender);
        }
    },

    NEUTERED {
        @Override
        public Comparator<Pet> getComparator() {
            return Comparator.comparing(Pet::isNeutered);
        }
    },

    OPEN_DATE {
        @Override
        public Comparator<Pet> getComparator() {
            return Comparator.comparing(Pet::getOpenDate);
        }
    },

    CLOSE_DATE {
        @Override
        public Comparator<Pet> getComparator() {
            return Comparator.comparing(Pet::getCloseDate);
        }
    },

    CLASSIFICATION {
        @Override
        public Comparator<Pet> getComparator() {
            return Comparator.comparingDouble(Pet::getClassificationId);
        }
    },
    ;

}
