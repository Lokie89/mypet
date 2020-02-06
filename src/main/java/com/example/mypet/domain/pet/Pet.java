package com.example.mypet.abandoned.domain.pet;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Pet {

    @Id
    private int id;

    private int sortId;
}
