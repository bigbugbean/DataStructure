package com.bugbean.datastructure.list.impl;

import com.bugbean.datastructure.list.Stack;

/**
 * s
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class ArrayStack<E> implements Stack<E> {

    private E[] array;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        array = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public void push(E e) {
        if (size >= capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[size++] = e;
    }

    @Override
    public E pop() {
        if (size == 0) {
            return null;
        }
        E e = array[size - 1];
        array[--size] = null;
        return e;
    }

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
