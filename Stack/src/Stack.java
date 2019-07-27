/**
 * @author 小光
 * @date 2019/7/27 11:38
 * Copyright(C),2018-2019,https://blog.xgblack.cn
 * interfaceName: Stack
 * description:
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
