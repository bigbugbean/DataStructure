package com.bugbean.arithmetic.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class MergeSortArithmetic {

    public void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * mergeSort(p...r) = merge(mergeSort(p...q), mergeSort(q+1...r))
     *
     * @param array
     * @return
     */
    private void mergeSort(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }
        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;

        mergeSort(array, p, q);
        mergeSort(array, q + 1, r);
        merge(array, p, q, r);
    }

    private void merge(int[] array, int p, int q, int r) {
        int[] temp = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;
        while (i <= q && j <= r) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            temp[k++] = array[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r - p; ++i) {
            array[p + i] = temp[i];
        }
    }

    @Test
    public void test() {
        int[] a = {0, 4, 5, 2};
        new MergeSortArithmetic().mergeSort(a);

        System.out.println(Arrays.toString(a));
    }
}
