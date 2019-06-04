package LINTCODE2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE171 {
    /*Desciption
    * Given an array of strings, return all groups of strings that are anagrams.
    * */

    /*Solution
    * 当然可以字符串进行排序然后进行比较，可是会超时
    * 那么我们选择用一个数组来保存字符串每个字符的信息，如果数组完全相同那么证明两个字符串相似，可以输出(空间复杂度超了）
    * 优化一下算法发现所有匹配的字符全是小写，那么可以创建一个26位数组，完成
    * */


    public List<String> anagrams(String[] strs) {
        List<String> result=new ArrayList<>();
        //因为要删除已经确定重复的字符串以减少重复次数，因此将原有的字符串输出到一个list中
        List<String> s=new ArrayList<>();
        for(String ss:strs)
            s.add(ss);
        for(int i=0;i<s.size();i++){
            String cur=s.get(i);
            //用一个数组存储每一个字符出现的次数
            int[] num=new int[26];
            int[] nums;
            for(int m=0;m<cur.length();m++){
                num[cur.charAt(m)-'a']++;
            }
            for(int j=s.size()-1;j>i;j--){
                String curr=s.get(j);
                if(curr.length()!=cur.length())
                    continue;
                nums=new int[26];
                boolean con=false;
                for(int n=0;n<curr.length();n++){
                    if(nums[curr.charAt(n)-'a']>=num[curr.charAt(n)-'a']) {
                        con=true;
                        break;
                    }
                    nums[curr.charAt(n)-'a']++;
                }
                if(!con) {
                    if(result.indexOf(cur)==-1)
                        result.add(s.get(i));
                    result.add(s.get(j));
                    s.remove(j);
                }
            }
        }
        return result;
    }

    //排序字符串的算法
    /*    public List<String> anagrams(String[] strs) {
        List<String> result=new ArrayList<>();
        List<String> s=new ArrayList<>();
        for(String ss:strs)
            s.add(ss);
        for(int i=0;i<s.size();i++){
            String curr=sort(s.get(i));
            for(int j=s.size()-1;j>i;j--){
                if(sort(s.get(j)).equals(curr)){
                    if(result.indexOf(s.get(i))==-1){
                        result.add(s.get(i));
                    }
                    result.add(s.get(j));
                    s.remove(j);
                }
            }
        }
        return result;   // write your code here
    }

    private String sort(String s){
        char[] c=s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }*/
}
