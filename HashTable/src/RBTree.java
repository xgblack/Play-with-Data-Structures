/**
 * @author 小光
 * @date 2019/9/1 14:51
 * className: RBTree
 * description: 红黑树
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class RBTree<K extends Comparable<K>,V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    /**
     * 私有的内部类：节点类
     */
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public boolean color;

        public Node(K key,V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }

    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node){
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 颜色反转
     * @param node
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.right.color = BLACK;
        node.left.color = BLACK;
    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node) {
        Node x = node.left;

        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    // 判断节点node的颜色
    private boolean isRed(Node node){
        if(node == null) {
            return BLACK;
        }
        return node.color;
    }


    public void add(K key, V value) {
        root = add(root, key,value);
        root.color = BLACK;
    }
    /**
     * 向以node为根的红黑树中插入元素e，递归算法
     * @param node
     * @param key
     * @param value
     * @return 返回插入新节点红黑树的跟
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            //默认红色
            return new Node(key,value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            //e.compareTo(node.e) > 0
            node.right = add(node.right, key, value);
        } else {
            //key.compareTo(node.key) == 0
            node.value = value;
        }
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }


    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }
    /**
     * 删除以Node为跟的二分搜索树中值为e的节点（递归算法）
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left,key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            //e.compareTo(node.e) == 0;
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                //待删除节点左右子树都不为空的情况
                //调用minimum方法，寻找右子树中的最小节点
                Node successor = minimum(node.right);
                //removeMin操作中已经维护过size了
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }
    }

    /**
     * 查找最小值
     * @return
     */
    private V minimum(){
        if(size == 0) {
            throw new IllegalArgumentException("BSTMap is empty");
        }
        Node minNode = minimum(root);
        return minNode.value;
    }
    /**
     * 返回最小值所在节点为根节点的二分搜索树（递归算法）
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    /**
     * 删除最小值方法
     * @return
     */
    public V removeMin(){
        V ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }


    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    public V get(K key) {
        Node node = getNode(root, key);
        return node == null?null:node.value;
    }



    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " don't exist!");
        }
        node.value = newValue;
    }

    /**
     * 返回以node为根节点的二分搜索树中key所在的节点
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }


    public int getsize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }
}
