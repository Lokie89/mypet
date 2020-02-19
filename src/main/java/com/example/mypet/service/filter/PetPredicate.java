package com.example.mypet.service.filter;

import com.example.mypet.domain.pet.Pet;

import java.util.function.Predicate;

public enum PetPredicate implements MyPetPredicate<Pet> {

    SITUATION {
        @Override
        public Predicate<Pet> getPredicate(long situationId) {
            return pet -> pet.getSituationId() == situationId;
        }

        @Override
        public Predicate<Pet> getPredicate(String str) {
            return null;
        }
    }, NAME {
        @Override
        public Predicate<Pet> getPredicate(long id) {
            return null;
        }

        @Override
        public Predicate<Pet> getPredicate(String name) {
            return pet -> pet.getName().contains(name);
        }
    }, AGE {
        @Override
        public Predicate<Pet> getPredicate(long age) {
            return pet -> pet.getAge() == age;
        }

        @Override
        public Predicate<Pet> getPredicate(String str) {
            return null;
        }
    }, GENDER {
        @Override
        public Predicate<Pet> getPredicate(long id) {
            return pet -> pet.getGender() == id;
        }

        @Override
        public Predicate<Pet> getPredicate(String str) {
            return null;
        }
    }, /*NEUTERED {
        @Override
        public Predicate<Pet> getPredicate(long id) {
            return null;
        }

        @Override
        public Predicate<Pet> getPredicate(String str) {
            return pet->pet.isNeutered();
        }
    },*/ OPEN_DATE {
        @Override
        public Predicate<Pet> getPredicate(long id) {
            return null;
        }

        @Override
        public Predicate<Pet> getPredicate(String openDate) {
            return pet -> pet.getOpenDate().contains(openDate);
        }
    }, CLOSE_DATE {
        @Override
        public Predicate<Pet> getPredicate(long id) {
            return null;
        }

        @Override
        public Predicate<Pet> getPredicate(String closeDate) {
            return pet -> pet.getCloseDate().contains(closeDate);
        }
    }, CLASSIFICATION {
        @Override
        public Predicate<Pet> getPredicate(long classificationId) {
            return pet -> pet.getClassificationId() == classificationId;
        }

        @Override
        public Predicate<Pet> getPredicate(String str) {
            return null;
        }
    };

}
