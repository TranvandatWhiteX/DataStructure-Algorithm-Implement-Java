package com.dattran.util;

public interface CollectionDS<E> {
    int size();
    boolean isEmpty();
    boolean add(E e);
    void remove(E e);
    void clear();
}
