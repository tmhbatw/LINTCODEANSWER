package LINTCODE5;

public class LINTCODE454 {
    /*Description
    * 实现一个矩阵类Rectangle，包含如下的一些成员变量与函数：
    * 两个共有的成员变量 width 和 height 分别代表宽度和高度。
    * 一个构造函数，接受2个参数 width 和 height 来设定矩阵的宽度和高度。
    * 一个成员函数 getArea，返回这个矩阵的面积。
    * */

    /*Solution
    * 构建对象问题
    * */
    int width;
    int height;
    public LINTCODE454(int width,int height){
        this.width=width;
        this.height=height;
    }

    public int getArea(){
        return width*height;
    }
}
