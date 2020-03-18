package LINTCODE16;

public class LINTCODE1569 {
    /*Description
    * 每个人都有自己的网上好友。现在有n个人，给出m对好友关系，寻问任意一个人是否能直接或者间接的联系到所有网上的人。
    * 若能，返回yes，若不能，返回no，好友关系用a数组和b数组表示，代表a[i]和b[i]是一对好友。
    * */

    public String socialNetwork(int n, int[] a, int[] b) {
        if(n==0)
            return "yes";
        int[] dp=new int[n+1];
        for(int i=1;i<n+1;i++){
            dp[i]=i;
        }
        for(int i=0;i<a.length;i++){
            int aa=a[i],bb=b[i];
            if(getType(dp,aa)!=getType(dp,bb)){
                n--;
                dp[getType(dp,bb)]=getType(dp,aa);
            }
        }
        return n==1?"yes":"no";
        // Write your code here
    }

    private int getType(int[] dp,int index){
        if(dp[index]==index)
            return index;
        return getType(dp,dp[index]);
    }
}
