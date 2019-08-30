import java.util.ArrayList;

/**
 * @author 小光
 * @date 2019/8/30 9:03
 * className: Test
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class TestAVLTree {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("AVLTree/src/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> avlTree = new AVLTree<>();

            for (String word : words) {
                if (avlTree.contains(word)) {
                    avlTree.set(word, avlTree.get(word) + 1);
                } else {
                    avlTree.add(word,1);
                }
            }
            System.out.println("Total different words: " + avlTree.getsize());
            System.out.println("Frequency of PRIDE : " + avlTree.get("pride"));
            System.out.println("Frequency of PREJUDICE : " + avlTree.get("prejudice"));

            System.out.println("is Bst : " + avlTree.isBst());
            System.out.println("is Balanced : " + avlTree.isBalanced());


            for (String word : words) {
                avlTree.remove(word);
                if (!avlTree.isBalanced() || !avlTree.isBst()) {
                    throw new RuntimeException("error");
                }
            }
            System.out.println("ok!");
        }
    }
}
