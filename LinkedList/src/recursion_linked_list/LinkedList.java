package recursion_linked_list;

import javafx.util.Pair;

/**
 * @author 小光
 * @date 2019/8/7 18:50
 * className: LinkedList
 * description: 单链表，使用递归算法实现增删改查的链表
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class LinkedList<E> {
    /**
     * 节点类
     * 私有的内部类
     */
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    /**
     * 获取链表容量
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }



    /**
     * 在链表index（0-based）位置添加新元素
     * 链表中不常用
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Illegal index");
        }

        head = add(head, index, e);
        size ++;

    }

    private Node add(Node node, int index, E e) {
        if (index == 0) {
            return new Node(e, node);
        }
        node.next = add(node.next, index - 1, e);
        return node;

    }

    /**
     * 在链表头添加新元素
     */
    public void addFirst(E e) {
        //Node node = new Node(e);
        //node.next = head;
        //head = node;

        //head = new Node(e, head);

        //dummyHead.next = new Node(e, null);
        //
        //size ++;

        add(0,e);
    }

    public void addLast(E e){
        add(size, e);
    }

    /**
     * 获得链表index（0-based）位置的元素
     * 链表中不常用
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed.Illegal index");
        }
        return get(head, index);

    }

    private E get(Node node, int index) {
        if (index == 0) {
            return node.e;
        }
        return get(node.next, index - 1);
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表index（0-based）位置的元素
     * 链表中不常用
     */
    public void set(int index,E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed.Illegal index");
        }
        set(head,index,e);

    }

    private void set(Node node, int index, E e) {
        if (index == 0) {
            node.e = e;
            return;
        }
        set(node.next,index - 1,e);
    }

    /**
     * 查找链表是否存在元素e
     */
    public boolean contains(E e) {

        return contains(head,e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        }
        return contains(node.next, e);
    }

    /**
     * 删除索引位置的元素
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed.Illegal index");
        }
        Pair<Node, E> res = remove(head, index);
        size --;
        head = res.getKey();
        return res.getValue();
    }

    private Pair<Node, E> remove(Node node,int index) {
        if (index == 0) {
            return new Pair<>(node.next, node.e);
        }
        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();
        return new Pair<>(node,res.getValue());
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e){
        head = removeElement(head, e);
    }

    private Node removeElement(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (node.e.equals(e)) {
            size --;
            return node.next;
        }
        return removeElement(node.next,e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = head;
        while (cur != null) {
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }



    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0 ; i < 10 ; i ++) {
            list.addFirst(i);
            System.out.println(list);
        }

        while(!list.isEmpty()) {
            System.out.println("removed " + list.removeLast());
        }
    }
}
