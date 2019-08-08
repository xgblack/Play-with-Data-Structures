package Bidirectional_linked_list;

/**
 * @author 小光
 * @date 2019/8/8 10:04
 * className: TestBidirectionLinkedList
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class TestBidirectionLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0,9);
        System.out.println(linkedList);

        for (int i = 0; i < 5; i++) {
            linkedList.add(0,i);
            System.out.println(linkedList);
        }
        for (int i = 0; i < 3; i++) {
            linkedList.add(3,100 + i);
            System.out.println(linkedList);
        }

        linkedList.addFirst(99);
        System.out.println(linkedList);

        linkedList.addLast(999);
        System.out.println(linkedList);

        System.out.println(linkedList.get(5));
        System.out.println(linkedList.get(6));
        System.out.println(linkedList.getFirst());
        System.out.println();

        System.out.println(linkedList.contains(88));
        linkedList.set(2,88);
        System.out.println(linkedList);
        System.out.println(linkedList.contains(88));

        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);

        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);

        System.out.println();

        linkedList.removeElement(9);
        System.out.println(linkedList);

        linkedList.removeElement(2);
        System.out.println(linkedList);
    }
}
