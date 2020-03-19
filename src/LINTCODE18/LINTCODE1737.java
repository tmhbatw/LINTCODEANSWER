package LINTCODE18;

public class LINTCODE1737 {
    /*Description
    * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
    * 你可以从你选择的任何树开始，然后重复执行以下步骤：
    * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
    * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
    * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
    * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。用这个程序你能收集的水果总量是多少？
    * */

    public int totalFruit(int[] tree) {
        int[] number=new int[2];
        number[0]=number[1]=-1;
        int[] time=new int[2];
        int start=0;
        int result=0;
        for(int i=0;i<tree.length;i++){
            int cur=tree[i];
            if(cur==number[0]) {
                time[0]++;
                continue;
            }
            if(cur==number[1]){
                time[1]++;
                continue;
            }
            if(number[0]==-1){
                number[0]=cur;
                time[0]++;
            }else if(number[1]==-1){
                number[1]=cur;
                time[1]++;
            }else{
                result=Math.max(i-start,result);
                while(time[1]>0&&time[0]>0){
                    if(tree[start++]==number[0])
                        time[0]--;
                    else
                        time[1]--;
                }
                if(time[0]==0){
                    number[0]=cur;
                    time[0]=1;
                }else{
                    number[1]=cur;
                    time[1]=1;
                }
            }
        }
        return Math.max(result,tree.length-start);
        // write your code here
    }
}
