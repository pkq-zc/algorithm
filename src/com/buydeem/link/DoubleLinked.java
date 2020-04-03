package com.buydeem.link;

/**
 * 双向链表
 * 1.双向链表在单向链表的基础上增加了指向上一个节点的引用
 * 2.在删除元素时需要将被删除的节点before节点的next引用指向被删除的链表的next节点,将被删除节点的next节点的before引用指向被删除节点的before节点
 * 3.双向链表在按索引删除时,可以判断距离链表的头结点近还是尾节点近事删除查找效率提高
 * @author zengchao
 * @version 1.0.0
 * @ClassName DoubleLinked.java
 * @Description 双向链表
 * @createTime 2020年04月03日 20:57:00
 */
public class DoubleLinked<T> {
    /**
     * 头节点
     */
    private Node<T> head;
    /**
     * 尾节点
     */
    private Node<T> tail;

    private int size;
    class Node<T> {
        /**
         * 存储上一个节点的引用
         */
        private Node<T> before;
        /**
         * 下一个节点
         */
        private Node<T> next;
        /**
         * 存储数据
         */
        private T data;

        public Node(Node<T> before, Node<T> next, T data) {
            this.before = before;
            this.next = next;
            this.data = data;
        }

        public Node() {
        }
    }

    public DoubleLinked() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.before = head;
        size = 0;
    }

    /**
     * 添加节点.从尾部插入节点
     * @param data
     */
    public void add(T data){
        Node<T> currentNode = new Node<>(null, null, data);
        //获取尾节点的前一个节点
        Node<T> before = tail.before;
        //将当前节点的前节点设置成before
        currentNode.before = before;
        //将当前节点的下一个节点设置成尾节点
        currentNode.next = tail;
        //将before节点的下一个节点指向当前节点
        before.next = currentNode;
        //将tail节点的上以一个节点指向当前节点
        tail.before = currentNode;
        size++;
    }

    public boolean exist(T data){
        //从头节点的下一个节点开始找
        Node<T> currentNode = head.next;
        //如果当前节点不为空
        while (currentNode != null){
            //比较当前节点的值与要找的值是否相同
            if (currentNode.data != null && currentNode.data.equals(data)){
                //相同直接返回
                return true;
            }
            //将当前节点的下一个节点指向当前节点
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * 删除节点
     * @param data
     * @return
     */
    public T remove(T data){
        //获取当前节点(从头节点的下一个节点开始删除)
        Node<T> currentNode = head.next;
        //如果当前节点的值不等于要删除的值
        while (currentNode.data == null || !currentNode.data.equals(data)){
            //将当前节点的下一个节点设置为当前节点
            currentNode = currentNode.next;
            //如果当前节点为空 说明已经到了最后一个节点 直接返回
            if (currentNode == null){
                return null;
            }
        }
        //临时保存要删除节点的值
        T delete = currentNode.data;
        // 获取被删除的节点的上一个节点
        Node<T> before = currentNode.before;
        //获取被删除节点的下一个节点
        Node<T> next = currentNode.next;
        //将删除节点的前一个节点的next指向删除节点的一个节点
        before.next = next;
        //将删除节点的下一个节点的before指向删除节点的上一个节点 当被删除的节点没有其他节点引用它将被GC
        next.before = before;
        //数量减一
        size--;
        return delete;
    }

    public T deleteByIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index show > 0 or < "+size);
        }
        // 获取中间元素
        int mid = size >> 1;
        T delete = null;
        int current = 0;
        Node<T> currentNode;
        if (index < mid){
            //离head比较近 从head开始删除
            currentNode = head.next;
            while (current < index){
                current++;
                currentNode = currentNode.next;
            }
        }else {
            //离tail比较近 从tail开始删除
            currentNode = tail.before;
            while (current < index){
                current++;
                currentNode = currentNode.before;
            }
        }
        Node<T> before = currentNode.before;
        Node<T> next = currentNode.next;
        before.next = next;
        next.before = before;
        delete = currentNode.data;
        size--;
        return delete;
    }

    /**
     * 打印链表
     */
    public void print(){
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
