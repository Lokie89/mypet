package com.example.mypet.service.sort;

import java.util.Comparator;

public interface SortType<T> {
    public Comparator<T> getComparator();
}
