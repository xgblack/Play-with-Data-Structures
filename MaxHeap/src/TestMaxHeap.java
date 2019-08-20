import java.util.Random;

/**
 * @author 小光
 * @date 2019/8/18 18:00
 * className: Main
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class TestMaxHeap {
    public static void main(String[] args) {
        /*int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        //System.out.println(maxHeap.size());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");*/
        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < testData.length; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, true);

        double time2 = testHeap(testData, false);
        System.out.println("with Heapify :" + time1);
        System.out.println("without Heapify :" + time2);
    }

    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (Integer num : testData) {
                maxHeap.add(num);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");
        return (endTime - startTime) / 1000000000.0;
    }
}
