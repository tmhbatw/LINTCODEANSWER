package LINTCODE12;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1166 {
    /*Description
    * 某个推荐系统会推荐出一个由视频和图片元素组成的列表。x 表示元素编号，视频用 V_x 表示，图片用 P_x 表示。现在需要对这些元素进行打散，打散规则如下：
    * 第一个[图片P]出现的位置不变；
    * 从第一个[图片P]后开始，每 n 个元素里面恰好出现1个[图片P]；
    * 图片之间的相对顺序不变；
    * 不能满足打散规则的元素需要舍去。给出元素列表和 n 的值，请返回打散后的元素列表。
    * */

    public List<String> scatter(List<String> elements, int n) {
        List<String> result=new ArrayList<>();
        List<String> picture=new ArrayList<>();
        for(String cur:elements){
            if(cur.charAt(0)=='P')
                picture.add(cur);
        }
        int index=0;
        int size=elements.size();
        for(;index<size;index++){
            String cur=elements.get(index);
            result.add(cur);
            if(cur.charAt(0)=='P')
                break;
        }
        int index1=1;
        int size1=picture.size();
        for(int i=index+1;i<size;i++){
            int curViewTime=n-1;
            while(curViewTime!=0){
                if(i==size)
                    return result;
                String cur=elements.get(i);
                if(cur.charAt(0)!='P') {
                    result.add(cur);
                    curViewTime--;
                }
                i++;
            }
            if(index1==size1)
                return result;
            result.add(picture.get(index1++));
            i--;
        }
        return result;
        // write your code here
    }
}
