/**
 * @author 小光
 * @date 2019/8/3 18:33
 * className: LinkedList
 * description: 单链表
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

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node();
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

        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }

        //Node node = new Node(e, prev.next);
        //prev.next = node;

        prev.next = new Node(e,prev.next);
        size ++;

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
            throw new IllegalArgumentException("Get failed.Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
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
            throw new IllegalArgumentException("Set failed.Illegal index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表是否存在元素e
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (e.equals(cur.e)) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

    /**
     * 删除索引位置的元素
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Delete failed.Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;

        size --;
        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev != null && prev.next != null) {
            if ( e.equals(prev.next.e)) {
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            prev = prev.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        //Node cur = dummyHead.next;
        //while (cur != null) {
        //    res.append(cur.e + "->");
        //    cur = cur.next;
        //}
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur.e + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
