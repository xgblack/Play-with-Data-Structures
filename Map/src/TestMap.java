import java.util.ArrayList;

/**
 * @author 小光
 * @date 2019/8/16 18:20
 * className: TestMap
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class TestMap {
    private static double testMap(Map<String, Integer> map, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word,1);
                }
            }
            System.out.println("Total different words: " + map.getsize());
            System.out.println("Frequency of PRIDE : " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE : " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
        String filename = "Map/src/pride-and-prejudice.txt";
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, filename);

        System.out.println("************************************************");

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);

        System.out.println("BSTMap:" + time1);
        System.out.println("LinkedListMap:" + time2);
    }
}
/*
Map/src/pride-and-prejudice.txt
Total words: 125901
Total different words: 6530
Frequency of PRIDE : 53
Frequency of PREJUDICE : 11
************************************************
Map/src/pride-and-prejudice.txt
Total words: 125901
Total different words: 6530
Frequency of PRIDE : 53
Frequency of PREJUDICE : 11
BSTMap:0.216803
LinkedListMap:15.5431947
 */