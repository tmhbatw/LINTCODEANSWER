package LINTCODE18;

public class LINTCODE1741 {
    /*Description
    * 编写一个遍历游程编码序列的迭代器.
    * 迭代器由 RLEIterator(int[] A) 初始化, 其中 A 是某个序列的游程编码. 更具体地, 对于所有偶数 i，A[i] 告诉我们在序列中非负整数值 A[i + 1] 重复连续出现的次数.
    * 迭代器支持一个函数 next(int n), 它取出接下来的 n 个元素（n >= 1）并返回取出来的最后一个元素. 如果剩余元素以及不足 n 个, 则再取完所有元素后返回 -1.
    * 例如, A = [3, 8, 0, 9, 2, 5]，这是序列 [8, 8, 8, 5, 5] 的游程编码. A 可以读作 "三个八, 零个九, 两个五".
    * */

    class Solution {
        int[] num;
        int index;
        int length;
        public Solution(int[] A) {
            num=A;
            length=A.length;
            index=0;
            // do some initialization if necessary
        }

        /**
         * @param n: the number of elements to exhaust
         * @return: exhausts the next n elements and returns the last element exhausted
         */
        public int next(int n) {
            if(index>=length) {
                return -1;
            }
            if(num[index]==n){
                index+=2;
                return num[index-1];
            }
            if(num[index]>n){
                num[index]-=n;
                return num[index+1];
            }
            else {
                index += 2;
                return next(n - num[index - 2]);
            }
            // write your code here
        }
    }
}
