package LINTCODE12;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1145 {
    /*Description
    *给定一张员工表datalist1，存储员工ID，员工姓名。
    * 给定一张员工工作时长表datalist2，存储员工ID，月份，工时。
    * 计算每个员工1-3月每月工时及总工时
    * 输入描述：
    * [[员工ID,员工姓名],[员工ID,员工姓名],...]
    * [[员工ID,月份,工时,月份,工时,月份,工时],[员工ID,月份,工时,月份,工时,月份,工时],...]
    * 输出描述：
    * [[员工姓名,一月份工时，二月份工时，三月份工时，总工时],[员工姓名,一月份工时，二月份工时，三月份工时，总工时],...]
    * */

    public List<List<String>> getList(List<List<String>> datalist1, List<List<String>> datalist2) {
        List<List<String>> result=new ArrayList<>();
        int number=datalist1.size();
        for(int i=0;i<number;i++){
            List<String> res=new ArrayList<>();
            res.add(datalist1.get(i).get(1));
            int time1 =0,time2=0,time3=0;
            List<String> cur=datalist2.get(i);
            for(int j=1;j<cur.size();j+=2) {
                String curr = cur.get(j);
                if (curr.equals("01"))
                    time1 += Integer.parseInt(cur.get(j + 1));
                if (curr.equals("02"))
                    time2 += Integer.parseInt(cur.get(j + 1));
                if (curr.equals("03"))
                    time3 += Integer.parseInt(cur.get(j + 1));
            }
            res.add(time1+"");
            res.add(time2+"");
            res.add(time3+"");
            res.add(String.valueOf(time1+time2+time3));

            result.add(res);
        }
        return result;
        // write your code here
    }
}
