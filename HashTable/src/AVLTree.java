import java.util.ArrayList;

/**
 * @author 小光
 * @date 2019/8/30 9:04
 * className: AVLTree
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class AVLTree<K extends Comparable<K>,V> {
    /**
     * 私有的内部类：节点类
     */
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key,V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }

    /**
     * 获取以node为根节点的树的高度
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获得node节点的平衡因子
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node){
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public void add(K key, V value) {
        root = add(root, key,value);
    }
    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     * @param node
     * @param key
     * @param value
     * @return 返回插入新节点后二分搜索树的跟
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
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

        //更新height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            //不是平衡二叉树了
            //System.out.println("unbalanced : " + balanceFactor);

            //平衡维护
            if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
                //产生不平衡的节点在左侧的左侧   LL
                //右旋转
                return rightRotate(node);
            } else if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
                // RR
                return leftRotate(node);
            } else if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
                //LR
                node.left = leftRotate(node.left);
                //转为了RR
                return rightRotate(node);
            } else if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
                //RL
                node.right = rightRotate(node.right);
                //转为了LL
                return leftRotate(node);
            }
        }
        return node;
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        //右旋转过程
        x.right = y;
        y.left = T3;

        //更新height值(新更新y的高度值)
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        //左旋转
        x.left = y;
        y.right = T2;

        //更新height值(新更新y的高度值)
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
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
        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left,key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            //e.compareTo(node.e) == 0;
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                //待删除节点左右子树都不为空的情况
                //调用minimum方法，寻找右子树中的最小节点
                Node successor = minimum(node.right);
                //removeMin操作中已经维护过size了
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode = successor;
            }
        }

        if (retNode == null) {
            return null;
        }

        //更新height
        retNode.height = Math.max(getHeight(retNode.left), getHeight(retNode.right)) + 1;
        //计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        if (Math.abs(balanceFactor) > 1) {
            //不是平衡二叉树了
            //System.out.println("unbalanced : " + balanceFactor);

            //平衡维护
            if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
                //产生不平衡的节点在左侧的左侧   LL
                //右旋转
                return rightRotate(retNode);
            } else if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
                // RR
                return leftRotate(retNode);
            } else if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
                //LR
                retNode.left = leftRotate(retNode.left);
                //转为了RR
                return rightRotate(retNode);
            } else if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
                //RL
                retNode.right = rightRotate(retNode.right);
                //转为了LL
                return leftRotate(retNode);
            }
        }
        return retNode;
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

    /**
     * 返回当前树是否为二分搜索树
     * @return
     */
    public boolean isBst(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历
     * @param node
     * @param keys
     */
    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }

    /**
     * 判断该二叉树是否为平衡二叉树
     * @return
     */
    public boolean isBalanced(){
        return isBalanced(root);
    }

    /**
     * 判断以node为根的二叉树是否为平衡二叉树
     * @param node
     * @return
     */
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
