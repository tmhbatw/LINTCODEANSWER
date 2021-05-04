package LINTCODE23;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LINTCODE2248 {
    /*Description
    *请编写代码，使用 Date 类和 SimpleDateFormat 类中的相关方法来计算某个人出生了多少天。
    * 在本题的 Solution 类中有个 getTime 方法，该方法有两个 String 类型的参数 birthday 和 nowTime，birthday 代表某人的出生日期，
    * nowTime 代表现在的日期。该方法要计算某人从出生的日期到现在的日期经过了多少天，并返回统计值，返回值为 long 类型。
    * 请在类名为 Solution 中的 getTime 方法中的 // write your code here 下面编写你的代码。
    * */

    public long getTime(String birthday, String nowTime)
            throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date birthday1=simpleDateFormat.parse(birthday);
        Date nowTime1=simpleDateFormat.parse(nowTime);
        return (nowTime1.getTime()-birthday1.getTime())/24/3600/1000;
        // write your code here
    }
}
