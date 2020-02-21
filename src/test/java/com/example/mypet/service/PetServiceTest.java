package com.example.mypet.service;

import com.example.mypet.domain.pet.Pet;
import com.example.mypet.service.filter.FilterType;
import com.example.mypet.service.sort.Ordering;
import com.example.mypet.service.sort.SortType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PetServiceTest {

    @Test
    public void getPetListTest(SortType sortType, Ordering ordering) {
        List<Pet> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setAge(50);
        Pet pet2 = new Pet();
        pet2.setAge(30);
        petList.add(pet1);
        petList.add(pet2);
        ArrangeList<Pet> arrangeList = new ArrangeList<Pet>(petList, ordering.order(sortType.getComparator()));
    }

    @Test
    public void getPetListTest(FilterType filterType, String param) {
        List<Pet> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setAge(50);
        Pet pet2 = new Pet();
        pet2.setAge(30);
        petList.add(pet1);
        petList.add(pet2);
        ArrangeList<Pet> arrangeList = new ArrangeList<Pet>(petList, filterType.getPredicate(param));
    }
}