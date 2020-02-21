package com.example.mypet.service.sort;

import java.util.Comparator;

public enum Ordering {

    ASC {
        public Comparator order(Comparator comparator) {
            return comparator;
        }
    },

    DESC {
        public Comparator order(Comparator comparator) {
            return comparator.reversed();
        }
    },
    ;

    public abstract Comparator order(Comparator comparator);

}
