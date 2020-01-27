package LINTCODE13;

public class LINTCODE1209 {
    /*Description
    * 对于一个Web开发者,如何设计页面大小很重要。所以，给定一个矩形大小,设计其长（L）宽（W），使其满足如下要求:
    * 1. 矩形区域大小需要和给定目标相等。
    * 2. 宽度W不大于长度L，也即L >= W.
    * 3. 长和宽的差异尽可能的小。
    * 返回设计好的长度 L和宽度 W。
    * */

    public int[] constructRectangle(int area) {
        int[] res=new int[2];
        for(int i = (int) Math.sqrt(area); i>=1; i--){
            if(area%i==0){
                res[1]=i;
                res[0]=area/i;
                break;
            }
        }
        return res;
        // Write your code here
    }
}
