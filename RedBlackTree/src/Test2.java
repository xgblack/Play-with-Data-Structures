import java.util.ArrayList;
import java.util.Random;

/**
 * @author 小光
 * @date 2019/9/1 16:32
 * className: Test2
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class Test2 {
    public static void main(String[] args) {
        int n = 20000000;

        Random random = new Random();
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(random.nextInt(Integer.MAX_VALUE));
        }


        // Test BST
        long startTime = System.nanoTime();

        BST<Integer, Integer> bst = new BST<>();
        for (Integer x: testData) {
            bst.add(x, null);
        }

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST: " + time + " s");


        // Test AVL
        startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x: testData) {
            avl.add(x, null);
        }

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");


        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x: testData) {
            rbt.add(x, null);
        }

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");
    }
}
