package LINTCODE16;

import java.util.*;

public class LINTCODE1571 {
    /*Description
    * 给定一个列表，列表中的每个元素代表一位学生的StudentId 和 GPA，返回GPA名前K的学生的StudentId 和 GPA ,按照原始数据的顺序输出。
    * */

    public List<List<String>> topKgpa(List<List<String>> list, int k) {
        int size=list.size();
        if(k>=size)
            return list;
        PriorityQueue<List<String>> queue=new PriorityQueue<>(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                double oo1=Double.parseDouble(o1.get(1));
                double oo2=Double.parseDouble(o2.get(1));
                if(oo1==oo2)
                    return 0;
                return oo1<oo2?-1:1;
            }
        });
        for(int i=0;i<size;i++){
            List<String> cur=list.get(i);
            cur.add(i+"");
            queue.add(cur);
            if(i>=k)
                queue.poll();
        }
        List<List<String>> result=new ArrayList<>(queue);
        Collections.sort(result, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int oo1= Integer.parseInt(o1.get(2));
                int oo2=Integer.parseInt(o2.get(2));
                return oo1-oo2;
            }
        });
        for(int i=0;i<k;i++){
            List<String> cur=result.get(i);
            cur.remove(2);
        }
        return result;
        // Write your code here
    }
}
