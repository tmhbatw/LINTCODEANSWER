package LINTCODE12;

public class LINTCODE1127 {
    /*Description
    *给定一个字符串s和一个字符串列表dict，你需要添加一对封闭的粗体标记 <b> 和 </b> 来包装dict中存在的s中的子串。
    * 如果两个这样的子串重叠，则需要通过一对封闭的粗体标记将它们包装在一起。此外，如果由粗体标记包装的两个子字符串是连续的，
    * 则需要将它们组合在一起。
    * */

    public String addBoldTag(String s, String[] dict) {
        int length=s.length();
        int[] time=new int[length+1];
        for(String cur:dict){
            int curLength=cur.length();
            int index=0;
            int appearIndex=s.indexOf(cur);
            while(appearIndex>=0){
                time[appearIndex]++;
                time[appearIndex+curLength]--;
                appearIndex=s.indexOf(cur,appearIndex+1);
            }
        }
        for(int i=1;i<length+1;i++){
            time[i]+=time[i-1];
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            if(time[i]==0)
                sb.append(s.charAt(i));
            else{
                sb.append("<b>").append(s.charAt(i));
                while(i<length-1&&time[i+1]>0){
                    i++;
                    sb.append(s.charAt(i));
                }
                sb.append("</b>");
            }
        }
        return sb.toString();
        // write your code here
    }

    public static void main(String[] args){
        String a="ababab";
        System.out.println(a.indexOf("ab"));
    }
}
