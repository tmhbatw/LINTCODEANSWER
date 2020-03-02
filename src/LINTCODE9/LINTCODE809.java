package LINTCODE9;

public class LINTCODE809 {
    /*Description
    * 在第一行，我们写一个0。现在在之后的每一行，我们观察之前一行并且用01替换出现的1，用10替换出现的0。
    * 给出行号N和索引K，返回N行K-th索引的符号。(K的值为1-indexed)(1 indexed)。
    * */

    /*Description
    * 进行观察，对于每行第K个字符，如果K-1的二进制表示中有奇数个1时，返回1，如果有偶数个，返回0。
    * */

    public int kthGrammar(int N, int K) {
        K--;
        int result=0;
        for(int i=0;i<32;i++)
            result+=(K>>i)&1;
        return result%2==1?1:0;
        // Write your code here
    }
}
