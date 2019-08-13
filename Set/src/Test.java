import java.util.ArrayList;

/**
 * @author 小光
 * @date 2019/8/13 17:04
 * className: Test
 * description: 测试性能
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class Test {
    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();
        System.out.println(filename);

        ArrayList<String> words = new ArrayList<>();
        //D:\Code\IdeaJava\Play-with-Data-Structures\Set\src\pride-and-prejudice.txt
        FileOperation.readFile(filename, words);
        System.out.println("Total words:" + words.size());

        for (String word : words) {
            set.add(word);
        }

        System.out.println("Total different words:" + set.getSize());
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
        String filename = "Set/src/pride-and-prejudice.txt";
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BSTSet : " + time1 + "s");

        System.out.println("************************");

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);

        System.out.println("LinkedListSet : " + time2 + "s");
    }
}
