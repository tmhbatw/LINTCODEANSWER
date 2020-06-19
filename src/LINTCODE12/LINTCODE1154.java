package LINTCODE12;

public class LINTCODE1154 {
    /*Description
    * 给定一个表示某学生出勤情况的字符串，‘A’代表出勤，‘D’代表缺勤，‘L’代表迟到。
    * 若该学生出现两次及以上缺勤或者连续三次及以上迟到则需要接受惩罚。请你判断该学生是否该接受惩罚并返回布尔类型。
    * */

    public boolean judge(String record) {
        int DTime=0;
        int length=record.length();
        for(int i=0;i<length;i++){
            char cur=record.charAt(i);
            if(cur=='D')
                DTime++;
            if(cur=='L'){
                if(i<length-2&&record.charAt(i+1)==record.charAt(i+2)&& record.charAt(i+1)=='L')
                    return true;
            }
        }
        return DTime>=2;
        // Write your code here.
    }
}
