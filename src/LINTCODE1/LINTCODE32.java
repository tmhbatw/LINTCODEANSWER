package LINTCODE1;

public class LINTCODE32 {
    /*Description
    * 给定一个字符串source和一个目标字符串target，在字符串source中找到包括所有目标字符串字母的最短子串。
    * */

    /*Solution
    * 以两个128位数组储存s与t中每个字符出现的次数（以每个字符ASCII值作为数组的下标）
    * 设置start与end值作为当前遍历的源字符串的开始和结束位置，通过比较与t数组的结果，判断start是否能右移
    * end继续右移以遍历整个字符串
    * 下为超越99.8%解法
    * */

    public String minWindow(String source , String target) {
        int[] t=new int[128];//用来保存target字符串每个字符出现的次数
        int[] s=new int[128];//用来保存当前处理的从start至end的源字符串中每个相关字符出现的次数
        int num=0;//保存已经配对成功的字符数
        int start=0,end=0;
        int min=source.length()+1;
        String result="";
        //将target字符存储在数组t中
        for(int i=0;i<target.length();i++)
            t[target.charAt(i)]++;

        for(;end<source.length();end++){
            num=s[source.charAt(end)]<t[source.charAt(end)]?num+1:num;
            s[source.charAt(end)]++;
            //当完全匹配后，即num=target.size()时，进行start左移判断；
            if(num==target.length()){
                while(t[source.charAt(start)]<s[source.charAt(start)]){
                    s[source.charAt(start)]--;
                    start++;
                }
                if(min>end-start+1){
                    min=end-start+1;
                    result=source.substring(start,end+1);
                }

            }
        }
        return result;
    }
}
