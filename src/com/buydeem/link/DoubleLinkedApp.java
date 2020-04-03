package com.buydeem.link;

/**
 * @author zengchao
 * @version 1.0.0
 * @ClassName DoubleLinkedApp.java
 * @Description TODO
 * @createTime 2020年04月03日 21:14:00
 */
public class DoubleLinkedApp {
    public static void main(String[] args) {
        DoubleLinked<Integer> linked = new DoubleLinked<>();
        //添加节点
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        //节点是否存在
        boolean exist = linked.exist(3);
        System.out.println("3 exist = " + exist);
        exist = linked.exist(10);
        System.out.println("10 exist = " + exist);
        //删除节点
        linked.remove(1);
        linked.remove(5);
        linked.remove(10);
        linked.print();
        //按索引删除
        linked.deleteByIndex(1);
        linked.deleteByIndex(0);
        linked.print();
    }
}
