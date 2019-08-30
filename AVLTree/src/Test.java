import java.util.ArrayList;
import java.util.Collections;

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
        if (FileOperation.readFile("AVLTree/src/pride-and-prejudice.txt", words)) {

            //最坏的情况
            Collections.sort(words);

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

        }
    }
}
