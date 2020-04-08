package com.buydeem.stack;

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
