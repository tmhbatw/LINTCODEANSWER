package LINTCODE7;

public class LINTCODE645 {
    /*Description
    * 假设你和 n 个人在一个聚会中(标记为 0 到 n - 1)，其中可能存在一个名人。名人的定义是所有其他 n - 1 人都认识他/她，但他/她不知道任何一个。
    * 现在你想要找出这个名人是谁或者验证这个名人不存在。你唯一可以做的事情就是提出如下问题：“你好，A，你认识B吗？” 来获取A是否认识B。
    * 您需要通过询问尽可能少的问题(以渐近的意义)来找出名人是谁(或验证其不存在)。
    * 你得到一个辅助函数 bool know(a，b)，它会告诉你A是否知道B.实现一个函数 int findCelebrity(n)，你的函数应该使 knows 的调用次数最少。
    * */

    boolean knows(int a, int b){
        return true;
    };

    public int findCelebrity(int n) {
        int famous=0;
        for(int i=0;i<n;i++){
            if(knows(famous,i))
                famous=i;
        }
        for(int i=0;i<n;i++){
            if(i!=famous&&(knows(famous,i)||!knows(i,famous)))
                return -1;
        }
        return famous;
        // Write your code here
    }
}
