package NOWCODER;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class zijietiaodong_2019_4 {
    /*Description
    *第一行包含一个正整数N，代表测试用例的个数。\
    * 每个测试用例的第一行包含一个正整数M，代表视频的帧数。
    * 接下来的M行，每行代表一帧。其中，第一个数字是该帧的特征个数，接下来的数字是在特征的取值；比如样例输入第三行里，2代表该帧有两个猫咪特征，<1，1>和<2，2>
    所有用例的输入特征总数和<100000N满足1≤N≤100000，M满足1≤M≤10000，一帧的特征个数满足 ≤ 10000。
    * 特征取值均为非负整数。
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        for(int i=0;i<N;i++){
            int M=s.nextInt();
            int max=0;
            Map<String,Integer> map=new HashMap<>();
            for(int j=0;j<M;j++){
                int num=s.nextInt();
                Map<String,Integer> currMap=new HashMap<>();
                for(int m=0;m<num;m++){
                    String cur=s.nextInt()+" "+s.nextInt();
                    int count=map.containsKey(cur)?map.get(cur)+1:1;
                    max=Math.max(count,max);
                    currMap.put(cur,count);
                }
                map=currMap;
            }
            System.out.println(max);
        }

    }
}
