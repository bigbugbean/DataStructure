package com.bugbean.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 汉诺塔
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class Hanoi {
    public static void main(String[] args) {
        List<String> hanoi = hanoi(20  , "A", "B", "C");
        System.out.println(hanoi);
    }

    public static List<String> hanoi(int n, String p1, String p2, String p3) {
        List<String> trackList = new ArrayList<>();
        if (n == 1) {
            trackList.add(p1 + "->(" + n + ")" + p3);
            return trackList;
        }

        trackList = hanoi(n - 1, p1, p3, p2);
        trackList.add(p1 + "->(" + n + ")" + p3);
        trackList.addAll(hanoi(n - 1, p2, p1, p3));
        return trackList;
    }
}
