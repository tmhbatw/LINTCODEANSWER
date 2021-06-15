package LINTCODE16;

import java.util.Iterator;
import java.util.TreeSet;

public class LINTCODE1513 {
    /*Description
    *在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
    * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。
    * 如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
    * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），
    * 代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。
    * 每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
    * */

    public class ExamRoom {
        int n;
        TreeSet<Integer> set;

        public ExamRoom(int N) {
            this.n =N;
            this.set=new TreeSet<>();
        }

        public int seat() {
            if(set.size()==0){
                set.add(0);
                return 0;
            }
            Iterator<Integer> i= set.iterator();
            int pre=i.next();
            int cur=0;
            int max = pre;
            while(i.hasNext()){
                int post = i.next();
                int curDistance= (post-pre)/2;
                if(curDistance>max){
                    max=curDistance;
                    cur = curDistance+pre;
                }
                pre = post;
            }
            int curDistance=n-1-pre;
            if(curDistance>max) {
                set.add(n-1);
                return n - 1;
            }
            set.add(cur);
            return cur;
        }

        public void leave(int p) {
            set.remove(p);
        }
    }

    public static void main(String[] args){
        TreeSet<Integer> set=new TreeSet();
        set.add(1);
        set.add(2);
        set.add(0);
        set.add(-1);
        System.out.println(set);
    }
}
