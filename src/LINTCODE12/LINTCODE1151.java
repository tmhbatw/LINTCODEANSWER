package LINTCODE12;

import java.util.Arrays;
import java.util.Stack;

public class LINTCODE1151 {
    /*Description
    *
    * */

    String special="<![CDATA[";
    String specialEnd="]>";
    public boolean isValid(String code) {
        boolean[] skip=new boolean[code.length()];
        int start=-1;
        while((start=code.indexOf(special,start+1))!=-1){
            int end=code.indexOf(specialEnd,start+1);
            if(end==-1)
                return false;
            for(int i=start;i<end+2;i++){
                skip[i]=true;
            }
        }

        Stack<String> s=new Stack<>();
        int length = code.length();

        for(int i=0;i<length;i++){
            if(skip[i])
                continue;
            if(s.isEmpty()&&code.charAt(i)!='<')
                return false;
            if(code.charAt(i)=='<'){
                if(i==length-1)
                    return false;
                if(code.charAt(i+1)=='/'){
                    i++;
                    int cur=i+1;
                    boolean end=true;
                    while(i<length-1&&end){
                        char c=code.charAt(++i);
                        if(c=='>'){
                            end=false;
                        }
                        else if(c>'Z'||c<'A')
                            return false;
                    }
                    if(end)
                        return false;
                    String tag_name=code.substring(cur,i);
                    System.out.println(s);
                    if(s.isEmpty()||!s.peek().equals(tag_name))
                        return false;
                    s.pop();
                }else{
                    int cur=i+1;
                    boolean end=true;
                    while(i<length-1&&end){
                        char c=code.charAt(++i);
                        if(c=='>'){
                            end=false;
                        }
                        else if(c>'Z'||c<'A')
                            return false;
                    }
                    if(end)
                        return false;
                    String tag_name=code.substring(cur,i);
                    if(tag_name.length()>9||tag_name.length()<=0)
                        return false;
                    s.add(tag_name);
                }
            }
        }
        return s.isEmpty();
        // Write your code here
    }

    public static void main(String[] args){
        String t="abc";
        System.out.println(t.indexOf("a",-1));
    }
}
