package Circulating_bidirectional_linked_list;



/**
 * @author 小光
 * @date 2019/8/8 10:04
 * className: TestBidirectionLinkedList
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class TestLoopLinkedList {
    public static void main(String[] args) {
        LoopLinkedList<Integer> linkedList = new LoopLinkedList<>();

        //System.out.println(linkedList.contains(100));


        System.out.println(linkedList);
        linkedList.add(0,10);
        System.out.println(linkedList);

        //linkedList.removeFirst();
        //System.out.println(linkedList);

        for (int i = 2; i < 5; i++) {
            linkedList.add(1,i * 10);
            System.out.println(linkedList);
        }
        for (int i = 5; i < 8; i++) {
            linkedList.add(3, i * 10);
            System.out.println(linkedList);
        }

        linkedList.addFirst(80);
        System.out.println(linkedList);

        linkedList.addLast(90);
        System.out.println(linkedList);

        System.out.println(linkedList.get(5));
        System.out.println(linkedList.get(6));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println();

        System.out.println(linkedList.contains(100));
        linkedList.set(2,100);
        System.out.println(linkedList);
        System.out.println(linkedList.contains(100));

        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);

        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);

        System.out.println();

        linkedList.removeElement(10);
        System.out.println(linkedList);

        linkedList.removeElement(20);
        System.out.println(linkedList);
    }
}
