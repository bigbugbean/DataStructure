package com.bugbean.datastructure.list;

/**
 * 队列
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public interface Queue<E> {
    boolean enqueue(E e);

    E dequeue();
}
