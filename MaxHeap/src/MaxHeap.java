/**
 * @author 小光
 * @date 2019/8/18 17:16
 * className: MaxHeap
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * heapify
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 完全二叉树的数组表示中，一个索引所表示的元素的左孩子的索引
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 完全二叉树的数组表示中，一个索引所表示的元素的右孩子的索引
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮操作
     * @param k
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            //上浮操作
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    /**
     * 找到最大元素
     * @return
     */
    public E findMax(){
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }

    /**
     * 取出最大元素
     * @return
     */
    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 下沉操作
     * @param k
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                //有右孩子，并且右孩子比左孩子大
                j = rightChild(k);
            }
            //data[j] leftChild和rightChild中的最大值
            if (data.get(k).compareTo(data.get(j)) > 0) {
                break;
            } else {
                data.swap(k, j);
                k = j;
            }
        }
    }

    /**
     * 取出最大元素，并添加一个新元素
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMax();

        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
