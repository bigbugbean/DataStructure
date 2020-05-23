package com.bugbean.arithmetic.sort;

import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 快速排序
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class QuickSortArithmetic {
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(array, p, r);
        quickSort(array, p, q - 1);
        quickSort(array, q + 1, r);
    }

    private int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p;

        for (int j = p; j < r; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, r);

        return i;
    }

    private int partitionL(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p;

        for (int j = p; j < r; j++) {
            if (array[j] > pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, r);

        return i;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int topK(int[] array, int start, int end, int k) {
        int q = partitionL(array, start, end);
        if (q > k - 1 + start) {
            return topK(array, start, q - 1, k);
        } else if (q < k - 1 + start) {
            return topK(array, q + 1, end, k - q - 1);
        } else {
            return array[q];
        }
    }

    public static void main(String[] args) {
        QuickSortArithmetic quickSortArithmetic = new QuickSortArithmetic();
        int[] a = {1, 2, 3, 4, 5, 6};
        quickSortArithmetic.quickSort(a);
        System.out.println(Arrays.toString(a));

        int i = quickSortArithmetic.topK(a, 0, a.length - 1, 3);
        System.out.println(i);
    }
}
