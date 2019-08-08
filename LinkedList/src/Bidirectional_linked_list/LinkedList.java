package Bidirectional_linked_list;

/**
 * @author 小光
 * @date 2019/8/7 21:03
 * className: LinkedList
 * description: 双向链表
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
        public Node prev;
        public Node next;

        public Node(E e,Node prev, Node next) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }

        public Node(E e) {
            this(e, null,null);
        }

        public Node() {
            this(null, null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public Node head;
    public int size;

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

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Illegal index");
        }
        if (head ==null) {
            head = new Node(e, null, null);
        } else {
            if (index == 0) {
                Node newNode = new Node(e, null, head);
                head.prev = newNode;
                head = newNode;
            } else if (index == size) {
                Node prevNode = head;
                for (int i = 0; i < index - 1; i++) {
                    prevNode = prevNode.next;
                }
                prevNode.next = new Node(e, prevNode, null);
            } else {
                Node curNode = head;
                for (int i = 0; i < index; i++) {
                    curNode = curNode.next;
                }

                Node newNode = new Node(e, curNode.prev, curNode);
                curNode.prev.next = newNode;
                curNode.prev = newNode;

            }

        }
        size ++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表index（0-based）位置的元素
     * 链表中不常用
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed.Illegal index");
        }
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.e;
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

        Node curNOde = head;
        for (int i = 0; i < index; i++) {
            curNOde = curNOde.next;
        }
        curNOde.e = e;
    }

    /**
     * 查找链表是否存在元素e
     */
    public boolean contains(E e) {
        Node curNode = head;
        while (curNode != null) {
            if (curNode.e == e) {
                return true;
            } else {
                curNode = curNode.next;
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
        Node delNode = head;
        for (int i = 0; i < index; i++) {
            delNode = delNode.next;
        }
        Node prevNode = delNode.prev;
        Node nextNode = delNode.next;
        E ret = delNode.e;
        if (prevNode == null && nextNode == null) {
            head = null;
        } else if (prevNode == null) {
            nextNode.prev = null;
            head = nextNode;
            delNode = null;
        } else if (nextNode == null) {
            prevNode.next = null;
            delNode = null;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            delNode = null;
        }
        size --;
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        if (head == null) {
            return;
        }
        if (head.e == e) {
            remove(0);
        }
        Node curNode = head;
        for (int i = 0; i < size; i++) {
            curNode = curNode.next;
            if (curNode.e == e) {
                remove(i + 1);
                return;
            }
        }
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
}
