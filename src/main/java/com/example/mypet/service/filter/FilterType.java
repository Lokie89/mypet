package com.example.mypet.service.filter;

import java.util.function.Predicate;

public interface FilterType<T> {
    public Predicate<T> getPredicate(String param);
}
