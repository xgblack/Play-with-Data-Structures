/**
 * @author 小光
 * @date 2019/7/25 13:32
 * className: Array
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class Array<E> {

    private E[] data;

    private int size;

    /**
     * 构造函数，传入数组容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }
    /**
     * 构造函数，传入数组,生成新数组
     *
     * @param arr
     */
    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 无参构造函数
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素个数
     * @return 元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量
     * @return 容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断是否为空
     * @return 是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在元素最后添加一个元素
     * @param e
     */
    public void addLast(E e) {
        add(size,e);
    }
    /**
     * 在元素开头添加一个元素
     * @param e
     */
    public void addFirst(E e) {
        add(0,e);
    }

    /**
     * 在index位置插入元素e
     * @param index
     * @param e
     */
    public void add(int index,E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加元素失败，索引需>=0,<=size");
        }
        if (size == data.length) {
            //扩容
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("添加元素失败，数组索引不合法");
        }
        return data[index];
    }

    public void set(int index,E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("添加元素失败，数组索引不合法");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素的索引，不存在的情况下返回-1
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除index位置的元素，
     * @param index
     * @return 删除的数
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("添加元素失败，数组索引不合法");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        //不写没有问题
        data[size] = null;

        //容量缩减
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }
    public E removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(E e){
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }


    /**
     * 改变容量
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 交换指定索引位置的元素
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(',');
            }
        }
        res.append(']');

        return res.toString();
    }
}
