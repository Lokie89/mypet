package com.example.mypet.service.filter;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter<T> {
    public List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
