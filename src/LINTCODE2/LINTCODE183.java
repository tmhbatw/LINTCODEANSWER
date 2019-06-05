package LINTCODE2;

import java.util.Arrays;

public class LINTCODE183 {
    /*Description
    * 有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。当然，我们希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度
    * */

    /*Solution
    * 首先获取木材的大致范围，即使得木材的长度恰好等于某一段原有木头的长度，获取木头长度的范围
    * 然后缩小范围获取一个要求的具体的值
    * */
    public int woodCut(int[] L, int k) {
        if(L.length==0)
            return 0;
        Arrays.sort(L);
        System.out.println(Arrays.toString(L));
        int cou=1;
        for(int i=1;i<L.length;i++){
            cou+=L[i]/L[0];
        }
        if(cou<k){
            int  l=0;
            int r=L[0];
            while(l<r){
                int mid=l+(r-l+1)/2;
                int count=0;
                for(int i=0;i<L.length;i++){
                    count+=L[i]/mid;
                }
                if(count<k)
                    r=mid-1;
                else{
                    l=mid;
                }
            }
            return l;
        }
        //获取最大长度的大致范围
        int left = 0, right = L.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int count = 1;
            //以L[count]的大小为每一段木头的长度，判断最多能切出几段木头
            for (int i = mid + 1; i < L.length - 1; i++) {
                count += L[i] / L[mid];
            }
            System.out.println(count+"  "+L[mid]);
            if (count < k)
                right = mid - 1;
            else
                left = mid;
        }
        //精确获取木头的具体长度
        int l = L[left];
        int r = L[left + 1];

        while(l<r){
            int mid=l+(r-l+1)/2;
            int count=0;
            for(int i=left+1;i<L.length;i++){
                count+=L[i]/mid;
            }
            if(count<k)
                r=mid-1;
            else{
                l=mid;
            }
        }
        return l;
        // write your code here
    }
}
