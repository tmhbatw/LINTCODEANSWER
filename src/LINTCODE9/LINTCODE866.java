package LINTCODE9;

import LINTCODE12.LINTCODE1171;

import java.util.*;

public class LINTCODE866 {
    /*Description
    * 给出一个数组由N个整数A1，A2，...，AN 组成的数组A （下标从1开始），
    * 和一个整数B。这个整数B表示，在数组A 中，从任意位置（假设数组下标为i）
    * 可以跳到以数组A 中i+1，i+2，…，i+B为下标的任何一个位置，只要你可以跳到数组A 中的这个位置。
    * 并且，如果你站在下标为i的位置上，你需要付Ai个硬币。如果Ai是-1，表示不能跳到数组中下标为i 的位置。
    * 现在，从数组A中下标为1的位置开始，你需要付最少的硬币，到达下标为N的位置。
    * 返回支付最少硬币到达下标N的路径（从1开始直到N），用数组表示。
    * 如果存在相同花费的多条路径，返回字典序最小的路径。
    * 如果不能够到达下标N的位置，那么返回一个空的数组。
    * */

    public List cheapestJump(int[] A, int B) {
        if(B==0)
            return Collections.emptyList();
        int[] res=new int[A.length];
        res[0]=-1;
        Deque<int[]> deque=new ArrayDeque<>();
        deque.addLast(new int[]{0,A[0]});

        for(int i=1;i<A.length;i++){
            if(deque.isEmpty())
                return Collections.emptyList();
            if(i-deque.peekFirst()[0]>B)
                deque.pollFirst();
            if(A[i]==-1)
                continue;
            if(deque.isEmpty())
                return Collections.emptyList();
            int[] cur=deque.peekFirst();
            res[i]=cur[0];
            int val=A[i]+cur[1];
            if(A[i]==0){
                deque=new ArrayDeque<>();
            }else {
                while (!deque.isEmpty() && (deque.peekLast()[1] > val || deque.peekLast()[1] == val && judge(deque.peekLast()[0],i, res)))
                    deque.pollLast();
            }
            deque.add(new int[]{i,val});
        }
        List<Integer> list=new ArrayList<>();
        int cur=A.length-1;
        while(cur!=-1){
            list.add(cur+1);
            cur=res[cur];
        }
        Collections.reverse(list);
        return list;
        // write your code here
    }

    private boolean judge(int i, int j, int[] res){
        // System.out.println(i+" "+j);
        List<Integer> l1=new ArrayList<>();
        while(i!=0){
            l1.add(i);
            i=res[i];
        }
        List<Integer> l2=new ArrayList<>();
        while(j!=0){
            l2.add(j);
            j=res[j];
        }
        Collections.reverse(l1);
        Collections.reverse(l2);
        for(int k=0;k<Math.min(l1.size(),l2.size());k++){
            if(l2.get(k)<l1.get(k))
                return true;
            if(l1.get(k)<l2.get(k))
                return false;
        }
        return l2.size()>l1.size();
    }

    public static void main(String[] args){
        int[] num=new int[]{0,0,0,0,0};
        int B=3;
        System.out.println(new LINTCODE866().cheapestJump(num,B));

        String test="[56,91,77,27,92,87,22,77,99,39,66,12,91,47,3,58,8,73,15,24,67,86,97,20,9,28,43,10,30,3,54,78,67,22,77,53,41,3,86,-1,7,74,49,91,77,80,81,52,32,81,48,83,32,88,6,61,34,27,91,20,38,4,16,60,60,42,5,97,6,74,50,62,74,87,41,39,1,69,73,88,15,12,0,22,77,71,65,71,73,17,60,2,91,43,82,90,20,4,81,35,9,36,4,27,25,14,83,42,3,65,59,62,67,48,97,86,51,79,41,87,44,74,33,15,66,38,100,75,32,10,77,52,34,39,57,4,96,97,98,35,4,6,61,93,73,11,11,43,100,92,82,12,69,68,52,22,82,43,11,12,82,62,75,56,81,19,35,97,92,62,66,8,67,65,94,35,92,53,57,47,77,49,70,20,93,95,35,41,43,48,35,20,3,2,89,64,9,97,60,40,46,97,51,56,39,46,96,13,88,68,50,76,51,76,64,70,35,21,37,15,45,1,26,78,62,6,15,44,23,49,73,95,44,50,72,50,34,93,19,42,46,50,66,86,4,31,40,91,46,90,44,20,71,90,13,34,17,91,83,17,60,16,34,7,71,1,81,41,80,5,68,78,82,67,35,40,8,61,44,24,70,10,74,61,64,29,70,77,61,42,-1,12,96,78,50,71,86,51,34,62,40,48,59,91,33,31,47,56,98,46,40,86,83,22,75,18,85,78,61,11,29,53,85,58,46,14,97,15,-1,18,50,97,17,67,58,46,40,7,97,77,91,77,63,74,7,30,78,4,78,99,100,88,65,83,86,64,90,25,65,64,52,24,-1,31,3,44,72,75,44,79,61,-1,50,29,42,59,96,93,48,86,31,17,64,15,31,64,83,18,94,39,97,30,4,35,38,35,3,24,4,73,59,1,75,82,74,38,77,1,46,36,31,79,18,70,6,27,48,28,66,89,12,47,49,47,98,67,53,28,86,33,5,1,3,57,4,49,99,-1,34,27,89,37,55,84,75,76,74,44,5,29,79,69,41,-1,51,61,43,30,36,36,28,61,91,18,21,47,75,67,99,20,79,3,21,46,28,77,26,91,78,27,49,95,49,61,85,9,74,84,84,88,14,39,28,2,96,17,30,97,66,46,89,68,65,17,26,58,69,13,63,81,28,56,97,20,36,43,12,74,36,73,59,19,97,69,17,96,2,11,75,3,39,56,18,15,21,92,6,16,50,55,8,97,3,27,41,57,6,22,35,20,23,22,36,7,71,86,93,4,13,3,24,40,41,44,4,78,45,19,41,40,27,38,5,48,79,51,81,20,32,37,73,45,42,22,8,31,59,83,87,9,22,40,52,22,22,62,76,76,77,60,87,17,39,7,31,84,18,83,36,80,20,25,34,47,43,0,96,39,41,1,98,-1,45,6,78,93,94,89,97,66,25,87,73,61,29,33,79,84,36,64,55,100,6,59,45,14,71,28,64,30,27,20,86,75,92,56,100,63,17,32,21,39,98,67,8,4,1,67,76,90,91,59,8,40,61,9,39,45,92,18,35,1,36,37,76,67,13,6,40,70,18,6,97,-1,16,8,77,82,13,36,92,78,4,18,74,90,85,80,68,69,88,74,56,47,41,86,54,97,87,98,25,22,26,28,99,35,1,61,34,21,7,77,57,86,0,87,98,52,85,51,42,30,64,88,71,5,26,75,22,93,1,25,80,27,79,17,0,67,68,38,67,1,81,74,94,8,70,23,4,10,3,83,66,83,18,99,3,19,55,96,20,95,75,90,28,89,69,24,9,53,97,-1,35,-1,87,18,6,82,20,32,49,17,89,13,51,62,69,6,53,74,48,12,23,2,9,97,47,32,22,27,72,61,39,67,-1,87,65,32,20,45,84,29,29,99,68,88,2,41,3,35,41,77,33,25,99,26,35,98,39,9,73,83,20,95,71,5,99,32,7,63,43,77,81,25,77,76,28,-1,86,4,54,15,69,12,20,60,98,10,46,10,8,66,85,1,30,15,58,21,42,7,69,12,47,89,7,71,92,20,65,27,79,45,97,26,62,86,3,45,89,11,34,47,7,21,5,76,60,49,34,37,71,26,79,90,18,4,0,58,4,77,76,-1,75,93,0,62,97,47,4,65,1,43,59,80,92,94,64,47,61,53,57,42,72,29,27,2,33,6,95,46,20,35,96,25,81,82,9,4,49,73,7,31,56,6,50,52,65,47,21,65,18,45,1,16,88,0,65,43,53,39,38,34,97,86,38,66,14,13,31,7]\n" +
                "79";
    }
}
