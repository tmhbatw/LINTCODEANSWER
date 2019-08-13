package LINTCODE8;

public class LINTCODE744 {
    /*Description
    *给一整数 k, 得出前 k 个偶数长度的回文数和. 这里的偶数长度是指一个数字的位数为偶数.
    * */

    public int sumKEven(int k) {
        int res=0;
        for(int i=1;i<=k;i++)
            res+=getNum(i);
        return res;
        //
    }

    private int getNum(int cur){
        String str=String.valueOf(cur);
        int length=str.length();
        StringBuffer sb=new StringBuffer(str).reverse();
        return (int) (cur*Math.pow(10,length)+Integer.parseInt(sb.toString()));
    }
}
