package com.example.mypet.controller;

import com.example.mypet.domain.pet.Pet;
import com.example.mypet.service.ArrangeList;
import com.example.mypet.service.PetService;
import com.example.mypet.service.filter.FilterTypePet;
import com.example.mypet.service.sort.Ordering;
import com.example.mypet.service.sort.SortTypePet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/sort")
    public ResponseEntity<ArrangeList<Pet>> sortPet(
            @RequestParam(defaultValue = "ID", value = "sortType") SortTypePet sortType,
            @RequestParam(defaultValue = "DESC", value = "ordering") Ordering ordering) {
        return new CustomResponse<>(petService.getList(sortType, ordering)).responseOK();
    }

    @GetMapping("/filter")
    public ResponseEntity<ArrangeList<Pet>> filterPet(
            @RequestParam(required = false, value = "filterType") FilterTypePet filterType,
            @RequestParam(required = false, value = "param") String param) {
        return new CustomResponse<>(petService.getList(filterType, param)).responseOK();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable long id) {
        return new CustomResponse<>(petService.getPet(id)).responseOK();
    }

}
