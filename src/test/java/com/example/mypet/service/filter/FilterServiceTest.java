package com.example.mypet.service.filter;

import com.example.mypet.domain.board.Board;
import com.example.mypet.domain.pet.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FilterServiceTest {

    @Autowired
    FilterService filterService;

    @Test
    public void testFilterPet1() {
        List<Pet> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setAge(50);
        Pet pet2 = new Pet();
        pet2.setAge(30);
        Pet pet3 = new Pet();
        pet3.setAge(30);
        petList.add(pet1);
        petList.add(pet2);
        petList.add(pet3);
        List<Pet> filterPet = filterService.filterPet(petList, "AGE", 30);
        assertEquals(2, filterPet.size());
    }

    @Test
    public void testFilterPet2() {
        List<Pet> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setOpenDate("2018-06-17");
        Pet pet2 = new Pet();
        pet2.setOpenDate("2018-06-17");
        Pet pet3 = new Pet();
        pet3.setOpenDate("2019-06-18");
        petList.add(pet1);
        petList.add(pet2);
        petList.add(pet3);
        List<Pet> filterPet = filterService.filterPet(petList, "OPEN_DATE", "-06-");
        assertEquals(3, filterPet.size());
    }

    @Test
    public void testFilterBoard1() {
        List<Board> boardList = new ArrayList<>();
        Board board1 = new Board();
        board1.setMemberId(3);
        Board board2 = new Board();
        board2.setMemberId(3);
        Board board3 = new Board();
        board3.setMemberId(31);
        boardList.add(board1);
        boardList.add(board2);
        boardList.add(board3);
        List<Board> filterBoard = filterService.filterBoard(boardList, "MEMBER", 3);
        assertEquals(2, filterBoard.size());
    }

    @Test
    public void testFilterBoard2() {
        List<Board> boardList = new ArrayList<>();
        Board board1 = new Board();
        board1.setTitle("ab");
        Board board2 = new Board();
        board2.setTitle("abcdefg");
        Board board3 = new Board();
        board3.setTitle("afg");
        boardList.add(board1);
        boardList.add(board2);
        boardList.add(board3);
        List<Board> filterBoard = filterService.filterBoard(boardList, "TITLE", "ABCD");
        assertEquals(1, filterBoard.size());
    }
}