/**
 * @author 小光
 * @date 2019/7/25 17:56
 * className: Student
 * description:
 * ***************************************************************************
 * Copyright(C),2018-2019,https://blog.xgblack.cn  .All rights reserved.
 * ***************************************************************************
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("xg",100));
        arr.addLast(new Student("lisi",66));
        arr.addLast(new Student("zhangsan",89));

        System.out.println(arr);
    }
}
