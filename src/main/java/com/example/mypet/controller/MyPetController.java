package com.example.mypet.controller;

import com.example.mypet.domain.board.Board;
import com.example.mypet.domain.pet.Pet;
import com.example.mypet.service.ArrangeList;
import com.example.mypet.service.BoardService;
import com.example.mypet.service.PetService;
import com.example.mypet.service.filter.FilterTypeBoard;
import com.example.mypet.service.filter.FilterTypePet;
import com.example.mypet.service.sort.Ordering;
import com.example.mypet.service.sort.SortTypeBoard;
import com.example.mypet.service.sort.SortTypePet;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyPetController {
    private final PetService petService;
    private final BoardService boardService;

    public MyPetController(PetService petService,
                           BoardService boardService) {
        this.petService = petService;
        this.boardService = boardService;
    }

    private ResponseEntity responseBadRequest(){
        return responseEntity(null,HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity responseOK(Object object){
        return responseEntity(object,HttpStatus.OK);
    }

    private ResponseEntity responseEntity(Object object, HttpStatus httpStatus) {
        return new ResponseEntity(object, httpStatus);
    }

    @GetMapping("/pet/sort")
    public ResponseEntity<ArrangeList<Pet>> sortPet(
            @RequestParam(defaultValue = "ID", value = "sortType") SortTypePet sortType,
            @RequestParam(defaultValue = "DESC", value = "ordering") Ordering ordering) {
        return responseOK(petService.getList(sortType, ordering));
    }

    @GetMapping("/pet/filter")
    public ResponseEntity<ArrangeList<Pet>> filterPet(
            @RequestParam(required = false, value = "filterType") FilterTypePet filterType,
            @RequestParam(required = false, value = "param") String param) {
        return responseOK(petService.getList(filterType, param));
    }

    @GetMapping("/board/sort")
    public ResponseEntity<ArrangeList<Board>> sortBoard(
            @RequestParam(defaultValue = "ID", value = "sortType") SortTypeBoard sortType,
            @RequestParam(defaultValue = "DESC", value = "ordering") Ordering ordering) {
        return responseOK(boardService.getList(sortType, ordering));
    }

    @GetMapping("/board/filter")
    public ResponseEntity<ArrangeList<Board>> filterBoard(
            @RequestParam(required = false, value = "filterType") FilterTypeBoard filterType,
            @RequestParam(required = false, value = "param") String param) {
        return responseOK(boardService.getList(filterType, param));
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity handleError() {
        return responseBadRequest();
    }

    @GetMapping("/pet/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable long id) {
        return responseOK(petService.getPet(id));
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<Board> getBoard(@PathVariable long id) {
        return responseOK(boardService.getBoard(id));
    }
}
