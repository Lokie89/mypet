package com.example.mypet.controller;

import com.example.mypet.domain.board.Board;
import com.example.mypet.domain.pet.Pet;
import com.example.mypet.service.ArrangeList;
import com.example.mypet.service.BoardService;
import com.example.mypet.service.PetService;
import com.example.mypet.service.filter.FilterType;
import com.example.mypet.service.sort.Ordering;
import com.example.mypet.service.sort.SortTypePet;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPetController {
    private final PetService petService;
    private final BoardService boardService;

    public MyPetController(PetService petService,
                           BoardService boardService) {
        this.petService = petService;
        this.boardService = boardService;
    }

    @GetMapping("/sort/pet")
    public ResponseEntity<ArrangeList<Pet>> sortPet(
            @RequestParam(value = "sortType") SortTypePet sortType,
            @RequestParam(defaultValue = "DESC", value = "ordering") Ordering ordering) {
        return new ResponseEntity<>(petService.getList(sortType, ordering), HttpStatus.OK);
    }

    @GetMapping("/filter/pet")
    public ArrangeList<Pet> filterPet(
            @RequestParam(value = "filterType") FilterType filterType,
            @RequestParam(value = "param") String param) {
        return petService.getList(filterType, param);
    }

    @GetMapping("/sort/board")
    public ArrangeList<Board> sortBoard(
            @RequestParam(value = "sortType") SortTypePet sortType,
            @RequestParam(defaultValue = "DESC", value = "ordering") Ordering ordering) {
        return boardService.getList(sortType, ordering);
    }

    @GetMapping("/filter/board")
    public ArrangeList<Board> filterBoard(
            @RequestParam(value = "filterType") FilterType filterType,
            @RequestParam(value = "param") String param) {
        return boardService.getList(filterType, param);
    }

    @ExceptionHandler(ConversionFailedException.class)
    public String handleError() {
        return "Error";
    }
}
