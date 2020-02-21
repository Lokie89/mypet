package com.example.mypet.service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ArrangeList<T> {

    private List<T> list;

    public ArrangeList(List<T> list, Comparator<T> comparator) {
        this.list = sort(list, comparator);
    }

    public ArrangeList(List<T> list, Predicate<T> predicate) {
        this.list = filter(list, predicate);
    }

    private List<T> sort(List<T> list, Comparator<T> comparator) {
        return list
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList())
                ;
    }

    private List<T> filter(List<T> list, Predicate<T> predicate) {
        return list
                .stream()
                .filter(predicate)
                .collect(Collectors.toList())
                ;
    }
}