package com.example.mypet.service.filter;

import com.example.mypet.domain.board.Board;

import java.util.function.Predicate;

public enum BoardPredicate implements MyPetPredicate<Board> {

    BOARD_KIND {
        @Override
        public Predicate<Board> getPredicate(long boardKindId) {
            return board -> board.getBoardKindId() == boardKindId;
        }

        @Override
        public Predicate<Board> getPredicate(String str) {
            return null;
        }
    }, MEMBER {
        @Override
        public Predicate<Board> getPredicate(long memberId) {
            return board -> board.getMemberId() == memberId;
        }

        @Override
        public Predicate<Board> getPredicate(String str) {
            return null;
        }
    }, TITLE {
        @Override
        public Predicate<Board> getPredicate(long id) {
            return null;
        }

        @Override
        public Predicate<Board> getPredicate(String title) {
            return board -> board.getTitle().contains(title);
        }
    }, DESCRIPTION {
        @Override
        public Predicate<Board> getPredicate(long id) {
            return null;
        }

        @Override
        public Predicate<Board> getPredicate(String description) {
            return board -> board.getDescription().contains(description);
        }
    };

}
