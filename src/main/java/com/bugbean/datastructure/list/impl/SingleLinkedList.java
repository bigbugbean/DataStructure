package com.bugbean.datastructure.list.impl;

import com.bugbean.datastructure.list.LinkedList;
import org.junit.Test;

/**
 * 单链表
 *
 * @author dugm
 * @Description
 */
public class SingleLinkedList<E> implements LinkedList<E> {

    private Node<E> head = new Node<>();

    class Node<E> {
        E data;
        Node<E> next;

        Node() {
        }

        Node(E data) {
            this.data = data;
        }
    }

    @Override
    public void add(int index, E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> p = getNode(index - 1);
        newNode.next = p.next;
        p.next = newNode;
    }

    @Override
    public void remove(int index) {
        Node<E> p = head;
        Node<E> pre = null;
        for (int i = 0; i < index + 1; i++) {
            pre = p;
            p = p.next;
            if (p == null) {
                throw new RuntimeException("超过当前列表大小");
            }
        }
        pre.next = p.next;
        p.next = null;
    }

    @Override
    public void set(int index, E e) {
        Node<E> node = getNode(index);
        node.data = e;
    }

    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    private Node<E> getNode(int index) {
        Node<E> p = head;
        for (int i = 0; i < index + 1; i++) {
            p = p.next;
            if (p == null) {
                throw new RuntimeException("超过当前列表大小");
            }
        }
        return p;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> p = head.next;
        while (p != null) {
            builder.append("[");
            builder.append(p.data);
            builder.append("]");
            builder.append("->");
            p = p.next;
        }
        builder.append("null");
        return builder.toString();
    }

    /**
     * 判断链表是否有环
     *
     * @return
     */
    public boolean hasLoop() {
        Node<E> fast = head;
        Node<E> slow = head;
        int i = 0;
        do {
            i++;
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);
        System.out.println("执行了" + i + "次");
        return true;
    }

    @Test
    public void testHasLoop() {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        for (int i = 0; i < 3; i++) {
            singleLinkedList.add(i, i);
        }
        System.out.println(singleLinkedList);
//        Node<Integer> node = (Node<Integer>) singleLinkedList.getNode(4);
//        node.next = (Node<Integer>) singleLinkedList. head;
        System.out.println(singleLinkedList.hasLoop());
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        System.out.println(singleLinkedList);
        singleLinkedList.add(0, 0);
//        singleLinkedList.add(1, 1);
//        singleLinkedList.add(1, 5);
        System.out.println(singleLinkedList);
        for (int i = 0; i < 10; i++) {
            singleLinkedList.add(i, i);
        }
        System.out.println(singleLinkedList);
        System.out.println("get :" + singleLinkedList.get(0));
        singleLinkedList.remove(1);
        System.out.println(singleLinkedList);
        singleLinkedList.set(2, 100);
        System.out.println(singleLinkedList);
    }
}
