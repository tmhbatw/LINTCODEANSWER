package LINTCODE2;

public class LINTCODE182 {
    /*Description
    * 给出一个字符串 A, 表示一个 n 位正整数, 删除其中 k 位数字, 使得剩余的数字仍然按照原来的顺序排列产生一个新的正整数。
    * 找到删除 k 个数字之后的最小正整数。
    * */

    /*Solution
    * 因为要获得最小的正整数，那么一定要从结果的左端开始做文章
    * 删除k个数，那么最多可以影响到前K+1个数，获取前K+1个数中最小的那个数，一定是我们所求的结果的第一位
    * 第一位之前的数应该全部被删掉，一共删掉了k-i+1个数
    * 递归即可
    * */

    public String DeleteDigits(String A, int k) {
        return delete(change(A,k));
        // write your code here
    }

    private String change(String s,int k){
        if(s.length()==k)
            return "";
        if(k==0)
            return s;
        int index=0;
        for(int i=1;i<=k;i++){
            if(s.charAt(i)<s.charAt(index))
                index=i;
        }
        return s.charAt(index)+change(s.substring(index+1,s.length()),k-index);
    }

    private String delete(String s){
        while(s.length()>0&&s.charAt(0)=='0')
            s=s.substring(1,s.length());
        return s;
    }

}
