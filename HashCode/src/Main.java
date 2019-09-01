/**
 * @author 小光
 * @date 2019/9/1 22:51
 * className: Main
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class Main {
    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer) a).hashCode());

        int b = -42;
        System.out.println(((Integer) b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "xgblack";
        System.out.println(d.hashCode());

        Student student = new Student(3, 2, "xg", "gmg");
        System.out.println(student.hashCode());
    }
}
