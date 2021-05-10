package LINTCODE23;

public class LINTCODE2268 {
    /*Description
    * 请你在 Cow 类的 // write your code here 下编写合适的代码，实现在非静态内部类对外部成员的直接访问。
    * 本题我们在 Main.java 中已经写好了对 Cow 对象的属性的赋值和 printInfo 方法的调用，在 Cow 类有 weight 属性、
    * CowLeg 内部类和 printInfo 方法，CowLeg 内部类有 color 属性、 height 属性和 info 方法 ，
    * 其中 weight 属性表示牛的重量，color 属性表示牛身颜色，height 属性表示牛的高度，printInfo 方法用于创建 CowLeg 对象，
    * 并调用该对象中 info 方法，info 方法用来打印牛属性。
    * 要求：在外部类 Cow 中创建一个内部类 CowLeg，并在该类中定义实例变量 float height 和 String color，
    * 创建一个实例方法 info，在该方法中使用 System.out.println() 对动物牛属性进行打印。
    * */

    public class Cow {
        /**
         * @param weight: weight The weight of a cow represents
         * @methods PrintInfo: The PrintInfo method creates the
         * object and calls the methods in it
         */
        private float weight;

        public Cow(float weight) {
            this.weight = weight;
        }

        //  Non-static internal classes
        // write your code here
        public void printInfo(float height, String color) {
            CowLeg c1 = new CowLeg(height, color);
            c1.info();
        }

        private class CowLeg{
            float height;
            String color;
            public CowLeg(float height,String color){
                this.height=height;
                this.color=color;
            }
            public void info(){
                System.out.println("The color of the cow is: "+this.color);
                System.out.println("The height of the cow is: "+this.height);
                System.out.println("The weight of the cow is: "+weight);
            }
        }
    }

}
