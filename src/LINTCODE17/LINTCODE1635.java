package LINTCODE17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE1635 {
    /*Description
    * 给两个数组，给一个最大值，在这两个数组里各找一个组成一对，求其和最接近最大值，但不大于最大值的所有数对。
    * */

    public int[][] getAns(int[] a, int[] b, int x) {
        int aLength=a.length;
        int bLength=b.length;
        Arrays.sort(a);
        Arrays.sort(b);
        List<int[]> result=new ArrayList<>();
        int max=0;
        for(int i=0;i<aLength;i++){
            int cur=a[i];
            if(cur+b[0]>x)
                break;
            int left=0,right=bLength-1;
            int target=x-cur;
            int mid=0;
            while(left<=right){
                mid=left+(right-left)/2;
                if(b[mid]==target||b[mid]<target&&(mid==bLength-1||b[mid+1]>target))
                    break;
                if(b[mid]>target)
                    right=mid-1;
                else
                    left=mid+1;
            }
            int curMax=cur+b[mid];
            if(curMax<max)
                continue;
            if(curMax>max){
                max=curMax;
                result=new ArrayList<>();
            }
            result.add(new int[]{a[i],b[mid]});
        }
        int[][] res=new int[result.size()][2];
        for(int i=0;i<result.size();i++)
            res[i]=result.get(i);
        return res;
        // Write your code here.
    }
}
