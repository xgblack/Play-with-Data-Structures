import java.util.ArrayList;

/**
 * @author 小光
 * @date 2019/8/16 16:58
 * className: TestLinkedListMap
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class TestLinkedListMap {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("Map/src/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();

            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word,1);
                }
            }
            System.out.println("Total different words: " + map.getsize());
            System.out.println("Frequency of PRIDE : " + map.get("pride"));
            System.out.println("Frequency of prejudice : " + map.get("prejudice"));
        }
    }
}
