package com.bugbean.datastructure.list.impl;

import com.bugbean.datastructure.list.List;

/**
 * @author dugm
 * @description 链表
 * @date 2019-07-05 14:54
 */
public class LinkedList<E> implements List<E> {
    /**
     * 头部节点
     */
    private Node<E> head;

    /**
     * 当前节点
     */
    private Node<E> current;

    /**
     * 添加末尾元素
     *
     * @param e
     */
    @Override
    public void add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }

        Node<E> node = new Node<>();
        node.data = e;
        if (head == null) {
            head = node;
            current = head;
        } else {
            current.next = node;
            current = current.next;
        }

    }

    /**
     * 中间插入元素
     *
     * @param index
     * @param e
     */
    @Override
    public void add(int index, E e) {
        if (e == null) {
            throw new NullPointerException();
        }

        Node<E> newNode = new Node<>();
        newNode.data = e;
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            Node next = node.next;
            node.next = newNode;
            newNode.next = next;
        }
    }

    /**
     * 移除元素
     *
     * @param e
     */
    @Override
    public void remove(E e) {
        if (head.data.equals(e)) {
            head = head.next;
            return;
        }

        Node node = this.head;
        while (node != null) {
            Node next = node.next;
            if (next.data.equals(e)) {
                node.next = next.next;
                next.next = null;
                return;
            }
            node = next;
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
        remove(e);
        return e;
    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        Node node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return (E) node.data;
    }

    @Override
    public String toString() {
        Node node = this.head;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (node != null) {
            builder.append(node);
            builder.append("->");
            node = node.next;
        }
        return builder.substring(0, builder.length() - 2) + "]";
    }

    private class Node<E> {
        private E data;
        private Node<E> next;

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public static void main(String[] args) {
        LinkedList<Long> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add((long) i);
        }
        System.out.println(list);

        list.add(5, 800L);
        System.out.println(list);

        list.add(0, 89L);
        System.out.println(list);

        list.remove(8L);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

        list.remove(888L);
        System.out.println(list);
    }
}
