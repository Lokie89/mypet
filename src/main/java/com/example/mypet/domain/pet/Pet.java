package com.example.mypet.domain.pet;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Pet {

    @Id
    private long id;
    private long situationId;
    private String name;
    private int age;
    private boolean isExpectAge;
    private char gender;
    private boolean isNeutered;
    private String openDate;
    private String closeDate;
    private long reporter;
    private long supporter;
    private long classificationId;

    public int compareTo(Pet pet, PetSortCondition condition) {
        return 0;
    }

}

enum PetSortCondition {
    SITUATION, NAME, AGE, GENDER, ISNEUTERED, OPENDATE, CLOSEDATE, CLASSIFICATIONID;

    public PetSortCondition getSortCondition(String sortCondition) {
        return PetSortCondition.valueOf(sortCondition);
    }
}