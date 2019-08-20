/**
 * @author 小光
 * @date 2019/7/27 18:10
 * Copyright(C),2018-2019,https://blog.xgblack.cn
 * interfaceName: Queue
 * description:
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
