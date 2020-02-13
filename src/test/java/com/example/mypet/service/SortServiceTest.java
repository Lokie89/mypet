package com.example.mypet.service;

import com.example.mypet.domain.board.Board;
import com.example.mypet.domain.pet.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SortServiceTest {

    @Autowired
    SortService sortService;

    @Test
    public void sortPetTest(){
        List<Pet> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();
        petList.add(pet1);
        petList.add(pet2);
        sortService.sortPet(petList,"SITUATION");
    }

    @Test
    public void sortBoardTest(){
        List<Board> boardList = new ArrayList<>();
        Board board1 = new Board();
        Board board2 = new Board();
        boardList.add(board1);
        boardList.add(board2);
        sortService.sortBoard(boardList,"MEMBER");
    }
}