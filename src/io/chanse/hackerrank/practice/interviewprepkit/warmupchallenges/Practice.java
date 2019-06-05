package io.chanse.hackerrank.practice.interviewprepkit.warmupchallenges;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    static String findNumber(List<Integer> arr, int k) {
        for (Integer integer : arr) {
            if (integer == k) return "YES";
        }
        return "NO";
    }

    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> output = new ArrayList<>();
        for (; l <= r; l++) {
            if (l % 2 != 0) output.add(l);
        }
        return output;
    }
}
