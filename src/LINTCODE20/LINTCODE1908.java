package LINTCODE20;

public class LINTCODE1908 {
    /*Description
    * 给定一个字符串代表一个仅包含"true","false","or","and"的布尔表达式。
    * 你的任务是将这个表达式的值求出，返回"true"或"false"。
    * 如果该表达式是错误的，则返回"error"。
    * */

    public String evaluation(String expression) {
        String[] expr=expression.split(" ");
        int size=expr.length;
        for(int i=0;i<size;i+=2) {
            if (!isTrueOrFalse(expr[i]))
                return "error";
        }
        for(int i=1;i<size;i+=2){
            if(!isAndOrOr(expr[i]))
                return "error";
        }
        boolean result=false;
        int start=0;
        for(int i=1;i<size;i+=2){
            if(expr[i].equals("or")){
                result|=function(expr,start,i-1);
                if(result)
                    return "true";
                start=i+1;
            }
        }
        return function(expr,start,size-1)?"true":"false";
        // write your code here
    }

    private boolean function(String[] expr,int start,int end){
        for(int i=start;i<=end;i+=2){
            if(expr[i].equals("false"))
                return false;
        }
        return true;
    }

    private boolean isTrueOrFalse(String cur){
        if(cur.equals("true")||cur.equals("false"))
            return true;
        return false;
    }

    private boolean isAndOrOr(String cur){
        if(cur.equals("and")||cur.equals("or"))
            return true;
        return false;
    }
}
