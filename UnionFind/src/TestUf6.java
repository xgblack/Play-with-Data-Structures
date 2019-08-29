/**
 * @author 小光
 * @date 2019/8/29 20:36
 * className: TestUf6
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class TestUf6 {
    public static void main(String[] args) {
        UF uf = new UnionFind6(5);
        uf.unionElements(3,4);
        uf.unionElements(0,3);
        uf.unionElements(1,2);
        uf.unionElements(1,3);

        uf.isConnected(0, 4);
    }
}
