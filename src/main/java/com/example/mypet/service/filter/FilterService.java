package com.example.mypet.service.filter;

import com.example.mypet.service.sort.MyPetComparator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class FilterService<T> {

    private List<T> filterGenerate(List<T> list, Predicate predicate) {
        Filter filter = new Filter();
        return filter.filter(list, predicate);
    }

    private List<T> filter(List<T> list, MyPetPredicate myPetPredicate, long id) {
        Predicate predicate = myPetPredicate.getPredicate(id);
        return filterGenerate(list, predicate);
    }

    private List<T> filter(List<T> list, MyPetPredicate myPetPredicate, String keyword) {
        Predicate predicate = myPetPredicate.getPredicate(keyword);
        return filterGenerate(list, predicate);
    }


    // https://wedul.site/289
    // https://homo-ware.tistory.com/69
    // TODO : 네개 합치기
    public List<T> filterPet(List<T> list, String condition, String keyword) {
        MyPetPredicate myPetPredicate = PetPredicate.valueOf(condition);
        return filter(list, myPetPredicate, keyword);
    }

    public List<T> filterPet(List<T> list, String condition, long id) {
        MyPetPredicate myPetPredicate = PetPredicate.valueOf(condition);
        return filter(list, myPetPredicate, id);
    }

    public List<T> filterBoard(List<T> list, String condition, long id) {
        MyPetPredicate myPetPredicate = PetPredicate.valueOf(condition);
        return filter(list, myPetPredicate, id);
    }

    public List<T> filterBoard(List<T> list, String condition, String keyword) {
        MyPetPredicate myPetPredicate = PetPredicate.valueOf(condition);
        return filter(list, myPetPredicate, keyword);
    }


//    public List<T> sortTest(List<T> list, String condition, boolean descending){
//        MyPetComparator myPetComparator = getComparator(MyPetComparator,condition);
//        return null;
//    }

    public <T extends Enum<T> & MyPetComparator> T getComparator(T[] values, String condition) {
        for (T t : values) {
            if (t.getComparator().equals(condition)) {
                return t;
            }
        }
        try {
            throw new IllegalAccessException("Boring:" + condition);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}



