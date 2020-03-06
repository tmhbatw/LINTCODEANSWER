package LINTCODE16;

public class LINTCODE1575 {

    /*Description
    * 有n组小朋友准备去春游，数组a表示每一组的人数，保证每一组不超过四个人，现在有若干辆车，每辆车最多只能坐四个人，
    * 同一组的小朋友必须坐在同一辆车上，同时每辆车可以不坐满。问最少需要多少辆车能够满足小朋友们的出行需求
    * */

    public int getAnswer(int[] a) {
        int[] num=new int[4];
        for(int cur:a)
            num[cur-1]++;
        if(num[0]<=num[2])
            num[0]=0;
        else
            num[0]-=num[2];
        int sum=num[0]+2*num[1];
        if(sum%4==0)
            return sum/4+num[3]+num[2];
        return sum/4+num[3]+num[2]+1;
        // Write your code here
    }
}
