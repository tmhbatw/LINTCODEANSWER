package LINTCODE5;

import java.util.Stack;

public class LINTCODE421 {
    /*Description
    *给定一个文件的绝对路径(Unix-style)，请进行路径简化。
    * Unix中, . 表示当前目录, .. 表示父目录。
    * 结果必须以 / 开头，并且两个目录名之间有且只有一个 /。最后一个目录名(如果存在)后不能出现 / 。你需要保证结果是正确表示路径的最短的字符串。
    * */

    /*Solution
    * 试试将路劲放入队列里
    * */


    public String simplifyPath(String path) {
        String[] p=path.split("/");
        Stack<String> stack=new Stack<>();
        for(String curr:p){
            if(curr.equals("."))
                continue;
            if(curr.equals("..")){
                if(!stack.empty())
                    stack.pop();
            }
            stack.push(curr);
        }
        String result="";
        while(!stack.empty()){
            result="/"+stack.pop()+result;
        }
        return result;
        // write your code here
    }
}
