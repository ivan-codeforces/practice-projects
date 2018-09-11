package ru.ivan.subsequence;


import java.util.List;

class SubCompare {

    static boolean compare(List<String> subFirst, List<String> subSecond) {

        for (String b : subFirst) {
            if (!subSecond.contains(b)) {
                return false;
            }
        }
        return true;
    }
}
