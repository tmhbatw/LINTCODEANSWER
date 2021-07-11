package LINTCODE16;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LINTCODE1512 {
    /*Description
    * 有N名工人。 第i名工人具有质量quality[i]和最低工资预期工资wage[i]。
    * 现在我们想雇用恰好K工人来组建一个付费团体。 雇用一组K工人时，我们必须按照以下规则付款：
    * 与付费团体中的其他工作人员相比，付费团体中的每个工人都应按其质量比例获得报酬。
    * 薪酬组中的每个工人必须至少获得最低工资预期。
    * 返回满足上述条件的付费群体所需的最少金额。
    * */

    class People{
        int quality,wage;
        public People(int quality, int wage){
            this.quality = quality;
            this.wage = wage;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int length=quality.length;
        People[] people=new People[length];
        for(int i=0;i<length;i++){
            people[i]=new People(quality[i],wage[i]);
        }
        Arrays.sort(people, (o1,o2)->{
            double oo1=o1.wage*1.0/o1.quality;
            double oo2=o2.wage*1.0/o2.quality;
            if(oo1<oo2)
                return -1;
            return 1;
        });
        for(People cur:people){
            System.out.print(cur.quality+" "+cur.wage+"  ");
        }
        double res=Double.MAX_VALUE;
        PriorityQueue<People> p=new PriorityQueue<>((o1,o2)->o2.quality-o1.quality);
        int time=0;
        for(int i=0;i<K-1;i++){
            p.add(people[i]);
            time+=people[i].quality;
        }
        for(int i=K-1;i<length;i++){
            p.add(people[i]);
            time+=people[i].quality;
            res=Math.min(res,people[i].wage*1.0*(time)/people[i].quality);
            People cur=p.poll();
            time-=cur.quality;
        }
        return res;
        // Write your code here
    }
}
