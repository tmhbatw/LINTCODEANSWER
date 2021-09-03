package LINTCODE18;

import java.util.*;

public class LINTCODE1778 {
    /*Description
    * 给定有n个整数的数组 A。您可以将任意下标 i 作为起点开始跳跃。
    * 其中的第1次，第3次，第5次 ......跳跃称为奇数跳跃，第2次，第4次，第6次 ......跳跃称为偶数跳跃。
    * 在奇数跳跃（第1，3，5...次跳跃）时，您可以从 i 跳跃到 j 的前提是：A[j] 在 A[i] 右侧（i < j）
    * 并且 A[j] 是大于等于 A[i] 的最小值。
    * 在偶数跳跃（第2，4，6...次跳跃）时，您可以从 i 跳跃到 j 的前提是：A[j] 在 A[i] 右侧（i < j）
    * 并且 A[j] 是小于等于 A[i] 的最大值。
    * 如果 j 存在多个，您只能跳跃到最小的 j。
    * 如果不存在任何的 j，则你不能继续跳跃。
    * 如果某个下标开始，您可以通过若干次跳跃（可以是 0 次）到达数组的末尾（下标 n - 1），那么这是一个合法的起始下标。
    * 对于所有下标（0-(n-1)），您需要统计合法起始下标的个数并返回。
    * */

    public int oddEvenJumps(int[] A) {
        int length=A.length;
        int[] odd = new int[length];
        int[] even= new int[length];
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int j=length-1;j>=0;j--){
            Integer big=map.ceilingKey(A[j]);
            if(big!=null)
                odd[j]=map.get(big);
            Integer small=map.floorKey(A[j]);
            if(small!=null)
                even[j]=map.get(small);
            map.put(A[j],j);
        }
        Set<Integer> result=new HashSet<>();
        Set<Integer> evenResult=new HashSet<>();
        boolean[] oddReached=new boolean[length];
        boolean[] evenReached=new boolean[length];
        oddReached[length-1]=true;
        evenReached[length-1]=true;
        result.add(length-1);
        evenResult.add(length-1);
        for(int i=0;i<A.length-1;i++){
            if(oddReached[i])
                continue;
            List<Integer> list=new ArrayList<>();
            List<Integer> evenList=new ArrayList<>();
            int time=0;
            int cur=i;
            while(true){
                time++;
                if(time%2==1){
                    list.add(cur);
                    oddReached[cur]=true;
                }else{
                    evenList.add(cur);
                    evenReached[cur]=true;
                }
                int next=time%2==1?odd[cur]:even[cur];
                cur=next;

                if(next==0||(time%2==1&&evenReached[next])||(time%2==0&&oddReached[next]))
                    break;
            }
            if(cur==0)
                continue;
            if(time%2==0&&result.contains(cur)||time%2==1&&evenResult.contains(cur)){
                result.addAll(list);
                evenResult.addAll(evenList);
            }
        }
        return result.size();
    }
}
