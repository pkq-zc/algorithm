package com.buydeem.stack;

/**
 * 栈特性:
 * 1.先进后出 FILO
 * 2.主要的操作有 压栈(将元素压入栈的顶部) 和 出栈(将元素从栈的顶部移除)
 * @param <T>
 */
public interface Stack<T> {
    /**
     * 将对象压入栈顶
     * @param data
     */
    void push(T data);

    /**
     * 从栈顶移除对象
     * @return
     */
    T pop();

    /**
     * 获取栈中元素个数
     * @return
     */
    int getSize();

    /**
     * 栈中元素是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 获取栈顶元素,但是并不移除
     * @return
     */
    T top();

    /**
     * 打印栈中元素
     */
    void print();
}
