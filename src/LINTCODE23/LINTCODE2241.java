package LINTCODE23;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LINTCODE2241 {
    /*Description
    * 请编写代码，使用 Date 类和 SimpleDateFormat 类中的相关方法来获取指定日期的毫秒值。
    * 在本题的 Solution 类中有个 getMilliSeconds 方法，该方法有一个 String 类型的参数 str 代表获取的指定日期，
    * 该方法要计算1970-01-01到指定日期经过了多少毫秒，并返回统计值，返回值为 long 类型。
    * 请你在类名为 Solution 中的 getMilliSeconds 方法中的 // write your code here 下面编写你的代码。
    * */

    public long getMilliSeconds(String str) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=sdf.parse(str);
        Date date2=sdf.parse("1970-01-01");
        return date1.getTime()-date2.getTime();
        // write your code here
    }
}
