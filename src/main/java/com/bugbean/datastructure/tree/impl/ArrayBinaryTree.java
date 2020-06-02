package com.bugbean.datastructure.tree.impl;

import com.bugbean.datastructure.tree.BinaryTree;

/**
 * 顺序二叉树
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class ArrayBinaryTree<E> implements BinaryTree<E> {
    private Integer[] array;

    public ArrayBinaryTree(Integer[] array) {
        this.array = new Integer[array.length + 1];
        System.arraycopy(array, 0, this.array, 1, array.length);
    }

    @Override
    public void preOrder() {
        preOrder(1);
    }

    private void preOrder(Integer index) {
        if (index > array.length - 1) {
            return;
        }
        System.out.println(array[index]);
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    @Override
    public void inOrder() {
        inOrder(1);
    }

    private void inOrder(int index) {
        if (index > array.length - 1) {
            return;
        }
        inOrder(index * 2);
        System.out.println(array[index]);
        inOrder(index * 2 + 1);
    }

    @Override
    public void postOrder() {
        postOrder(1);
    }

    @Override
    public void levelOrder() {
        for (int i = 1; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private void postOrder(int index) {
        if (index > array.length - 1) {
            return;
        }
        postOrder(index * 2);
        postOrder(index * 2 + 1);
        System.out.println(array[index]);
    }

    public static void main(String[] args) {
        ArrayBinaryTree<Integer> binaryTree = new ArrayBinaryTree<>(new Integer[]{1, 2, 3, 4, 5, null, 6});
        binaryTree.preOrder();
        System.out.println("=============================");
        binaryTree.inOrder();
        System.out.println("=============================");
        binaryTree.postOrder();
        System.out.println("=============================");
        binaryTree.levelOrder();
    }
}
