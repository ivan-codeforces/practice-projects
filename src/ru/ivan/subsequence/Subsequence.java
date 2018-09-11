package ru.ivan.subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Subsequence {
    public static void main(String[] args) {
        List<String> subFirst = new ArrayList<String>();
        subFirst.add("a");
        subFirst.add("b");
        subFirst.add("k");
        List<String> subSecond = new ArrayList<String>();
        subSecond.add("c");
        subSecond.add("b");
        subSecond.add("a");
        subSecond.add("f");


        System.out.println(compare(subFirst, subSecond));
    }

    static boolean compare(List<String> subFirst, List<String> subSecond) {

        for (String b : subFirst) {
            if (!subSecond.contains(b)) {
                return false;
            }
        }
        return true;
    }
}

