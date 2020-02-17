package com.example.mypet.service.sort;

import com.example.mypet.domain.board.Board;

import java.util.Comparator;

public enum BoardComparator implements MyPetComparator<Board> {

    BOARD_KIND {
        @Override
        public Comparator<Board> getComparator() {
            return Comparator.comparingDouble(Board::getBoardKindId);
        }

    }, MEMBER {
        @Override
        public Comparator<Board> getComparator() {
            return Comparator.comparingDouble(Board::getMemberId);
        }
    };


}
