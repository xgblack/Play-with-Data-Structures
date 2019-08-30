/**
 * @author 小光
 * @date 2019/8/30 11:20
 * className: AVLSet
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {
    private AVLTree<E,Object>  avl;
    public AVLSet(){
        avl = new AVLTree<>();
    }
    @Override
    public void add(E e) {
        avl.add(e,null);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public int getSize() {
        return avl.getsize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
