package com.dattran.list;

import com.dattran.util.CollectionDS;

public interface ListDS<E> extends CollectionDS<E> {
    E get(int index);
    void addAll(ListDS<? extends E> list);
    void remove(int index);
    int contains(Object o);
}
