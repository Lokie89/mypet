package com.example.mypet.domain.board;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Board {
    @Id
    private long id;
    private long boardKindId;
    private long memberId;
    private String title;
    private String description;
    private String files;
}
