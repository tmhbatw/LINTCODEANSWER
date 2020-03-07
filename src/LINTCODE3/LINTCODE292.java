package LINTCODE3;

import java.util.Arrays;
import java.util.Comparator;

public class LINTCODE292 {
    /*Description
    * 编写一个方法来对字符串数组进行排序，以使所有字符串彼此相邻，并且按照重构之后的顺序来排序，且重构之后相同的字符串应该保持与相对位置不变
    * */

    public String[] SortAnagramsArray(String[] str) {
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int[] oo1=getTime(o1);
                int[] oo2=getTime(o2);
                int length=0;
                int o1Length=o1.length();
                int o2Length=o2.length();
                for(int i=0;i<26;i++){
                    if(oo1[i]!=oo2[i]) {
                        if(length+oo1[i]==o1Length&&oo1[i]<oo2[i])
                            return -1;
                        if(length+oo2[i]==o2Length&&oo2[i]<oo1[i])
                            return 1;
                        return oo2[i] - oo1[i];
                    }
                    length+=oo1[i];
                    if(length==o1Length&&length==o2Length)
                        return 0;
                    if(length==o1Length)
                        return -1;
                    if(length==o2Length)
                        return +1;
                }
                return 0;
            }
        });
        return str;
        // write your code here
    }

    private int[] getTime(String cur){
        int[] res=new int[26];
        for(int i=0;i<cur.length();i++){
            res[cur.charAt(i)-'a']++;
        }
        return res;
    }



}
