package LINTCODE8;

public class LINTCODE734 {
    /*Description
    * 给一字符串, 对形式为 a^i b^j c^k 的子序列进行计数, 即它由 i 个字符 a, 接着是 j 个字符 b,
    * 然后是 k 个字符 c组成, i >= 1, j >= 1, k >= 1.
    * Note: 如果两个子序列在原字符串中的index集合是不同的，则认为两个子序列不同。
    * */


    public int countSubsequences(String source) {
        int counta=0,countb=0,countc=0;
        for(int i=0;i<source.length();i++){
            char cur=source.charAt(i);
            switch(cur){
                case 'a':
                    counta=counta*2+1;
                    break;
                case 'b':
                    countb=counta+countb*2;
                    break;
                case 'c':
                    countc=countb+countc+countc;
            }
        }
        return countc;
    }

    public static void main(String[] args){
        String a="abbc";

    }

}
