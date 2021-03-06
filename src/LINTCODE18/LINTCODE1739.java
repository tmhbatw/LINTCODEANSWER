package LINTCODE18;

public class LINTCODE1739 {
    /*Description
    * 我们有一组排序的数字 D，它是 {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）
    * 现在，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。
    * 返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。
    * */

    public int atMostNGivenDigitSet(String[] D, int N) {
        //
        char[] c=(N+"").toCharArray();
        int length=D.length;
        char[] d=new char[length];
        for(int i=0;i<length;i++)
            d[i]=D[i].charAt(0);
        int[] res=new int[c.length+1];
        res[0]=1;
        for(int i=1;i<c.length;i++){
            res[i]=res[i-1]*length;
        }

        int result=0;
        //for(int j=0;j<length;j++){
        boolean flag=true;
        int distance=0;
        while(flag){
            flag=false;
            for(int i=0;i<length;i++){
                if(d[i]<c[distance]){
                    result+=res[res.length-distance-2];
                }else if(d[i]==c[distance])
                    flag=true;
            }
            System.out.println(result+" "+distance);
            distance++;
            if(distance==c.length){
                if(flag)
                    result++;
                break;
            }
        }
        //}
        for(int i=1;i<res.length;i++){
            result+=res[i];
        }
        return result;
        // Write your code here
    }
}
