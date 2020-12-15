package LINTCODE19;

public class LINTCODE1889 {
    /*Description
    * 现在给你两个字符串区间(按字典顺序), 请你判断两个区间是否可以合并。
    * 字符串区间[a, b)，包括所有以a开头的字符串。
    * 例如，区间[a, b)和区间[ab,c)是可以合并的，区间[a,b)和区间[b, c]也是可以合并的。
    * 若是可以合并请返回true, 不可以请返回false。
    * */

    /*Solution
    * 注意一个特殊情况即（a,ab]与[aba,b)是可以合并的
    * */
    public boolean MergeJudge(String interval_A, String interval_B) {
        String[] A=interval_A.split(",");
        String[] B=interval_B.split(",");
        if(A[1].equals(B[1]))
            return true;
        if(compare(A[1],B[1])){
            String[] temp=A;
            A=B;
            B=temp;
        }
        String a=A[1].substring(0,A[1].length()-1);
        String b=B[0].substring(1);
        char c1=A[1].charAt(A[1].length()-1),c2=B[0].charAt(0);
        if(a.equals(b)){
            return c1==']'||c2=='[';
        }
        return compare(a,b)||c1==']'&&c2=='['&&b.equals(a+"a");
        //
    }

    //返回真值则证明前面的字母比后面的大
    public boolean compare(String cur1,String cur2){
        for(int i=0;i<cur1.length()&&i<cur2.length();i++){
            char c1=cur1.charAt(i),c2=cur2.charAt(i);
            if(c1<c2)
                return false;
            if(c1>c2)
                return true;
        }
        return cur1.length()>cur2.length();
    }
}
