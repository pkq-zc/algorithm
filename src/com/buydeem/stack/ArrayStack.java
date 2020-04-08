package com.buydeem.stack;

/**
 * 底层使用数组实现的栈
 * @author zengchao
 * @version 1.0.0
 * @ClassName ArrayStack.java
 * @Description TODO
 * @createTime 2020年04月08日 21:36:00
 */
public class ArrayStack<T> implements Stack<T>{
    /**
     * 默认数组大小
     */
    private static final int DEFAULT_CAPACITY = 1024;

    private int capacity;
    /**
     * 当前栈顶索引
     */
    private int top = -1;

    private T[] datas;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int cap) {
        capacity = cap;
        datas = (T[]) new Object[capacity];
    }



    @Override
    public void push(T data) {
        if (top == capacity-1){
            throw new RuntimeException("栈溢出");
        }
        datas[++top] = data;
    }

    @Override
    public T pop() {
        if (top == -1){
            throw new RuntimeException("栈为空");
        }
        return datas[top--];
    }

    @Override
    public int getSize() {
        return top+1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public T top() {
        if (top <= -1){
            throw new RuntimeException("栈为空");
        }
        return datas[top];
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            sb.append(datas[i]);
            if (i != 0){
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }


}
