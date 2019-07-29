package Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class moni3 {

    //寻找数学规律
        public static void main(String[] args){
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            int[] num=new int[n];
            for(int i=0;i<n;i++)
                num[i]=s.nextInt();
            List<Integer> res=new ArrayList<Integer>();
            for (int i = n; i >= 0; i -= 2)
                res.add(num[i]);
            if(n%2==1){
                for(int i=1;i<n;i+=2)
                    res.add(num[i]);
            }else{
                for(int i=0;i<n;i+=2)
                    res.add(num[i]);
            }
            System.out.print(res.get(0));
            for(int i=1;i<n;i++)
                System.out.print(" "+res.get(i));


        }


    //根据题目意思完成的java转变
/*    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] num=new int[n];
        for(int i=0;i<n;i++)
            num[i]=s.nextInt();
        Stack<Integer> cur=new Stack<>();
        for(int i=0;i<n;i++){
            Stack<Integer> curr=new Stack<>();
            cur.add(num[i]);
            if(i==n-1)
                continue;
            while(!cur.empty())
                curr.add(cur.pop());
            cur=curr;
        }
        System.out.print(cur.pop());
        while(!cur.empty()){
            System.out.print(" "+cur.pop());
        }
    }*/
}
