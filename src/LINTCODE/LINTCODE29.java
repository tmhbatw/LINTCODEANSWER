package LINTCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE29 {

    /*Description
    * Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
    * */

    /*Solution
    * 可以使用暴力遍历出所有的结果，看结果集中是否含有目标字符串
    * 暴力遍历可以进行简化，即将一定不符合的情况的遍历情况省去
    * */


//暴力遍历简化版
        public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length()) {
            return false;
        }
        List<String> list=new ArrayList<>();
        String[] s={s1,s2};
        recursion(list,s,s3,0);
        return !list.isEmpty();
    }

    private void recursion(List<String> result,String[] s,String target,int num){
            if(s[1].length()==0||s[0].length()==0){
                if((s[0]+s[1]).equals(target.substring(num,target.length()))){
                    result.add(target);
                }
            }
            if(!result.isEmpty()){
                return;
            }
            //当s1.s2都含有目标字符串的当前字符时进行遍历，其他情况则只有唯一固定解
            if(s[0].charAt(0)==target.charAt(num)&&s[1].charAt(0)==target.charAt(num)){
                for(int i=0;i<s.length;i++)
                    recursion(result,change(s,i),target,num+1);
            }else if(s[0].charAt(0)==target.charAt(num)){
                recursion(result,change(s,0),target,num+1);
            }else if(s[1].charAt(0)==target.charAt(num)){
                recursion(result,change(s,1),target,num+1);
            }
    }
        private String[] change(String[] s,int i){
        String[] ss=Arrays.copyOf(s,2);
        ss[i]=ss[i].substring(1,ss[i].length());
        return ss;
    }



    //下为暴力遍历s1、s2可能构成的所有String情况，判断是否存在s3情况
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if(s3.length()!=s1.length()+s2.length()){
//            return false;
//        }
//        List<String> result=new ArrayList<>();
//        String res="";
//        String[] s={s1,s2};
//        recursion(result,res,s);
//        return result.contains(s3);
//    }
//    public void recursion(List<String> result,String res,String[] s){
//        if(s[0].length()==0|| s[1].length()==0){
//            res+=s[0]+s[1];
//            result.add(res);
//            return;
//        }
//        for(int i=0;i<s.length;i++){
//            recursion(result,res+s[i].charAt(0),change(s,i));
//        }
//    }
//    private String[] change(String[] s,int i){
//        String[] ss=Arrays.copyOf(s,2);
//        ss[i]=ss[i].substring(1,ss[i].length());
//        return ss;
//    }

}
