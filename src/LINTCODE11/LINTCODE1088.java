package LINTCODE11;

public class LINTCODE1088 {
    /*Description
    * 在这个问题中，树是一个连接的、无环的无向图。
    * 给定的输入是一个图形，它以具有N个节点（具有不同的值1,2，...，N）的树开始，并添加了一条额外的边。 添加的边有两个不同的顶点（从1到N中选择），并且不是已经存在的边。
    * 得到的图形以关于边的 2D-数组的形式给出。 边的每个元素是一对[u，v]，其中u <v，这表示连接节点u和v的无向边。
    * 你需要输出可以删除的边，以便生成的图是一棵N个节点的树。 如果有多个答案，则返回给定2D数组中最后出现的答案边。 答案边[u，v]应该采用相同的格式，u <v。
    * */

    public int[] findRedundantConnection(int[][] edges) {
        int[] num=new int[edges.length+1];
        for(int i=1;i<num.length;i++)
            num[i]=i;
        for(int[] cur:edges){
            int type1=getType(num,cur[0]);
            int type2=getType(num,cur[1]);
            if(type1==type2)
                return num;
            num[type2]=type1;
        }
        return null;
        // write your code here
    }

    private int getType(int[] num, int index){
        if(num[index]!=index)
            return getType(num,num[index]);
        return index;
    }
}
