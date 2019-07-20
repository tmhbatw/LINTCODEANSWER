package NOWCODER;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class yizhandaodi_8 {
    /*Description
    *圣诞节临近，彩虹岛的黑心商人𝑐𝑡𝑟的糖果店又开始热闹了起来，热心的𝑠𝑙𝑝来到𝑐𝑡𝑟的店里面帮忙包装糖果。店里面共有𝑛堆糖果，其中第𝑖堆有𝑎𝑖颗糖果，
    * 𝑐𝑡𝑟让𝑠𝑙𝑝从中选择两堆糖果，这两堆糖果中每𝑝 颗包装在一起，如果最后还有剩余就归𝑠𝑙𝑝所有了，若两堆不足𝑝个则全部归𝑠𝑙𝑝所有。
    * 作为糖果狂热爱好者，𝑠𝑙𝑝当然是想拿走尽量多的糖果，因此他想知道自己最多能够拿走多少糖果。
    * 输入描述:
    * 输入第一行为一个整数𝑇(1 ≤ 𝑇 ≤ 10)，表示一共有𝑇组测试数据。对于每组测试数据：第一行有两个整数𝑛(2 ≤ 𝑛 ≤ 105), 𝑝(1 ≤ 𝑝 ≤ 109)，
    * 分别表示糖果堆数和包装后每包糖果的数量。第二行有𝑛个整数，其中第𝑖个数𝑎𝑖(1 ≤ 𝑎𝑖 ≤ 109)表示第𝑖堆糖果的数量。
    * 输出描述:
    * 对于每组测试数据，输出一个整数𝑥表示𝑠𝑙𝑝能拿走的最多的糖果数目。
    * */
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        int[] res=new int[T];
        for(int i=0;i<T;i++){
            int n=s.nextInt();
            int p=s.nextInt();
            int[] nums=new int[n];
            for(int j=0;j<n;j++){
                int cur=s.nextInt();
                nums[j]=cur%p;
            }
            Arrays.sort(nums);
            int max=Integer.MIN_VALUE;
            int last=nums[n-1];
            for(int j=0;j<n-1;j++){
                int curr=nums[j]+last;
                if(curr<p){
                    max=Math.max(max,curr);
                    continue;
                }
                max=Math.max(max,curr-p);
                max=Math.max(max,nums[j]+getMax(nums,j+1,n-2,p-nums[j]));
            }
            res[i]=max;
        }
        for(int cur:res){
            System.out.println(cur);
        }
    }

    private static int getMax(int[] num,int start,int end,int target){
        if(start>end)
            return -target;
        int mid=start+(end-start)/2;
        if(num[mid]<target&&num[mid+1]>=target)
            return num[mid];
        else if(num[mid+1]<target)
            return getMax(num,mid+1,end,target);
        else{
            return getMax(num,start,mid-1,target);
        }

    }
}
