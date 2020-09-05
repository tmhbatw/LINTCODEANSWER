package LINTCODE17;

public class LINTCODE1649 {
    /*Description
    * 超人强和猪猪侠都进入了百米赛跑的决赛。猪猪侠的速度为v1,超人强的速度为v2,猪猪侠可以在比赛前吃至多一支超级棒棒糖，
    * 现在给定n种超级棒棒糖,第i种超级棒棒能让猪猪侠的速度提高si,而它的价格为wi.给定v1,v2,s,w,请问猪猪侠至少要花多少钱才能在百米赛跑中战胜超人强？
    * */

    public int getAns(int v1, int v2, int[] s, int[] w) {
        if(v1>v2)
            return 0;
        int diff=v2-v1;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<s.length;i++){
            if(s[i]>diff)
                result=Math.min(w[i],result);
        }
        return result;
        // Write your code here
    }
}
