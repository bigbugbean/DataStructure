package com.bugbean.datastructure.linkedlist;

/**
 * 单链表
 */
public class SinglyLinkedList<E> {

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

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<E> head;

    public SinglyLinkedList<E> reverseList(Node<E> head){
        SinglyLinkedList<E> newSinglyLinkedList = new SinglyLinkedList<>();
        Node<E> p = head;
        while (p != null){
            newSinglyLinkedList.insertToHead(p.data);
            p = p.next;
        }
        return newSinglyLinkedList;
    }

    public Node<E> findByIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }

        Node<E> p = head;
        int i = 0;
        while (p != null && i++ < index) {
            p = p.next;
        }
        if (index > i) {
            throw new IllegalArgumentException();
        }
        return p;
    }

    /**
     * 在指定下标后插入
     *
     * @param index
     * @param data
     */
    public void insert(int index, E data) {
        int i = 0;
        if (head == null) {

        }
    }

    public void insertToHead(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertToTail(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        }
    }


    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insertToTail(1);
        singlyLinkedList.insertToTail(2);
        singlyLinkedList.insertToTail(3);
        singlyLinkedList.insertToTail(4);
        singlyLinkedList.insertToTail(5);
        System.out.println(singlyLinkedList);
        System.out.println(singlyLinkedList.reverseList(singlyLinkedList.head));
    }
}
