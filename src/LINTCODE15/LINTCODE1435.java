package LINTCODE15;

import java.util.*;

public class LINTCODE1435 {
    /*Description
    *对于某些字符串 S，我们将执行一些替换操作，用新的字母组替换原有的字母组（不一定大小相同）。
    * 每个替换操作具有 3 个参数：起始索引 i，源字 x 和目标字 y。规则是如果 x 从原始字符串 S 中的位置 i 开始，那么我们将用 y 替换出现的 x。如果没有，我们什么都不做。
    * 举个例子，如果我们有 S = “abcd” 并且我们有一些替换操作 i = 2，x = “cd”，y = “ffff”，那么因为 “cd” 从原始字符串 S 中的位置 2 开始，我们将用 “ffff” 替换它。
    * 再来看 S = “abcd” 上的另一个例子，如果我们有替换操作i = 0，x = “ab”，y = “eee”，以及另一个替换操作 i = 2，x = “ec”，y = “ffff”，那么第二个操作将不执行任何操作，因为原始字符串中 S[2] = 'c'，与 x[0] = 'e' 不匹配。
    * 所有这些操作同时发生。保证在替换时不会有任何重叠： S = "abc", indexes = [0, 1], sources = ["ab","bc"] 不是有效的测试用例。
    * */

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<String[]> list=new ArrayList<>();
        for(int i=0;i<indexes.length;i++){
            list.add(new String[]{String.valueOf(indexes[i]),sources[i],targets[i]});
        }
        Collections.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int oo1=Integer.parseInt(o1[0]);
                int oo2=Integer.parseInt(o2[0]);
                return oo2-oo1;
            }
        });
        for(int i=0;i<list.size();i++){
            String[] cur=list.get(i);
            int index=Integer.parseInt(cur[0]);
            String source=cur[1];
            String target=cur[2];
            String curr=S.substring(index,index+source.length());
            if(curr.equals(source)) {
                S = S.substring(0, index) + target + S.substring(index+source.length());
            }
        }
        return S;
        // Write your code here.
    }
}
