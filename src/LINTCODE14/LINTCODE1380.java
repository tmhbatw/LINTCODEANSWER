package LINTCODE14;

import java.util.Arrays;
import java.util.Comparator;

public class LINTCODE1380 {
    /*Description
    * 给定一个字符串列表 logs, 其中每个元素代表一行日志. 每行日志信息由第一个空格分隔成两部分,
    * 前面是这一行日志的 ID, 后面是日志的内容(日志的内容中可能包含空格). 一条日志的内容要么全部由字母和空格组成, 要么全部由数字和空格组成.
    * 现在你需要按照如下规则对列表中的所有日志进行排序:
    * 内容为字母的日志应该排在内容为数字的日志之前
    * 内容为字母的日志, 按照内容的字典序排序, 当内容相同时则按照 ID 的字典序
    * 内容为数字的日志, 按照输入的顺序排序
    * */

    public String[] logSort(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] oo1=o1.split(" ");
                String[] oo2=o2.split(" ");
                int o1Type=getType(oo1[1]);
                int o2Type=getType(oo2[1]);
                if(o1Type==1&&o2Type==1)
                    return 0;
                if(o1Type==1)
                    return 1;
                if(o2Type==1)
                    return -1;
                String o1Content=o1.substring(oo1[0].length());
                String o2Content=o2.substring(oo2[0].length());
                if(o1Content.equals(o2Content))
                    return oo1[0].compareTo(oo2[0]);
                return o1Content.compareTo(o2Content);
            }
        });
        return logs;
        // Write your code here
    }



    private int getType(String cur){
        if(cur.charAt(0)<='9'&&cur.charAt(0)>='0')
            return 1;
        return 0;
    }


}
