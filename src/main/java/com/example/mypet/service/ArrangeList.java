package com.example.mypet.service;

import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
public class ArrangeList<T> {

    private List<T> arrangedList;

    public ArrangeList(List<T> list) {
        this.arrangedList = list;
    }

    public ArrangeList(List<T> list, Comparator<T> comparator) {
        this.arrangedList = sort(list, comparator);
    }

    public ArrangeList(List<T> list, Predicate<T> predicate) {
        this.arrangedList = filter(list, predicate);
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


