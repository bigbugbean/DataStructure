package com.bugbean.datastructure.list;

/**
 * 线性表
 *
 * @author dugm
 * @Description
 */
public interface List<E> {
    /**
     * 增
     *
     * @param index
     * @param e
     */
    void add(int index, E e);

    /**
     * 删
     *
     * @param index
     */
    void remove(int index);

    /**
     * 改
     *
     * @param index
     * @param e
     */
    void set(int index, E e);

    /**
     * 查
     *
     * @param index
     * @return
     */
    E get(int index);

}
