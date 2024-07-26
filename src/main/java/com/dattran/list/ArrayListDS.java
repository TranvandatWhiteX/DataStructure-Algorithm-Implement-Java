package com.dattran.list;

import java.util.Arrays;
import java.util.Objects;

public class ArrayListDS<E> implements ListDS<E> {
    private final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENTS = {};

    private int size;

    private Object[] elements;

    public ArrayListDS(int initialCapacity) {
        if (initialCapacity > 0) {
            elements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            elements = DEFAULT_CAPACITY_EMPTY_ELEMENTS;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public ArrayListDS() {
        elements = DEFAULT_CAPACITY_EMPTY_ELEMENTS;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > 0) {
            return Arrays.copyOf(elements, minCapacity + oldCapacity);
        } else {
            return new Object[Math.max(oldCapacity, minCapacity)];
        }
    }

    private Object[] grow() {
        return grow(size+1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean add(E e) {
        if (size == 0 || size < elements.length + 1) {
            elements = grow();
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public String toString() {
        return "ArrayList: " + Arrays.toString(elements).replace(", null", "");
    }

    @Override
    public void remove(E e) {
        int index = contains(e);
        if (index > -1) {
            remove(index);
        }
    }

    @Override
    public void addAll(ListDS<? extends E> list) {
        int listLength = list.size();
        elements = grow(listLength);
        for (int i = 0; i < listLength; i++) {
            elements[size++] = list.get(i);
        }
    }

    @Override
    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            elements = Arrays.copyOfRange(elements, 1, size);
            size--;
            return;
        }
        if (index == size - 1) {
            elements = Arrays.copyOfRange(elements, 0, --size);
            return;
        }
        Object[] temp = new Object[size - 1];
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == index) {
                j--;
                continue;
            }
            temp[j] = elements[i];
        }
        elements = temp;
        size--;
    }

    @Override
    public void clear() {
        elements = DEFAULT_CAPACITY_EMPTY_ELEMENTS;
        size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elements[index];
    }
}
