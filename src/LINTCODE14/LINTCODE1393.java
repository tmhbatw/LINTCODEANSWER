package LINTCODE14;

import java.util.Arrays;

public class LINTCODE1393 {

    /*Description
    * 有些人会提出好友请求。 给定他们的年龄列表，其中age[i]是第i个人的年龄。
    * 如果满足以下任一条件，则A不会向B（B！= A）提出好友请求：
    * age[B] <= 0.5 * age[A] +7
    * age[B]>age[A]
    * age[B]> 100 && age[A] <100
    * 否则，A会向B发起好友请求.
    * 请注意，如果A请求B，B不一定请求A。此外，人们不会向自己发出好友请求。总共有多少好友请求被发出？
    * */

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int length=ages.length;
        int result=0;
        for(int i=0;i<length;i++){
            int time=1;
            int cur=ages[i];
            while(i<length-1&&ages[i+1]==cur){
                i++;
                time++;
            }
            int min= (int) (cur*0.5+7);
            if(min>=cur)
                continue;
            result+=time*(time-1);
            int right=i-time;
            if(right<0||ages[right]<=min)
                continue;
            int left=0;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(ages[mid]<=min){
                    left=mid+1;
                    continue;
                }
                if(mid==0||ages[mid-1]<=min){
                    left=mid;
                    break;
                }
                right=mid-1;
            }
            result+=(i-left-time+1)*time;
        }
        return result;
        //
    }
}
