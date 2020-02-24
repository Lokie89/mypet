package com.example.mypet.service;

import com.example.mypet.domain.board.Board;
import com.example.mypet.domain.pet.Pet;
import com.example.mypet.service.filter.FilterType;
import com.example.mypet.service.filter.FilterTypeBoard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Test
    void getList() {
        FilterType<Board> filterType =FilterTypeBoard.valueOf("AGE");
        ArrangeList<Board> boardArrangeList = boardService.getList(filterType,"30");
        assertEquals(boardArrangeList.getArrangedList().get(0),1);
    }

    @Test
    void getList2() {
    }

    @Test
    void getBoard() {
    }
}