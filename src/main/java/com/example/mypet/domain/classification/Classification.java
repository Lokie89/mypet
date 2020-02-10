package com.example.mypet.domain.classification;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Classification {
    @Id
    private long id;
    private String name;
}
