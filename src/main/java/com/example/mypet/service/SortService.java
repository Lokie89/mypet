package com.example.mypet.service;

import com.example.mypet.domain.board.Board;
import com.example.mypet.domain.pet.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {

    public List<Pet> sortPet(List<Pet> petList, String condition, boolean ascending) {
        PetSortCondition petSortCondition = PetSortCondition.valueOf(condition);
        return petSortCondition.sort(petList, ascending);
    }

    public List<Board> sortBoard(List<Board> boardList, String condition, boolean ascending) {
        BoardSortCondition boardSortCondition = BoardSortCondition.valueOf(condition);
        return boardSortCondition.sort(boardList, ascending);
    }

}



