import java.util.ArrayList;

/**
 * @author 小光
 * @date 2019/8/30 10:39
 * className: Test
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Price and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {

            //最坏的情况
            //Collections.sort(words);

            //test BST
            long startTime = System.nanoTime();

            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if (bst.contains(word)) {
                    bst.set(word, bst.get(word) + 1);
                } else {
                    bst.add(word, 1);
                }
            }
            for (String word : words) {
                bst.contains(word);
            }

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST : " + time);

            //test AVLTree
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word)) {
                    avl.set(word, avl.get(word) + 1);
                } else {
                    avl.add(word, 1);
                }
            }
            for (String word : words) {
                avl.contains(word);
            }

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVLTree : " + time);


            //test RBTree
            startTime = System.nanoTime();

            RBTree<String, Integer> rbTree = new RBTree<>();
            for (String word : words) {
                if (rbTree.contains(word)) {
                    rbTree.set(word, rbTree.get(word) + 1);
                } else {
                    rbTree.add(word, 1);
                }
            }
            for (String word : words) {
                rbTree.contains(word);
            }

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree : " + time);


            //test HashTable
            startTime = System.nanoTime();

            HashTable<String, Integer> hashTable = new HashTable<>();
            for (String word : words) {
                if (hashTable.contains(word)) {
                    hashTable.set(word, hashTable.get(word) + 1);
                } else {
                    hashTable.add(word, 1);
                }
            }
            for (String word : words) {
                hashTable.contains(word);
            }

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable : " + time);

        }
    }
}
/*
Price and Prejudice
BST : 0.7638771
AVLTree : 0.2414138
RBTree : 0.1244483
HashTable : 0.1151775
 */