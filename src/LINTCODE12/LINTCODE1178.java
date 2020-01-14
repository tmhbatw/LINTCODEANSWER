package LINTCODE12;

public class LINTCODE1178 {
    /*Description
    * 给定一个字符串表示学生出勤记录，记录仅由下列三个字符组成：
    * 'A' : 缺席（Absent）.
    * 'L' : 迟到（Late）.
    * 'P' : 到场（Present）.
    * 如果学生的出勤情况不包含 超过一个'A'(缺席) 或者 超过连续两个'L'(迟到) ，那么他就应该受到奖励。
    * 返回该学生是否会受到奖励。
    * */

    public boolean checkRecord(String s) {
        boolean absent=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A') {
                if(!absent)
                    absent=true;
                else
                    return false;
            }
            if(i>=2&&s.charAt(i-1)=='L'&&s.charAt(i)=='L'&&s.charAt(i-2)=='L')
                return false;
        }
        return true;
        // Write your code here
    }
}
