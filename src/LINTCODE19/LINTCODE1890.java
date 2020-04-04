package LINTCODE19;

public class LINTCODE1890 {
    /*Description
    *给定一个仅包含I和D的模式串str。 I代表相邻项增加，D代表相邻项减少。
    * 设计一种算法，返回符合该模式且字典序最小的字符串。字符串只包含1到9且不能重复。
    * */

    public String formMinimumNumber(String str) {
        if(str==null||str.length()==0)
            return "";
        StringBuilder sb=new StringBuilder();
        int length=str.length();
        for(int i=0;i<=length;i++)
            sb.append(" ");
        int count=1;
        for(int i=0;i<=length;i++){
            if(i==length||str.charAt(i)=='I'){
                for(int j=i-1;j>=-1;j--){
                    sb.setCharAt(j+1,(char)('0'+count++));
                    if(j>=0&&str.charAt(j)=='I')
                        break;
                }
            }
        }
        return sb.toString();
        // Write your code here.
    }
}
