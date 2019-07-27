/**
 * @author 小光
 * @date 2019/7/27 11:40
 * className: ArrayStack
 * description: 基于动态数组实现的栈
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public  ArrayStack(){
        array = new Array<>();
    }
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(',');
            }
        }
        res.append(']');
        res.append(" TOP");
        return res.toString();
    }

    public int getCapacity(){
        return array.getCapacity();
    }
}
