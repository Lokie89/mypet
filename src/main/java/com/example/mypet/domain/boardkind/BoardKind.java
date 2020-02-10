package com.example.mypet.domain.boardkind;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class BoardKind {
    @Id
    private long id;
    private String name;
}
