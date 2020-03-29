package LINTCODE19;

public class LINTCODE1876 {
    /*Description
    * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
    * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
    * */

    public boolean isAlienSorted(String[] words, String order) {
        int[] ord=new int[26];
        for(int i=0;i<26;i++){
            ord[order.charAt(i)-'a']=i;
        }
        for(int i=1;i<words.length;i++){
            if(words[i].equals(words[i-1]))
                continue;
            if(!fixed(words[i-1],words[i],ord))
                return false;
        }
        return true;
        //
    }

    private boolean fixed(String first,String second,int[] ord){
        int length1= first.length();
        int length2=second.length();
        for(int i=0;i<length1&&i<length2;i++){
            char cur1=first.charAt(i);
            char cur2=second.charAt(i);
            if(cur1!=cur2)
                return ord[cur1-'a']<ord[cur2-'a'];
        }
        return length1<length2;
    }
}
