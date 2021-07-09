package LINTCODE13;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LINTCODE1202 {
    /*Description
    * 假设LintCode即将开始其IPO。 为了向Venture Capital出售其股票的优惠价格，LintCode希望在IPO之前开展一些项目以增加其资本。
    * 由于资源有限，它只能在IPO之前完成最多 k 个不同的项目。 请你帮助LintCode设计一种在完成大多数 k 不同项目后最大化其总资本的最佳方法。
    * 你有几个项目。 对于每个项目i，它具有净利润 Pi，并且需要最小资本 Ci 来启动相应的项目。 最初，你有 W资本。 完成项目后，您将获得净利润，
    * 利润将被添加到您的总资本中。总而言之，从给定项目中选择最多 k个不同项目的列表，以最大化您的最终资本，并输出您的最终最大化资本。
    * */

    class Project {
        int profit;
        int capital;
        public Project (int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Project> q=new PriorityQueue<>((o1,o2)->{
            return o2.profit-o1.profit;
        });
        int length=Profits.length;
        Project[] projects =new Project[length];
        for(int i=0;i<length;i++){
            projects[i] =new Project(Profits[i], Capital[i]);
        }
        Arrays.sort(projects,(o1,o2)->o1.capital-o2.capital);
        int index=addProject(q,0,projects,W);
        while(k-->0&&!q.isEmpty()){
            Project p=q.poll();
            W+=p.profit;
            index = addProject(q,index,projects,W);
        }
        return W;
        // Write your code here
    }

    private int addProject (PriorityQueue<Project> q, int index,Project[] projects, int W) {
        int length=projects.length;
        while(index<length&&W>=projects[index].capital)
            q.add(projects[index++]);
        return index;
    }

    public static void main(String[] args){
        int k =  2;
        int w= 0;
        int[] p=new int[]{1,2,3};
        int[] c=new int[]{0,1,1};
        System.out.println(new LINTCODE1202().findMaximizedCapital(k,w,p,c));
    }
}
