package Interview;

import java.util.Scanner;

public class moni4 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String cur1=s.next();
        String cur2=s.next();
        int res=0;
        for(int i=0;i<cur1.length();i++){
            for(int j=i;j<cur1.length();j++){
                String cur=cur1.substring(i,j+1);


                if(cur2.indexOf(cur)!=-1) {
                    res = Math.max(res, j - i +1);
                }
            }
        }
        System.out.print(res);
    }
}
