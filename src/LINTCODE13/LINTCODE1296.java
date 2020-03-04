package LINTCODE13;

public class LINTCODE1296 {
    /*Description
    * 给定一个字符串数组words，找length(word[i]) * length(word[j])的最大值，
    * 而且要保证这两个单词没有共同字符。假定每一个单词都仅有小写字符组成。如果没有这样的两个单词，则返回0。
    * */

    public int maxProduct(String[] words) {
        int result=0;
        for(int i=0;i<words.length;i++){
            int[] nums1=getNum(words[i]);
            for(int j=i+1;j<words.length;j++){
                int curRes=words[i].length()*words[j].length();
                if(curRes<result)
                    continue;
                int[] nums2=getNum(words[j]);
                if(isSame(nums1,nums2))
                    result=Math.max(result,curRes);
            }
        }
        return result;
        // Write your code here
    }

    private boolean isSame(int[] nums1,int[] nums2){
        for(int i=0;i<26;i++)
            if(nums1[i]!=0&&nums2[i]!=0)
                return false;
        return true;
    }

    private int[] getNum(String cur){
        int[] times=new int[26];
        for(int i=0;i<cur.length();i++)
            times[cur.charAt(i)-'a']++;
        return times;
    }
}
