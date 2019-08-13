package BSTSet;

/**
 * @author 小光
 * @date 2019/8/13 15:48
 * Copyright(C),2018-2019,https://blog.xgblack.cn
 * interfaceName: Set
 * description:
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
