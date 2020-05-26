package com.bugbean.datastructure.tree;

/**
 * 二叉树
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public interface BinaryTree<E> {
    /**
     * 前序遍历
     */
    void preOrder();

    /**
     * 中序遍历
     */
    void inOrder();

    /**
     * 后序遍历
     */
    void postOrder();

}
