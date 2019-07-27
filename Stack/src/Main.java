/**
 * @author 小光
 * @date 2019/7/25 13:31
 * className: Main
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }


        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

    }
}
