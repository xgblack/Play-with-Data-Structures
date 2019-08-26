/**
 * @author 小光
 * @date 2019/8/26 22:56
 * className: TestTrie
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class TestTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("xgblack");
        trie.add("xg");
        trie.add("gmg");

        System.out.println(trie.getSize());
        System.out.println(trie.contains("xg"));
    }
}
