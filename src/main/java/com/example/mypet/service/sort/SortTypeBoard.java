package com.example.mypet.service.sort;

import com.example.mypet.domain.board.Board;

import java.util.Comparator;

public enum SortTypeBoard implements SortType<Board> {

    ID {
        @Override
        public Comparator<Board> getComparator() {
            return Comparator.comparingDouble(Board::getId);
        }
    },

    BOARD_KIND {
        @Override
        public Comparator<Board> getComparator() {
            return Comparator.comparingDouble(Board::getBoardKindId);
        }
    },

    MEMBER {
        @Override
        public Comparator<Board> getComparator() {
            return Comparator.comparingDouble(Board::getMemberId);
        }
    },
    ;


}
