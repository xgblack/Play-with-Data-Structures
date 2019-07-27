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
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(50);
        System.out.println(queue);

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 0) {
                queue.dequeue();
                System.out.println(queue);
            }

        }

    }
}
