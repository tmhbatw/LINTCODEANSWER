package LINTCODE15;

public class LINTCODE1499 {
    /*Description
    *给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
    * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
    * */

    public boolean reorderedPowerOf2(int N) {
        int length=String.valueOf(N).length();
        int[] n=getNum(N);
        int num=1;
        while(String.valueOf(num).length()<length){
            num*=2;
        }
        while(String.valueOf(num).length()==length){
            if(isSame(n,getNum(num)))
                return true;
            num*=2;
        }
        return false;
        // write your code here
    }

    private boolean isSame(int[] num1,int[] num2){
        for(int i=0;i<num1.length;i++)
            if(num1[i]!=num2[i])
                return false;
        return true;
    }

    private int[] getNum(int n){
        String cur=String.valueOf(n);
        int[] res=new int[10];
        for(int i=0;i<cur.length();i++)
            res[cur.charAt(i)-'0']++;
        return res;
    }
}
