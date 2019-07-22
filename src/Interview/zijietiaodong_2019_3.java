package Interview;

import java.util.Arrays;
import java.util.Scanner;

public class zijietiaodong_2019_3 {
    /*Description
    * 总共有36张牌，每张牌是1~9。每个数字4张牌。
    * 你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌
    * 14张牌中有2张相同数字的牌，称为雀头。
    * 除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）
    * */


    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int[] num=new int[9];
        for(int i=0;i<13;i++){
            int cur=s.nextInt();
            num[cur-1]++;
        }
        boolean empty=true;
        for(int i=0;i<9;i++){
            if(num[i]<=3&&judge(num,i)) {
                empty=false;
                System.out.println((i+1)+" ");
            }
        }
        if(empty){
            System.out.println(0);
        }
    }

    //去除一个对子
    private static boolean judge(int[] num,int add){
        int[] nums=num.clone();
        nums[add]++;
        for(int i=0;i<9;i++){
            if(nums[i]>=2){
                int[] delete=nums.clone();
                delete[i]-=2;
                if(getHu(delete))
                    return true;
            }
        }
        return false;
    }

    private static boolean getHu(int[] num){
        for(int i=0;i<9;i++){
            if(num[i]==0)
                continue;
            if(num[i]>=3&&i<=6&&num[i+1]>=1&&num[i+2]>=1){
                int[] delete1=num.clone();
                delete1[i]-=3;
                int[] delete2=num.clone();
                delete2[i]-=1;
                delete2[i+2]-=1;
                delete2[i+1]-=1;
                return getHu(delete1)||getHu(delete2);
            }else if(num[i]>=3){
                int[] delete1=num.clone();
                delete1[i]-=3;
                return getHu(delete1);
            }else if(i<=6&&num[i+1]>=1&&num[i+2]>=1){
                int[] delete2=num.clone();
                delete2[i]-=1;
                delete2[i+2]-=1;
                delete2[i+1]-=1;
                return getHu(delete2);
            }else
                return false;
        }
        return true;
    }
}
