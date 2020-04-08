package com.buydeem.stack;

/**
 * @author zengchao
 * @version 1.0.0
 * @ClassName ArrayStackApp.java
 * @Description TODO
 * @createTime 2020年04月08日 21:47:00
 */
public class ArrayStackApp {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>(5);
        //压入对象
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //打印
        stack.print();
        //获取栈顶元素
        System.out.println(stack.top());
        //出栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //判断是否为空
        System.out.println("stack is empty ? "+stack.isEmpty());
        //获取栈中元素个数
        System.out.println("stack element count : " + stack.getSize());
        //
    }
}
