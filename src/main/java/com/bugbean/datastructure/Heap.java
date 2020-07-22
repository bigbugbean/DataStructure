package com.bugbean.datastructure;

/**
 * 外卖-订单
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */

public class Heap {
    /**
     * 数组，从下标1开始存储数据
     */
    private int[] heapArray;
    /**
     * 堆可以存储的最大数据个数
     */
    private int capacity;
    /**
     * 堆中已经存储的数据个数
     */
    private int size;

    public Heap(int n) {
        capacity = n;
        this.heapArray = new int[capacity + 1];
        size = 0;
    }

    public void insert(int data) {
        // 堆满了
        if (size >= capacity) {
            return;
        }
        heapArray[++size] = data;
        int i = size;
        // 自下往上堆化
        while (i / 2 > 0 && heapArray[i] < heapArray[i / 2]) {
            swap(heapArray, i, i / 2);
            i = i / 2;
        }
    }

    public void removeTop() {
        // 堆中没有数据
        if (size == 0) {
            return;
        }
        heapArray[1] = heapArray[size];
        heapify(heapArray, --size, 1);
    }

    /**
     * 展示堆顶元素
     *
     * @return
     */
    public int peek() {
        if (size > 0) {
            return heapArray[1];
        }
        throw new RuntimeException();
    }

    /**
     * 自上往下堆化
     *
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] > a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && a[maxPos] > a[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(100);

        //从文件读取100行数据
        int[] array = new int[100];
        while (done()){
            array = readFromFile();
        }

        for (int value : array) {
            if (value > heap.peek()) {
                heap.removeTop();
                heap.insert(value);
            }
        }

    }

    private static int[] readFromFile() {
        //伪代码
//        this new ClassCastException()
        return null;
    }

    private static boolean done() {
//        伪代码
        return false;
    }
}
