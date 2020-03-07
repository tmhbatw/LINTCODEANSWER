package LINTCODE3;

public class LINTCODE218 {
    /*Description
    * 实现一个学生的类 Student. 包含如下的成员函数和方法：
    * 两个公有成员 name 和 score。分别是字符串类型和整数类型。
    * 一个构造函数，接受一个参数 name。
    * 一个公有成员函数 getLevel() 返回学生的成绩等级（一个字符）。
    * 等级表如下：
    * A: score >= 90
    * B: score >= 80 and < 90
    * C: score >= 60 and < 80
    * D: score < 60
    * */

    class Student {
        /**
         * Declare two public attributes name(string) and score(int).
         */
        String name;
        int score;

        /**
         * Declare a constructor expect a name as a parameter.
         */
        public Student(String name){
            this.name=name;
        }

        /**
         * Declare a public method `getLevel` to get the level(char) of this student.
         */
        public char getLevel(){
            if(score>=90)
                return 'A';
            if(score>=80)
                return 'B';
            if(score>=60)
                return 'C';
            return 'D';
        }
    }
}
