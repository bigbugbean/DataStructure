package com.bugbean.datastructure.tree.impl;

/**
 * 二叉查找树
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class BinarySearchTree<E extends Comparable> extends LinkedBinaryTree<E> {


    public void insert(E data) {
        if (data == null) {
            return;
        }
        TreeNode<E> newNode = new TreeNode<E>(data);
        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode<E> node = this.root;
        while (true) {
            if (data.compareTo(node.data) > 0) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = newNode;
                    return;
                }
            }
            if (data.compareTo(node.data) < 0) {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = newNode;
                    return;
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    public TreeNode<E> search(E data) {
        if (data == null || root == null) {
            return null;
        }
        TreeNode<E> node = this.root;
        while (node != null) {
            if (data.compareTo(node.data) > 0) {
                node = node.right;
            } else if (data.compareTo(node.data) < 0) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public void remove(E data) {
        if (data == null || root == null) {
            return;
        }
        //查找目标节点的同时记录父节点
        TreeNode<E> node = this.root;
        TreeNode<E> parent = null;
        while (node != null) {
            if (data.compareTo(node.data) > 0) {
                parent = node;
                node = node.right;
            } else if (data.compareTo(node.data) < 0) {
                parent = node;
                node = node.left;
            } else {
                if (parent == null) {
                    root = null;
                    return;
                }

                //被删除节点有2个子节点，找出被删节点右子树的最小节点，替换被删节点
                if (node.left != null && node.right != null) {
                    TreeNode<E> minNode = node.right;
                    TreeNode<E> minParent = node;
                    while (minNode.left != null) {
                        minParent = minNode;
                        minNode = minNode.left;
                    }
                    //用最小节点替换被删节点
                    // 将最小节点的数据替换到被删节点中
                    node.data = minNode.data;
                    //要删除的就变成最小节点了
                    node = minNode;
                    parent = minParent;
                }

                if (node.left == null && node.right == null) {
                    //1.被删除节点没有子节点，把父节点的子节点指向null
                    if (parent.left == node) {
                        parent.left = null;
                    } else if (parent.right == node) {
                        parent.right = null;
                    }
                } else {
                    //2.被删除节点只有1个子节点，让父节点指向被删节点的子节点
                    if (node.left != null) {
                        if (parent.left == node) {
                            parent.left = node.left;
                        } else if (parent.right == node) {
                            parent.right = node.left;
                        }
                    } else if (node.right != null) {
                        if (parent.left == node) {
                            parent.left = node.right;
                        } else if (parent.right == node) {
                            parent.right = node.right;
                        }
                    }
                }
                return;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(10);
//        for (int i = 10; i > 0; i--) {
//            tree.insert(i);
//        }
        tree.levelOrder();
        TreeNode<Integer> search = tree.search(8);
        tree.remove(1);
        tree.levelOrder();
        tree.remove(3);
        tree.levelOrder();
        tree.remove(8);
        tree.levelOrder();
        System.out.println("中序遍历");
        tree.inOrder();
    }
}
