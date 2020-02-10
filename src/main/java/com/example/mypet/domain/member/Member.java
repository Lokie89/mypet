package com.example.mypet.domain.member;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Member {
    @Id
    private long id;
    private String name;
    private String phone;
    private String email;
    private String addInfo;
}
