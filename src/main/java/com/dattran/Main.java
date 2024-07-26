package com.dattran;

import com.dattran.list.ArrayListDS;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayListDS<Integer> arrayListDS = new ArrayListDS<>();
        arrayListDS.add(12);
        arrayListDS.add(13);
        ArrayListDS<Integer> arrayListDS2 = new ArrayListDS<>();
        arrayListDS2.add(15);
        arrayListDS2.add(16);
        arrayListDS.addAll(arrayListDS2);
        System.out.println(arrayListDS);
        System.out.println(arrayListDS.size());
        arrayListDS.remove(1);
        System.out.println(arrayListDS);
        System.out.println(arrayListDS.size());
        arrayListDS.add(20);
        System.out.println(arrayListDS);
        System.out.println(arrayListDS.size());
        arrayListDS.remove(Integer.valueOf(16));
        System.out.println(arrayListDS);
    }
}