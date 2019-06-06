package LINTCODE3;

public class LINTCODE204 {
    /*Description
    * 单例 是最为最常见的设计模式之一。对于任何时刻，如果某个类只存在且最多存在一个具体的实例，那么我们称这种设计模式为单例。
    * 例如，对于 class Mouse (不是动物的mouse哦)，我们应将其设计为 singleton 模式。你的任务是设计一个 getInstance 方法，对于
    * 给定的类，每次调用 getInstance 时，都可得到同一个实例。
    * */

    /*Solution
    * 静态方法调用这个类即可
    * 防止多线程可以引入synchronized
    * */

    private static LINTCODE204 s=new LINTCODE204();
    public static LINTCODE204 getInstance() {
        return s;
        // write your code here
    }
}
