package LINTCODE11;

public class LINTCODE1043 {
    /*Description
    * N对夫妇坐在2N个排成一排的座位上. 现求最小的交换数量，使每对夫妇并坐一起，他们可以手牵着手。
    * 一次交换可选择任何两个人交换座位。
    * 人和座位由从0到2N-1的整数表示，夫妻按顺序编号，第一对是(0,1)，第二对是(2,3)，以此类推，最后一对是(2N-2,2N-1)。
    * 初始座位由row [i]给出，表示坐在第i座位的人的编号。
    * */

    public int minSwapsCouples(int[] row) {
        int count = 0;
        for(int i=1;i<row.length;i+=2){
            int type = row[i-1]%2==0?row[i-1]+1:row[i-1]-1;
            if(row[i]==type)
                continue;
            for(int j=i+1;j<row.length;j++){
                if(row[j]==type){
                    row[j]=row[i];
                    row[i] = type;
                    count++;
                }
            }
        }
        return count;
        // Write your code here
    }
}
