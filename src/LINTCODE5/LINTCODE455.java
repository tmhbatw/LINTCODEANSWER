package LINTCODE5;

public class LINTCODE455 {
    /*Description
    *实现一个名为Class的类，包含如下的一些属性和方法：
    * 一个public的students属性，是一个Student类的数组。
    * 一个构造函数，接受一个参数n，代表班级里有n个学生。构造函数需要创建n个学生的实例对象并放在students这个成员中，
    * 每个学生按照创建的顺序，学号需要依次标记为0, 1, 2 ... n-1
    * */

    class Student {
        public int id;

        public Student(int id) {
            this.id = id;
        }
    }


    public Student[] students;

    public LINTCODE455(int n){
        this.students=new Student[n];
        for(int i=0;i<n;i++){
            this.students[i]=new Student(i);
        }
    }

}
