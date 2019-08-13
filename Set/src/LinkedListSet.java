package LinkedListSet;

import BSTSet.Set;

/**
 * @author 小光
 * @date 2019/8/13 16:09
 * className: LinkedListSet.LinkedListSet
 * description: 基于链表的集合
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;
    public LinkedListSet(){
        list = list = new LinkedList<E>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
