package com.example.mypet.service.sort;

import com.example.mypet.domain.board.Board;
import com.example.mypet.domain.pet.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SortServiceTest {

    @Autowired
    SortService sortService;

    @Test
    public void sortPetTest() {
        List<Pet> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setAge(50);
        Pet pet2 = new Pet();
        pet2.setAge(30);
        petList.add(pet1);
        petList.add(pet2);
        List<Pet> sortPet = sortService.sortPet(petList, "AGE", false);
        assertEquals(30, sortPet.get(0).getAge());
    }

    @Test
    public void sortBoardTest() {
        List<Board> boardList = new ArrayList<>();
        Board board1 = new Board();
        board1.setMemberId(5);
        Board board2 = new Board();
        board2.setMemberId(99);
        boardList.add(board1);
        boardList.add(board2);
        List<Board> sortBoard = sortService.sortBoard(boardList, "MEMBER", true);
        assertEquals(99, sortBoard.get(0).getMemberId());
    }

}