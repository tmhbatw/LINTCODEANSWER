package LINTCODE10;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE962 {
    /*Description
    *给定一个由小写字母a-f组成的字符串，对其进行删除，使得删除后的字符串满足：
    * 所有的a在c和e之前且所有的c在e之前
    * 所有的b在d和f之前且所有的d在f之前
    * 求删除后满足以上条件的串的最大长度
    * */

    //最长上升子序列
    public int conditionString(String s) {
        List<Character> aceList=new ArrayList<>();
        List<Character> bdfList=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            switch (cur){
                case 'a':
                case 'c':
                case 'e':
                    addChar(aceList,cur);
                    break;
                default:
                    addChar(bdfList,cur);
            }
        }
        return aceList.size()+bdfList.size();
        // write your code here
    }

    private void addChar(List<Character> list,char cur){
        if(list.isEmpty()||list.get(list.size()-1)<=cur)
            list.add(cur);
        else{
            int left=0,right=list.size()-1;
            while(left<=right){
                int mid=(left+right)/2;
                if(list.get(mid)>cur&&(mid==0||list.get(mid-1)<=cur)){
                    list.set(mid,cur);
                    break;
                }
                if(list.get(mid)>cur)
                    right=mid-1;
                else
                    left=mid+1;
            }
        }
    }
}
