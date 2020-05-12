package com.bugbean.datastructure.list.impl;

import com.bugbean.datastructure.list.Queue;

/**
 * 顺序队列
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class ArrayQueue<E> implements Queue<E> {
    private E[] array;
    private int capacity;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        array = (E[]) new Object[capacity];
        this.capacity = capacity;
        head = tail = 0;
    }

    @Override
    public boolean enqueue(E e) {
        if (tail == capacity) {
            if (head == 0) {
                return false;
            }
            //数据搬迁
            for (int i = head; i < tail; i++) {
                array[i - head] = array[i];
            }
            tail -= head;
            head = 0;
        }
        array[tail++] = e;
        return true;
    }

    @Override
    public E dequeue() {
        if (head == tail) {
            return null;
        }
        return array[head++];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = head; i < tail; i++) {
            builder.append(array[i]);
            builder.append(",");
        }
        String substring = builder.substring(0, builder.length() - 1);
        return substring + "]";
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(100);
        System.out.println(queue);
    }
}
