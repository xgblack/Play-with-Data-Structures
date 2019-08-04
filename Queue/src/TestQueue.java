import java.util.Random;

/**
 * @author 小光
 * @date 2019/7/27 19:54
 * className: Test
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class TestQueue {
    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue   time:" + time1);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue,opCount);
        System.out.println("LoopQueue   time:" + time2);

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue   time:" + time3);
    }

    private static double testQueue(Queue<Integer> q, int opCount) {
        long satrtTime = System.nanoTime();
        Random r = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(r.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();


        return (endTime - satrtTime) / 1000000000.0;
    }
}
