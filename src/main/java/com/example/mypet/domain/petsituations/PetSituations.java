package com.example.mypet.domain.petsituations;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class PetSituations {
    @Id
    private long id;
    private String situation;
}
