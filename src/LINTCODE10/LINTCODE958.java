package LINTCODE10;

public class LINTCODE958 {
    /*Description
    * 一个数据流进来，每次一个字母，当前数据流的排列是否能组成回文串。
    * */

    public int[] getStream(String s) {
        int[] result=new int[s.length()];
        boolean[] flag=new boolean[26];
        for(int i=0;i<s.length();i++) {
            int index=s.charAt(i)-'a';
            flag[index]=!flag[index];
            if(isP(flag))
                result[i]=1;
            else
                result[i]=0;
        }
        return result;
        // Write your code here
    }

    private boolean isP(boolean[] cur){
        boolean flag=false;
        for(boolean curr:cur){
            if(curr&&flag)
                return false;
            if(curr)
                flag=true;
        }
        return true;
    }
}
