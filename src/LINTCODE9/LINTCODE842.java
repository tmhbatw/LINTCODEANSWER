package LINTCODE9;

public class LINTCODE842 {
    /*Description
    * 折纸，每次都是将纸从右向左对折，凹痕为 0，凸痕为 1，求折 n 次后，将纸展开所得折痕组成的 01 序列。
    * */

    public String getString(int n) {
        StringBuilder result=new StringBuilder("0");
        if(n==1)
            return result.toString();
        for(int i=2;i<=n;i++)
            result=recursion(result);
        return result.toString();
        // Write your code here
    }

    private StringBuilder recursion(StringBuilder cur){
        StringBuilder result=new StringBuilder(cur);
        cur.reverse();
        result.append("0");
        for(int i=0;i<cur.length();i++)
            result.append(cur.charAt(i)=='0'?'1':'0');
        return result;
    }
}
