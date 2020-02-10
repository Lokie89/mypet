package com.example.mypet.service;

import com.example.mypet.domain.board.BoardRepository;
import com.example.mypet.domain.boardkind.BoardKindRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardKindRepository boardKindRepository;

    public BoardService(BoardRepository boardRepository, BoardKindRepository boardKindRepository) {
        this.boardRepository = boardRepository;
        this.boardKindRepository = boardKindRepository;

    }
}
