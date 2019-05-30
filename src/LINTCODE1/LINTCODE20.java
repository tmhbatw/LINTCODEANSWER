package LINTCODE1;

import java.util.*;

public class LINTCODE20 {
    /*Description
    * Throw n dices, the sum of the dices' faces is S. Given n, find the all possible value of S along with its probability.
    * */

/*Solution
* 使用递归回溯可以遍历出所有的色子数字和情况并输出
* 注释部分为暴力递归解法
* 暴力解法存在空间复杂度过高的情况，需要降低算法的空间复杂度，因此想到动态规划的方法
* 创建一个二维数组用来保存数组对应位置和出现的次数，最后将数组输出到结果集中即可
* */
//    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
//        List<Map.Entry<Integer, Double>> result = new ArrayList();
//        Map<Integer,Double> map=new HashMap<>();
//        recursion(map,n,0);
//        int total= (int) Math.pow(6,n);
//        for(Map.Entry<Integer,Double> entry:map.entrySet()){
//            entry.setValue(entry.getValue()/Math.pow(6,n));
//            //entry.setValue(Double.parseDouble(String.format("%.2f",entry.getValue()/total)));
//            result.add(entry);
//        }
//        return result;
//    }
//
//    private static void recursion(Map<Integer,Double> map,int n,int res){
//        if(n==0){
//            double num=map.getOrDefault(res,0.0);
//            map.put(res,num+1);
//            return;
//        }
//        for(int i=1;i<7;i++){
//            recursion(map,n-1,res+i);
//        }
//    }
//
//    public static void main(String[] args){
//        System.out.println(dicesSum(9));
//    }

    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
        List<Map.Entry<Integer,Double>> res=new ArrayList<>();
        double[][] dp=new double[n+1][n*6+1];//用来存储结果，其中第一行代表色子结果，第一列代表投掷色子的次数
        for(int i=1;i<7;i++)
            dp[1][i]=1.0/6;    //投掷一次色子的情况
        for(int i=2;i<n+1;i++){
            for(int m=i;m<n*6+1;m++){
                for(int j=1;j<7;j++){
                    if(m>j) {
                        dp[i][m] += dp[i - 1][m - j];
                    }
                }
                dp[i][m]/=6;
            }
        }
        for(int m=n;m<n*6+1;m++)
            res.add(new AbstractMap.SimpleEntry<Integer,Double>(m,dp[n][m]));
        return res;
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
    }

}
