package LINTCODE17;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LINTCODE1632 {
    /*Description
    * 给定一个n个邮件地址字符串的数组.
    * 求出电子邮件组的数量，每个组应具有多个电子邮件地址（地址可以重复）。如果两个字符串在转换后具有相同的值，则它们位于同一组中。
    * 邮件地址处理时遵循以下规则:
    * 在字符`'@'之前忽略所有的字符 '.'.
    * 在字符`'@'之前忽略字符 '+'以及它后面的所有子字符串.
    * */

    public int countGroups(List<String> emails) {
        Set<String> set=new HashSet<>();
        Set<String> result=new HashSet<>();
        for(String cur:emails){
            String[] email=cur.split("@");
            String[] s=email[0].split("\\.");
            StringBuilder sb=new StringBuilder(email[1]);
            boolean flag=false;
            for(String curr:s){
                if(flag)
                    break;
                for(int i=0;i<curr.length();i++){
                    if(curr.charAt(i)=='+'){
                        flag=true;
                        break;
                    }
                    sb.append(curr.charAt(i));
                }
            }
            System.out.println(sb.toString());
            if(set.contains(sb.toString())){
                result.add(sb.toString());
            }
            set.add(sb.toString());
        }
        return result.size();
        // Write your code here
    }
}
