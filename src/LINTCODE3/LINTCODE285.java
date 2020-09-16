package LINTCODE3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LINTCODE285 {
    /*Description
    *小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行，楼高用arr表示。
    * 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？
    * （当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
    * */

    public int[] tallBuilding(int[] arr) {
        int length=arr.length;
        Stack<Integer> next=new Stack<>();
        int[] nextTime=new int[length];
        for(int i=length-1;i>=0;i--){
            nextTime[i]=next.size();
            while(!next.isEmpty()&&next.peek()<=arr[i])
                next.pop();
            next.add(arr[i]);
        }
        Stack<Integer> pre=new Stack<>();
        int[] result=new int[length];
        for(int i=0;i<length;i++){
            result[i]=pre.size()+nextTime[i]+1;
            while(!pre.isEmpty()&&pre.peek()<=arr[i]){
                pre.pop();
            }
            pre.add(arr[i]);
        }
        return result;
        // Write your code here.
    }
}
