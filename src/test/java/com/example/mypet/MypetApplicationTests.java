package com.example.mypet;

import com.example.mypet.abandoned.domain.pet.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MypetApplicationTests {


    @Autowired
    private PetRepository petRepository;

    @Test
    void contextLoads() {
        System.out.println(petRepository.findAllById(1));
    }

}
