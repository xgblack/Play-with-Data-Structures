import java.util.ArrayList;

/**
 * @author 小光
 * @date 2019/8/13 16:36
 * className: TestLinkedListSet
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class TestLinkedListSet {
    public static void main(String[] args) {
        System.out.println("Price and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        //D:\Code\IdeaJava\Play-with-Data-Structures\Set\src\pride-and-prejudice.txt
        FileOperation.readFile("Set/src/pride-and-prejudice.txt", words1);
        System.out.println("Total words:" + words1.size());

        LinkedListSet<String> set = new LinkedListSet<>();
        for (String word : words1) {
            set.add(word);
        }

        System.out.println("Total different words:" + set.getSize());

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        //D:\Code\IdeaJava\Play-with-Data-Structures\Set\src\pride-and-prejudice.txt
        FileOperation.readFile("Set/src/a-tale-of-two-cities.txt", words2);
        System.out.println("Total words:" + words2.size());

        LinkedListSet<String> set2 = new LinkedListSet<>();
        for (String word : words2) {
            set2.add(word);
        }

        System.out.println("Total different words:" + set2.getSize());
    }
}
/*
Price and Prejudice
Total words:125901
Total different words:6530
A Tale of Two Cities
Total words:141489
Total different words:9944
 */