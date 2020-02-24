package com.example.mypet.controller;

import com.example.mypet.domain.board.Board;
import com.example.mypet.service.ArrangeList;
import com.example.mypet.service.BoardService;
import com.example.mypet.service.filter.FilterTypeBoard;
import com.example.mypet.service.sort.Ordering;
import com.example.mypet.service.sort.SortTypeBoard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/sort")
    public ResponseEntity<ArrangeList<Board>> sortBoard(
            @RequestParam(defaultValue = "ID", value = "sortType") SortTypeBoard sortType,
            @RequestParam(defaultValue = "DESC", value = "ordering") Ordering ordering) {
        return new CustomResponse<>(boardService.getList(sortType, ordering)).responseOK();
    }

    @GetMapping("/filter")
    public ResponseEntity<ArrangeList<Board>> filterBoard(
            @RequestParam(required = false, value = "filterType") FilterTypeBoard filterType,
            @RequestParam(required = false, value = "param") String param) {
        return new CustomResponse<>(boardService.getList(filterType, param)).responseOK();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoard(@PathVariable long id) {
        return new CustomResponse<>(boardService.getBoard(id)).responseOK();
    }

    @PostMapping("")
    public ResponseEntity<Board> postBoard(@ModelAttribute Board board) {
        return new CustomResponse<>(boardService.saveBoard(board)).responseOK();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> putBoard(@ModelAttribute Board board) {
        return new CustomResponse<>(boardService.saveBoard(board)).responseOK();
    }
}
