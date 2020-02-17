package com.example.mypet.service.sort;

import java.util.Comparator;

public interface MyPetComparator<T> {
    public Comparator<T> getComparator();

}
