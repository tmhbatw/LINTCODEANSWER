package LINTCODE19;

public class LINTCODE1881 {
    /*Description
    * 您的任务是为四口之家尽可能多的分配座位。一个四口之家必须占领一排当中连续的四个座位。过道上的座位（例如2C和2D）
    * 不被认为是彼此相邻的。一家人被过道分开是可以的，但在这种情况下必须每一边坐两个。显然，座位不可以分配给一个以上的家庭。
    * */

    private int getResult(boolean[] cur){
        if(!cur[1]&&!cur[2]&&!cur[3]&&!cur[4]&&!cur[5]&&!cur[6]&&!cur[7]&&!cur[8])
            return 2;
        if(!cur[1]&&!cur[2]&&!cur[3]&&!cur[4]||!cur[5]&&!cur[6]&&!cur[7]&&!cur[8]||!cur[3]&&!cur[4]&&!cur[5]&&!cur[6])
            return 1;
        return 0;
    }

    public int solution(int N, String S) {
        boolean[][] dp=new boolean[N][10];
        if(S!=null&&S.length()!=0) {
            String[] s = S.split(" ");
            for (String cur : s) {
                int index1 = Integer.parseInt(cur.substring(0, cur.length() - 1)) - 1;
                int index2 = cur.charAt(cur.length() - 1) - 'A';
                dp[index1][index2] = true;
            }
        }
        int result=0;
        for(boolean[] cur:dp)
            result+=getResult(cur);
        return result;
        // Write your code here.
    }


}
