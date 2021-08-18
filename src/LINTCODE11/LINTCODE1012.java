package LINTCODE11;

import java.util.Arrays;

public class LINTCODE1012 {
    /*Description
    * 给定的整数数组 A ，我们要将 A数组 中的每个元素移动到 B数组 或者 C数组中。（B数组和C数组在开始的时候都为空）
    * 返回true ，当且仅当在我们的完成这样的移动后，可使得B数组的平均值和C数组的平均值相等，并且B数组和C数组都不为空
    * */

    double target;
    boolean result = false;
    int maxLength=0;

    public boolean splitArraySameAverage(int[] A) {
        Arrays.sort(A);
        target = Arrays.stream(A).sum()*1.0/A.length;

        for(int i=A.length/2;i>=1;i--){
            if(isSame(target*i,Math.floor(target*i+0.6))){
                maxLength=i;
                break;
            }
        }

        dfs(0,0,A,0);
        return result;
        // write your code here
    }

    private void dfs(int sum,int time, int[] A,int index){
        if(result||time>maxLength)
            return;
        if(time>0&&time<A.length) {
            double curTarget=sum*1.0/time;
            if(isSame(curTarget,target)){
                result=true;
                return;
            }
        }
        for(int i=index;i<A.length;i++){
            dfs(sum+A[i],time+1,A,i+1);
        }
    }

    private boolean isSame(double a, double b){
        double max=Math.max(a,b);
        double min=Math.min(a,b);
        return max-min<=0.000001;
    }

    public static void main(String[] args){
       // int[] res=new int[]{293,155,976,136,50,413,707,533,984,683,582,511,756,178,527,254,124,240,184,949,135,339,331,99,187,809,40,823,423,610};
        int[] res=new int[]{5,3,11,19,2};
        System.out.println(new LINTCODE1012().splitArraySameAverage(res));


    }
}
