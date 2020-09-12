package LINTCODE18;

import java.util.Arrays;

public class LINTCODE1736 {
    /*Description
    * 现在有n个垃圾袋，每个垃圾袋的重量，在[1.01 , 3.00]磅之间。
    * 出去扔垃圾一次最多能带3.00磅的垃圾。
    * 题目给出所有垃圾袋的重量，请问最少扔几次可以将所有垃圾扔完
    * */

    public int Count_ThrowTimes(float[] BagList) {
        float max=3.0f;
        Arrays.sort(BagList);
        int length=BagList.length;
        int left=0,right=length-1;
        int result=0;
        while(left<=right){
            if(left==right)
                return result+1;
            if(BagList[left]+BagList[right]<=max){
                left++;
                right--;
                result++;
            }else{
                right--;
                result++;
            }
        }
        return result;
        //
    }
}
