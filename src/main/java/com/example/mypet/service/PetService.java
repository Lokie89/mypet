package com.example.mypet.service;

import com.example.mypet.domain.pet.Pet;
import com.example.mypet.domain.pet.PetRepository;
import com.example.mypet.service.filter.FilterType;
import com.example.mypet.service.sort.Ordering;
import com.example.mypet.service.sort.SortType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PetService {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public ArrangeList<Pet> getList(SortType<Pet> sortType, Ordering ordering) {
        return new ArrangeList<Pet>(petRepository.findAll(), ordering.order(sortType.getComparator()));
    }

    public ArrangeList<Pet> getList(FilterType<Pet> filterType, String param) {
        try {
            return new ArrangeList<>(petRepository.findAll(), filterType.getPredicate(param));
        } catch (NullPointerException e) {
            return new ArrangeList<>(petRepository.findAll());
        }
    }

    public Pet getPet(long id) {
        return petRepository.getOne(id);
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }
}

