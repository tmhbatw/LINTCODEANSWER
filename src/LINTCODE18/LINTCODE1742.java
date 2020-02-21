package LINTCODE18;

public class LINTCODE1742 {
    /*Description
    给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。
    在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在字符串的末尾。
    返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。
    * */

    public String orderlyQueue(String S, int K) {
        if(K>1){
            StringBuilder sb=new StringBuilder();
            int[] time=new int[26];
            for(int i=0;i<S.length();i++){
                time[S.charAt(i)-'a']++;
            }
            for(int i=0;i<time.length;i++){
                for(int j=0;j<time[i];j++){
                    sb.append((char)(i+'a'));
                }
            }
            return sb.toString();
        }
        String result=S;
        for(int i=1;i<S.length();i++){
            String cur=S.substring(i)+S.substring(0,i);
            System.out.println(cur+" "+cur.compareTo(result));
            if(cur.compareTo(result)==-1)
                result=cur;
        }
        return result;
        // Write your code here.
    }
}
