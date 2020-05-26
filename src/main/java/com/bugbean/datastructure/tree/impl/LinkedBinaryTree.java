package com.bugbean.datastructure.tree.impl;

import com.bugbean.datastructure.tree.BinaryTree;

/**
 * 链式二叉树
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class LinkedBinaryTree<E> implements BinaryTree<E> {

    class TreeNode<E> {
        private TreeNode<E> left;
        private TreeNode<E> right;
        private E data;

        public TreeNode(E data) {
            this.data = data;
        }
    }

    private TreeNode<E> root;

    public LinkedBinaryTree(E... array) {
        TreeNode<E> node = null;

        for (E e : array) {
            TreeNode<E> newNode = new TreeNode<>(e);
            if (root == null) {
                root = newNode;
                node = root;
                continue;
            }

            if (node.left == null) {
                node.left = newNode;
            } else if (node.right == null) {
                node.right = newNode;
            } else {
                node = node.left;
                node.left = newNode;
            }
        }


    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode<E> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> binaryTree = new LinkedBinaryTree<>(1, 2, 3, 4, 5, 6);
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.inOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();
    }
}
