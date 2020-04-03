package com.buydeem.link;

/**
 * @author zengchao
 * @version 1.0.0
 * @ClassName LinkedNode.java
 * @Description 单向链表
 * @createTime 2020年04月02日 21:01:00
 */
public class LinkedNode<T> {
    private Node<T> head;
    private int size;

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
        }
    }

    public LinkedNode() {
        head = new Node<>(null, null);
        size = 0;
    }

    /**
     * 添加元素
     *
     * @param data
     */
    public void add(T data) {
        Node<T> node = new Node<>(data, null);
        Node<T> currentNode = this.head;
        Node<T> next = currentNode.next;

        while (next != null) {
            currentNode = next;
            next = currentNode.next;
        }
        currentNode.next = node;
        size++;
    }

    /**
     * 判断元素是否存在
     *
     * @param data
     * @return
     */
    public boolean exist(T data) {
        Node<T> currentData = this.head;
        //如果当前节点的值为空 或者 当前值与要找的值不同 将游标指向下一个
        while (currentData.data == null || !currentData.data.equals(data)) {
            currentData = currentData.next;
            //如果下一个已经是空了 直接返回找不到
            if (currentData == null) {
                return false;
            }
        }
        return true;
    }

    public T remove(T data) {
        //获取删除节点的前一个节点
        Node<T> before = this.head;
        //获取当前比较的节点
        Node<T> currentNode = before.next;
        //如果当前节点为空 直接返回空
        if (currentNode == null) {
            return null;
        }
        //如果当前节点的值不等于要删除的值进入循环
        while (currentNode.data == null || !currentNode.data.equals(data)) {
            // 替换before节点为当前节点 再将下一个节点设置为当前节点
            before = currentNode;
            currentNode = before.next;
            //如果当前节点为空 说明到了链表的尾部
            if (currentNode == null) {
                return null;
            }
        }
        //临时保存当前节点的值
        T delete = currentNode.data;
        //将删除节点的下一个节点指向before节点 就是链表的删除操作
        before.next = currentNode.next;
        //修改链表的个数
        size--;
        return delete;
    }

    /**
     * 获取链表的长度
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 打印链表的元素
     */
    public void print() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = this.head.next;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(current.data);
            } else {
                sb.append(current.data).append(",");
            }
            current = current.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
