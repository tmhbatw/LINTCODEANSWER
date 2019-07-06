package LINTCODE5;

import datastructure.Rectangle;
import datastructure.Shape;
import datastructure.Square;
import datastructure.Triangle;

public class LINTCODE497 {

    /*Description
    * 工厂模式是一种常见的设计模式。实现一个形状工厂 ShapeFactory 来创建不同的形状类。
    * 这里我们假设只有三角形，正方形和矩形三种形状。
    * */
    public Shape getShape(String shapeType) {
        switch(shapeType){
            case "Square":
                return new Square();
            case "Triangle":
                return new Triangle();
            case "Rectangle":
                return new Rectangle();
        }
        return null;
        // Write your code here
    }
}
