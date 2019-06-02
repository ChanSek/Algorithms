package io.chanse.circleslife;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class LastStone {

    public static int lastStoneWeight(List<Integer> a) {
        Collections.sort(a);
        int size = a.size();
        for (int i = size - 1, j = size - 2; i >= 1 && j >= 0; i--, j--) {
            a.set(j, Math.abs(a.get(i) - a.get(j)));
        }
        return a.get(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(14783463);
        list.add(2134235345);
        list.add(324233);
        list.add(132423438);
        list.add(56565767);
        list.add(743243546);
        list.add(743213546);
        list.add(732343546);
        list.add(743223546);
        list.add(743243546);
        list.add(743204356);
        list.add(7432435);
        list.add(743243546);
        list.add(743243546);
        list.add(743243546);
        list.add(743243546);
        list.add(74343546);
        list.add(74243546);
        list.add(73243546);
        list.add(74343546);
        list.add(743546);
        list.add(74356);
        list.add(74324546);
        list.add(123425);
        list.add(74324546);
        list.add(53454);
        list.add(567567);
        list.add(7876889);
        System.out.println(lastStoneWeight(list));
    }
}
