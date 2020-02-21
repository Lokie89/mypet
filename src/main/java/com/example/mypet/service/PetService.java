package com.example.mypet.service;

import com.example.mypet.domain.pet.Pet;
import com.example.mypet.domain.pet.PetRepository;
import com.example.mypet.service.filter.FilterType;
import com.example.mypet.service.sort.Ordering;
import com.example.mypet.service.sort.SortType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PetService {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public ArrangeList<Pet> getPetList(SortType sortType, Ordering ordering) {
        List<Pet> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setAge(50);
        Pet pet2 = new Pet();
        pet2.setAge(30);
        petList.add(pet1);
        petList.add(pet2);
        return new ArrangeList<Pet>(petList, ordering.order(sortType.getComparator()));
//        return new ArrangeList<Pet>(petRepository.findAll(), ordering.order(sortType.getComparator()));
    }

    public ArrangeList<Pet> getPetList(FilterType filterType, String param) {
        return new ArrangeList<Pet>(petRepository.findAll(), filterType.getPredicate(param));
    }

}


