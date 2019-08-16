/**
 * @author 小光
 * @date 2019/8/16 16:05
 * Copyright(C),2018-2019,https://blog.xgblack.cn
 * interfaceName: Map
 * description:
 */
public interface Map<K,V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int getsize();

    boolean isEmpty();
}
