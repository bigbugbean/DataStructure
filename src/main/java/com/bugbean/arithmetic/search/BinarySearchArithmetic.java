package com.bugbean.arithmetic.search;

/**
 * 二分查找
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class BinarySearchArithmetic {
    public int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (array[middle] == key) {
                return middle;
            } else if (array[middle] < key) {
                low = middle + 1;
            } else if (array[middle] > key) {
                high = middle - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 7, 8, 9};
        int i = new BinarySearchArithmetic().binarySearch(a, 5);
        System.out.println(i);
    }
}
