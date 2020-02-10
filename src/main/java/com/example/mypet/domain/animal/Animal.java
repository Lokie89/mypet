package com.example.mypet.domain.animal;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Animal {
    @Id
    private long id;
    private String name;
}
