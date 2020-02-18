package com.example.mypet.service.filter;

import java.util.function.Predicate;

public interface MyPetPredicate<T> {
    public Predicate<T> getPredicate(long id);
    public Predicate<T> getPredicate(String str);

}
