package LINTCODE11;

public class LINTCODE1052 {
    /*Description
    * 从给定的字典（一个数组）中查找长度最小的单词，这个单词中需要包含字符串licensePlate中的所有字母。 这样的单词被称为能“拼成”licensePlate。
    * 在这里，对于字母我们忽略大小写。 例如，licensePlate上的“P”仍与单词上的“p”匹配。
    * 答案一定存在。 如果有多个答案，则返回数组中首先出现的答案。
    * licensePlate中可能会多次出现相同的字母。 例如，给定licensePlate为“PP”，单词“pair”不会“拼成”licensePlate，但单词“supper”会“拼成”。
    * */

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] num=new int[26];
        for(int i=0;i<licensePlate.length();i++){
            char cur=licensePlate.charAt(i);
            if(cur<='Z'&&cur>='A')
                num[cur-'A']++;
            if(cur<='z'&&cur>='a')
                num[cur-'a']++;
        }
        String result="";
        for(String cur:words){
            int[] curNum=new int[26];
            for(int i=0;i<cur.length();i++){
                char curr=cur.charAt(i);
                if(curr<='Z'&&curr>='A')
                    curNum[curr-'A']++;
                if(curr<='z'&&curr>='a')
                    curNum[curr-'a']++;
            }
            if(contains(num,curNum)){
                if(result.length()==0||result.length()>cur.length())
                    result=cur;
            }
        }
        return result;
        // write your code here
    }

    private boolean contains(int[] num,int[] curNum){
        for(int i=0;i<num.length;i++){
            if(num[i]>curNum[i])
                return false;
        }
        return true;
    }
}
