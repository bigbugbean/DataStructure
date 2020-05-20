package com.bugbean.datastructure.list.impl;

import com.bugbean.datastructure.list.Queue;

/**
 * 外卖-订单
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class CircleQueue<E> implements Queue<E> {

    private E[] array;
    private int head;
    private int tail;

    private int capacity;

    @SuppressWarnings("unchecked")
    public CircleQueue(int capacity) {
        this.capacity = capacity;
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean enqueue(E e) {

        if (isFull()) {
            return false;
        }

        array[tail++] = e;
        tail %= capacity;
        return true;
    }

    @Override
    public E dequeue() {
        if (head == tail) {
            return null;
        }
        E e = array[head++];
        head %= capacity;
        return e;
    }

    private boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = head; i != tail; i++) {
            i %= capacity;
            builder.append(array[i]);
            builder.append(",");
        }
        String substring = builder.substring(0, builder.length() - 1);
        return substring + "]";
    }

    public static void main(String[] args) {
        CircleQueue<Integer> queue = new CircleQueue<>(10);
        for (int i = 0; i < 18; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }
}
