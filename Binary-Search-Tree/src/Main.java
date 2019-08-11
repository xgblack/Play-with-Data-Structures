/**
 * @author 小光
 * @date 2019/8/11 16:08
 * className: Main
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        int[] nums = {5, 3, 6, 8, 4, 2};



        for (int num : nums) {
            bst.add(num);
        }
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        System.out.println(bst);

        System.out.println(bst.contains(8));
        bst.preOrder();
        System.out.println("***********************");
        bst.preOrderNR();
        System.out.println("***********************");
        bst.inOrder();
        System.out.println("***********************");
        bst.postOrder();
        System.out.println("***********************");
        bst.levelOrder();
        System.out.println("***********************");

        System.out.println("=================================");

        System.out.println("删除最大值：" + bst.removeMax());
        System.out.println(bst);
        System.out.println("***********************");
        System.out.println("删除最小值：" + bst.removeMin());
        System.out.println(bst);
        System.out.println("***********************");
    }
}
