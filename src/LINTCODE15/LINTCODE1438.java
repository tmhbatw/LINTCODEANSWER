package LINTCODE15;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1438 {
    /*Description
    * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
    * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy"这样的一些分组。
    * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
    * 最终结果按照字典顺序输出。
    * */

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<S.length()-2;i++){
            if(S.charAt(i)==S.charAt(i+1)&&S.charAt(i+1)==S.charAt(i+2)){
                List<Integer> res=new ArrayList<>();
                res.add(i);
                int end=i+3;
                while(end<S.length()&&S.charAt(end)==S.charAt(i)){
                    end++;
                }
                res.add(end-1);
                i=end;
                result.add(res);
            }
        }
        return result;
        // Write your code here
    }
}
