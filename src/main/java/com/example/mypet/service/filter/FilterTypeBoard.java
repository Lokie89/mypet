package com.example.mypet.service.filter;

import com.example.mypet.domain.board.Board;

import java.util.function.Predicate;

public enum FilterTypeBoard implements FilterType<Board> {

    BOARD_KIND {
        @Override
        public Predicate<Board> getPredicate(String boardKindId) {
            return board -> board.getBoardKindId() == Long.parseLong(boardKindId);
        }
    },

    MEMBER {
        @Override
        public Predicate<Board> getPredicate(String memberId) {
            return board -> board.getMemberId() ==  Long.parseLong(memberId);
        }
    },

    TITLE {
        @Override
        public Predicate<Board> getPredicate(String title) {
            return board -> board.getTitle().toLowerCase().contains(title.toLowerCase());
        }
    },

    DESCRIPTION {
        @Override
        public Predicate<Board> getPredicate(String description) {
            return board -> board.getDescription().toLowerCase().contains(description.toLowerCase());
        }
    },
    ;

}
