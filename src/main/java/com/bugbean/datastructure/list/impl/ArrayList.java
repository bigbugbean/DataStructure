package com.bugbean.datastructure.list.impl;

import com.bugbean.datastructure.list.List;

/**
 * @author dugm
 * @description 数组
 * @date 2019-07-04 14:46
 */
public class ArrayList<E> implements List<E> {

    private static final int INIT_SIZE = 10;
    private static final int STEP_LENGTH = INIT_SIZE;

    private Object[] array;

    /**
     * 当前游标
     */
    private int curIndex = 0;

    public ArrayList() {
        this.array = new Object[INIT_SIZE];
    }

    public ArrayList(int initSize) {
        this.array = new Object[initSize];
    }

    /**
     * 末尾添加元素
     *
     * @param e
     */
    @Override
    public void add(E e) {
        checkCapacity();
        array[curIndex++] = e;
    }

    /**
     * 中间插入元素
     *
     * @param index
     * @param e
     */
    @Override
    public void add(int index, E e) {
        System.arraycopy(array, index, array, index + 1, array.length - index);
        array[index] = e;
    }

    private void checkCapacity() {
        int oldLength = array.length;
        if (curIndex == oldLength) {
            Object[] temp = array;
            int newLength = oldLength + STEP_LENGTH;
            array = new Object[newLength];
            System.arraycopy(temp, 0, array, 0, oldLength);
        } else if (curIndex == oldLength - STEP_LENGTH - 1) {
            Object[] temp = array;
            int newLength = oldLength - STEP_LENGTH;
            array = new Object[newLength];
            System.arraycopy(temp, 0, array, 0, newLength);
        }
    }

    /**
     * 移除元素
     *
     * @param e
     */
    @Override
    public void remove(E e) {
        for (int i = 0; i < array.length; i++) {
            if (e.equals(get(i))) {
                remove(i);
                return;
            }
        }
    }

    /**
     * 移除元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        E e = get(index);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array[--curIndex] = null;
        checkCapacity();
        return e;
    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < curIndex; i++) {
            builder.append(array[i]);
            if (i != curIndex - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i < 10; i++) {
            arrayList.remove(i);
        }
        arrayList.remove(20);
        System.out.println(arrayList);
    }
}
