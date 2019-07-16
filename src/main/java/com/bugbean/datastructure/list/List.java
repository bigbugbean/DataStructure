package com.bugbean.datastructure.list;

/**
 * @author dugm
 * @description 线性表
 * @date 2019-07-04 14:44
 */
public interface List<E> {
    /**
     * 添加末尾元素
     *
     * @param e
     */
    void add(E e);

    /**
     * 中间插入元素
     *
     * @param index
     * @param e
     */
    void add(int index, E e);

    /**
     * 移除元素
     *
     * @param e
     */
    void remove(E e);

    /**
     * 移除元素
     *
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    E get(int index);
}
