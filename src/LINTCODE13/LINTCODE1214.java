package LINTCODE13;

public class LINTCODE1214 {
    /*Description
    * 给定一个用字符串S表示的许可证，其中仅仅包含了数字、字母和短横线。字符串被N个短横线“-”切分为了N+1组。
    * 给定一个数字K，要求重新整理字符串的格式，使得除了第一组之外的每个组正好K个字符，第一组长度可以比K小，
    * 但也至少要包含一个字符。此外，对于两个组之间必须要插入一个短横线，所有的小写字母都要转换为大写字母。
    * */

    public String licenseKeyFormatting(String S, int K) {
        int length=0;
        StringBuilder cur= new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)!='-') {
                length++;
                char curr=S.charAt(i);
                if(curr<='z'&&curr>='a')
                    curr=(char)(curr-32);
                cur.append(curr);
            }
        }
        int start=length%K;
        StringBuilder result=new StringBuilder();
        for(int i=0;i<start;i++){
            result.append(cur.charAt(i));
        }
        for(int i=start;i<length;i+=K){
            result.append('-');
            for(int j=0;j<K;j++){
                result.append(cur.charAt(i+j));
           }
        }
        if(result.charAt(0)=='-')
            return result.substring(1).toString();
        return result.toString();
        // write your code here
    }
}
