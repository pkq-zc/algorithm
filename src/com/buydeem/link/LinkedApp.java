package com.buydeem.link;

/**
 *  head -> node1 -> node2 -> node3 -> null
 * 特性:
 * 1.单向链表通过当前节点保存下一个节点的引用存储数据
 * 2.它不需要像数组使用连续的内存段
 * 3.删除元素只需要将被删除节点的下一个节点指向删除节点的前一个节点即可,不需要挪动删除节点的后续节点
 * @author zengchao
 * @version 1.0.0
 * @ClassName LinkedNodeApp.java
 * @Description TODO
 * @createTime 2020年04月02日 21:03:00
 */
public class LinkedApp {
    public static void main(String[] args) {
        Linked<Integer> linkedNode = new Linked<>();
        linkedNode.print();
        //添加元素
        linkedNode.add(1);
        linkedNode.add(2);
        linkedNode.add(3);
        linkedNode.add(4);
        linkedNode.add(5);
        linkedNode.print();
        //检查元素是否存在
        boolean exist = linkedNode.exist(3);
        System.out.println("3 exist = " + exist);

        exist = linkedNode.exist(10);
        System.out.println("10 exist = " + exist);
        //删除元素
        boolean deleteSuccess = linkedNode.remove(3) != null ;
        System.out.println("Delete success ? " + deleteSuccess);
        linkedNode.print();
        deleteSuccess = linkedNode.remove(10) != null;
        System.out.println("Delete success ? " + deleteSuccess);
        linkedNode.print();
    }
}
