package LINTCODE13;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1223 {
    /*Description
    * 字符串s是由字符串"abcdefghijklmnopqrstuvwxyz"无限重复环绕形成的，所以s看起来像是这样：
    * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...."。
    * 现在有另一个字符串p。你的任务是找出p中有多少互不相同的非空子串出现在s中。确切的说，你得到字符串p作为输入，
    * 你需要输出关于p非空子串的数目，这些子串互不相同，并且能在s中被找到。
    * */

    public int findSubstringInWraproundString(String p) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<26;i++){
            map.put((char)(i+'a'),0);
        }
        int length=p.length();
        for(int i=0;i<length;i++){
            char cur=p.charAt(i);
            char start=cur;
            int time=1;
            while(i<length-1&&getNext(cur)==p.charAt(i+1)){
                cur=getNext(cur);
                i++;
                time++;
            }
            int max=26;
            cur=start;
            while(time-->0&&max-->0){
                map.put(cur,Math.max(map.get(cur),time+1));
                cur=getNext(cur);
            }
        }
        int result=0;
        for(Map.Entry entry:map.entrySet())
            result+=(int)entry.getValue();
        //  System.out.println(map);
        return result;
        // Write your code here
    }

    private char getNext(char cur){
        if(cur=='z')
            return 'a';
        return (char)(cur+1);
    }
}
