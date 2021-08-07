package LINTCODE17;

public class LINTCODe1640 {
    /*Description
    * 给定一个正整数n，返回不超过n的有重复数字的数有多少个。
    * */

    //可以计算没有重复的数据有多少个
    public long countNumbers(long n) {
        long count=0;
        long base=1;
        int index=0;
        while(base<10000000000L){
            base *=10;
            if(n>=base){
                long curCount = 1;
                for(int i=10;i>=10-index;i--){
                    curCount *= Math.min(i,9);
                }
                count += curCount;
            }else{
                String nn = String.valueOf(n);
                boolean[] reached=new boolean[10];
                int first = nn.charAt(0)-'0';
                reached[first]=true;
                long curCount = first-1;
                for(int i=1;i<nn.length();i++){
                    curCount*=10-i;
                }
                count+=curCount;
                for(int i=1;i<nn.length();i++){
                    int cur=nn.charAt(i)-'0';
                    curCount =0;
                    for(int j=0;j<cur;j++){
                        if(!reached[j])
                            curCount++;
                    }
                    for(int j=i+1;j<nn.length();j++)
                        curCount *= 10-j;
                    count+= curCount;
                    if(reached[cur])
                        break;
                    reached[cur]=true;
                }
                if(isNDifferent(n))
                    count++;
                break;
            }
            index++;
        }
        return n-count;
        // Write your code here.
    }

    boolean isNDifferent(long n){
        String cur=String.valueOf(n);
        boolean[] reached=new boolean[10];
        for(int i=0;i<cur.length();i++){
            int index=cur.charAt(i)-'0';
            if(reached[index])
                return false;
            reached[index]=true;
        }
        return true;
    }

}
