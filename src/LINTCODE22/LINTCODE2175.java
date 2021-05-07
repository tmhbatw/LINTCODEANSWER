package LINTCODE22;

public class LINTCODE2175 {
    /*Description
    * 本题我们要编写代码实现对数组 array 中的正整数按照个位四舍五入，如果是负数和零就不做任何处理，最后返回这个四舍五入后的数组。
    * 本题在 Solution.java 中定义了一个 rounding 函数，使用 public 修饰代表可以被项目中所有类访问，
    * 返回值类型为 int 数组，传入的参数是一个 int 型数组。
    * */

    public int[] rounding(int[] array) {
        int[] result=new int[array.length];
        for(int i=0;i<array.length;i++)
            result[i]=getRound(array[i]);
        return result;
        // write your code here
    }

    private int getRound(int cur){
        if(cur<=0)
            return cur;
        int pre=cur/10*10;
        int last=(cur%10)>4?10:0;
        return pre+last;
    }
}
