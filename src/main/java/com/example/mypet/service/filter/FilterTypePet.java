package com.example.mypet.service.filter;

import com.example.mypet.domain.pet.Pet;

import java.util.function.Predicate;

public enum FilterTypePet implements FilterType<Pet> {

    SITUATION {
        @Override
        public Predicate<Pet> getPredicate(String param) {
            return pet -> pet.getSituationId() == Long.parseLong(param);
        }
    },

    NAME {
        @Override
        public Predicate<Pet> getPredicate(String param) {
            return pet -> pet.getName().contains(param);
        }
    },

    AGE {
        @Override
        public Predicate<Pet> getPredicate(String param) {
            return pet -> pet.getAge() == Long.parseLong(param);
        }
    },

    GENDER {
        @Override
        public Predicate<Pet> getPredicate(String param) {
            return pet -> pet.getGender() == Long.parseLong(param);
        }
    },

    /*NEUTERED {
        @Override
        public Predicate<Pet> getPredicate(long param) {
            return null;
        }

        @Override
        public Predicate<Pet> getPredicate(String param) {
            return pet->pet.isNeutered();
        }
    },*/

    OPEN_DATE {
        @Override
        public Predicate<Pet> getPredicate(String param) {
            return pet -> pet.getOpenDate().contains(param);
        }
    },

    CLOSE_DATE {
        @Override
        public Predicate<Pet> getPredicate(String param) {
            return pet -> pet.getCloseDate().contains(param);
        }
    },

    CLASSIFICATION {
        @Override
        public Predicate<Pet> getPredicate(String param) {
            return pet -> pet.getClassificationId() == Long.parseLong(param);
        }
    },
    ;

}
