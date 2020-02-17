package com.example.mypet.service.sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter<T>{
    public List<T> sort(List<T> list, Comparator<T> comparator){
        return list.stream().sorted(comparator).collect(Collectors.toList());
    }
}
