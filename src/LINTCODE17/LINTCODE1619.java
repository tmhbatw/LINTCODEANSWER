package LINTCODE17;

public class LINTCODE1619 {
    /*Description
    * 有N个孩子站在一排。每个孩子都有一个评分值。
    * 你给予这些儿童糖果，必须符合下列规定:
    * 每个孩子必须至少有一颗糖果。
    * -得分高的孩子比他们的邻居得到更多的糖果。
    * -评级相同、相邻的孩子得到相同的糖果。
    * 你至少要给多少糖果?
    * */

    public int candyII(int[] ratings) {
        if(ratings==null||ratings.length==0)
            return 0;
        int length=ratings.length;
        int[] dp1=new int[length];
        dp1[0]=1;
        for(int i=1;i<length;i++){
            if(ratings[i]>ratings[i-1]){
                dp1[i]=dp1[i-1]+1;
            }else if(ratings[i]==ratings[i-1])
                dp1[i]=dp1[i-1];
            else
                dp1[i]=1;
        }
        int[] dp2=new int[length];
        dp2[length-1]=1;
        for(int i=length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                dp2[i]=dp2[i+1]+1;
            }else if(ratings[i]==ratings[i+1])
                dp2[i]=dp2[i+1];
            else
                dp2[i]=1;
        }
        int result=0;
        for(int i=0;i<length;i++)
            result+=Math.max(dp1[i],dp2[i]);
        return result;
        // Write your code here
    }
}
