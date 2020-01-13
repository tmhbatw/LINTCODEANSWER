package LINTCODE16;

public class LINTCODE1578 {
    /*Description
    * 给一个带有 B*A*C*D* 模式的字符串，* 意味着前面的字符在字符串中
    * 可以显示 0次 或 多次。计算字符 'A' 出现的次数。
    * */

    /*Solution
    * 二分法找到第一个和最后一个A
    * */

    public int countA(String s) {
        int first=-1;
        int left=0,right=s.length()-1;
        int mid;
        while(left<=right){
            mid=(left+right)/2;
            if(s.charAt(mid)=='A'&&(mid==0||s.charAt(mid-1)=='B')){
                first=mid;
                break;
            }
            if(s.charAt(mid)=='B')
                left=mid+1;
            else
                right=mid-1;

        }
        int last=-2;
        left=0;
        right=s.length()-1;
        while(left<=right){
            mid=(left+right)/2;
            if(s.charAt(mid)=='A'&&(mid==s.length()-1||s.charAt(mid+1)=='C')){
                last=mid;
                break;
            }
            if(s.charAt(mid)>='C'){
                right=mid-1;
            }else
                left=mid+1;
        }
        return last-first+1;
        // Write your code here
    }
}
