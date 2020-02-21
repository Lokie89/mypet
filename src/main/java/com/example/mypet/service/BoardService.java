package com.example.mypet.service;

import com.example.mypet.domain.board.Board;
import com.example.mypet.domain.board.BoardRepository;
import com.example.mypet.service.filter.FilterType;
import com.example.mypet.service.sort.Ordering;
import com.example.mypet.service.sort.SortType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public ArrangeList<Board> getPetList(SortType sortType, Ordering ordering) {
        return new ArrangeList<Board>(boardRepository.findAll(), ordering.order(sortType.getComparator()));
    }

    public ArrangeList<Board> getPetList(FilterType filterType, String param) {
        return new ArrangeList<Board>(boardRepository.findAll(), filterType.getPredicate(param));
    }
}
