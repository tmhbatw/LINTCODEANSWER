package LINTCODE20;

import java.util.List;

public class LINTCODE1902 {
    /*Description
    *给您一个字符串形式的C ++文件（每行是一个字符串），我们希望您在注释行中找到“ Google”。如果注释行中有“ Google”，则返回true，否则返回false。
    C++有两种注释方式，一种是单行注释 //，代表着//后面的本行内容均为注释，另一种是多行注释，/*和 这两者之间的部分均为注释。
     */

    public boolean FindGoogle(List<String> S) {
        String target="Google";
        boolean flag=false;
        for(String cur:S){
            int annotationIndex=cur.indexOf("//");
            if(annotationIndex!=-1&&cur.indexOf(target,annotationIndex)!=-1)
                return true;
            if(cur.contains("/*")&&annotationIndex==-1||cur.indexOf("/*")<annotationIndex)
                flag=true;
            if(flag){
                int targetIndex=cur.indexOf(target);
                if(targetIndex!=-1)
                    return true;
            }
            if(cur.contains("*/"))
                flag=false;
        }
        return false;
        // Write your code here.
    }

    public static void main(String[] args){
        String source="abcdef";
        int annotationIndex=source.indexOf("abd");
        System.out.println(annotationIndex);
        System.out.println(source.indexOf("abc",annotationIndex));
    }
}
