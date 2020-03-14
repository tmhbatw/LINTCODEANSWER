package LINTCODE11;

public class LINTCODE1025 {
    /*Description
    * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
    * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
    * 返回任意一种符合条件的字符串T。
    * */

    public String customSortString(String S, String T) {
        int[] num=new int[26];
        for(int i=0;i<T.length();i++){
            num[T.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<S.length();i++){
            int index=S.charAt(i)-'a';
            while(num[index]>0){
                sb.append((char)(index+'a'));
                num[index]--;
            }
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<num[i];j++)
                sb.append((char)(i+'a'));
        }
        return sb.toString();
        // Write your code here
    }
}
