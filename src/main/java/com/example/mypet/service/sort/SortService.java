package com.example.mypet.service.sort;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SortService<T> {

    private List<T> sortGenerate(List<T> list, Comparator comparator) {
        Sorter sorter = new Sorter();
        return sorter.sort(list, comparator);
    }

    private Comparator order(Comparator comparator, boolean descending) {
        if (descending) {
            return comparator.reversed();
        }
        return comparator;
    }

    private List<T> sort(List<T> list, MyPetComparator myPetComparator, boolean descending) {
        Comparator comparator = myPetComparator.getComparator();
        return sortGenerate(list, order(comparator, descending));
    }


    // https://wedul.site/289
    // https://homo-ware.tistory.com/69
    // TODO : 두개 합치기
    public List<T> sortPet(List<T> list, String condition, boolean descending) {
        MyPetComparator myPetComparator = PetComparator.valueOf(condition);
        return sort(list, myPetComparator, descending);
    }

    public List<T> sortBoard(List<T> list, String condition, boolean descending) {
        MyPetComparator myPetComparator = BoardComparator.valueOf(condition);
        return sort(list, myPetComparator, descending);
    }

    public List<T> sortTest(List<T> list, String condition, boolean descending){
//        MyPetComparator myPetComparator = getComparator(MyPetComparator,condition);
        return null;
    }

    public <E extends Enum<E> & MyPetComparator> E getComparator(E[] values, String condition) {
        for(E e : values){
            if(e.getComparator().equals(condition)){
                return e;
            }
        }
        try {
            throw new IllegalAccessException("Boring:"+condition);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}



