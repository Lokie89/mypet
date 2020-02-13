package com.example.mypet.service;

import com.example.mypet.domain.board.Board;

import java.util.List;
import java.util.stream.Collectors;

public enum BoardSortCondition implements Sort<Board> {

    BOARD_KIND {
        public List<Board> sort(List<Board> boardList) {
            return boardList.stream().sorted().collect(Collectors.toList());
        }
    }, MEMBER {
        public List<Board> sort(List<Board> boardList) {
            return boardList.stream().sorted().collect(Collectors.toList());
        }
    };
}
