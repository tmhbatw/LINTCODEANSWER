package LINTCODE23;

public class LINTCODE2278 {
    /*Description
    * 请在类名为 Solution 中的 accessInnerProp 方法中编写你的代码。
    * 本题我们在 Main.java 中已经写好了对 Solution 对象的创建和 accessInnerProp 方法的调用。
    * 在 Solution 类中有三个 String 类型全局变量 prop1、prop2、prop3 分别用来接收传进来的参数。
    * 在 staticInnerClass 静态内部类中把接收的参数分别赋值给静态变量 studentName 和实例变量 studentId、studentCourse。
    * 要求：请在 accessInnerProp() 成员方法编写代码，实现对 staticInnerClass 静态内部类中成员变量的访问，按要求打印出学生信息。
    * */

    public static class Solution {
        /**
         *
         * @param prop1,prop2,prop3: prop1,prop2,prop3 are global
         * variables used to receive student information
         * @class staticInnerClass: staticInnerClass is a static internal class that
         * contains information about the student
         */
        private static String prop1;
        private static String prop2;
        private static String prop3;

        public Solution() {
        }

        public Solution(String prop1, String prop2, String prop3) {
            this.prop1 = prop1;
            this.prop2 = prop2;
            this.prop3 = prop3;
        }

        public void accessInnerProp() {
            staticInnerClass s=new staticInnerClass();
            System.out.println("studentName:"+s.studentName);
            System.out.println("studentId:"+s.studentId);
            System.out.println("studentCourse:"+s.studentCourse);
            // write your code here
        }

        static class staticInnerClass {
            private String studentName = prop1;
            private String studentId = prop2;
            private String studentCourse = prop3;

        }
    }
}
