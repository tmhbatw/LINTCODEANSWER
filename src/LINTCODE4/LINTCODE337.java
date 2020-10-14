package LINTCODE4;

public class LINTCODE337 {
    /*Description
    * 现在有一个团队，一共有 nn 个成员，每个成员的编号为 0 到 n - 1。
    * 团队中有很多个不同的小组，一个人可能加入了多个小组，也可能一个人也没有加入。
    * 如果一个成员收到了一条通知，他会将通知分享给他所在小组中的其它成员。
    * 现在编号为 00 的成员收到了一条通知，请问最终会有多少成员收到通知，包括 00 号。
    * */

    public int teamNotification(int n, int[][] groups) {
        int[] unionFindSet=new int[n];
        for(int i=0;i<n;i++)
            unionFindSet[i]=i;
        for(int[] cur:groups){
            int index=getType(cur[0],unionFindSet);
            for(int i=1;i<cur.length;i++){
                unionFindSet[getType(cur[i],unionFindSet)]=index;
            }
        }
        int result=0;
        int type=getType(0,unionFindSet);
        for(int i=0;i<n;i++){
            if(getType(i,unionFindSet)==type)
                result++;
        }
        return result;
        // write your code here.
    }

    private int getType(int index, int[] unionFindSet){
        while(unionFindSet[index]!=index)
            return getType(unionFindSet[index],unionFindSet);
        return index;
    }
}
