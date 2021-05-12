package LINTCODE15;


import java.util.*;

public class LINTCODE1469 {
    /*Description
    * 给出由n个结点，n-1条边组成的一棵树。求这棵树中距离最远的两个结点之间的距离。
    * 给出三个大小为n-1的数组starts,ends,lens,表示第i条边是从starts[i]连向ends[i]，
    * 长度为lens[i]的无向边。
    * */


    public int longestPath(int n, int[] starts, int[] ends, int[] lens) {
        int[] time=new int[n];
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        Map<Integer,Integer> map=new HashMap<>();
        int[] dp=new int[n];
        for(int i=0;i<starts.length;i++){
            time[starts[i]]++;
            list.get(i).add(ends[i]);
            map.put(ends[i],starts[i]);
            dp[ends[i]]=lens[i];
        }
        Queue<Integer> q=new LinkedList<>();
        int result=0;
        for(int i=0;i<n;i++){
            if(list.get(i).size()==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            List<Integer> l=new ArrayList<>();
            for(int curr:list.get(cur)){
                l.add(dp[curr]);
            }
            Collections.sort(l,Comparator.reverseOrder());
            int max1=l.size()>=1?l.get(0):0;
            int max2=l.size()>=2?l.get(1):0;
            result=Math.max(max1+max2,result);
            int father=map.getOrDefault(cur,0);
            time[father]--;
            if(time[father]==0)
                q.add(father);
            dp[cur]+=max1;
        }
        return result;
        // Write your code here
    }

/*    class TreeNode{
        int val;
        List<TreeNode> list;
        public TreeNode(int val){
            this.val=val;
            this.list=new ArrayList<>();
        }
    }
    int result=0;
    public int longestPath(int n, int[] starts, int[] ends, int[] lens) {
        Map<Integer,TreeNode> map=new HashMap();
        for(int i=0;i<starts.length;i++){
            int start=starts[i];
            int end=ends[i];
            map.putIfAbsent(start,new TreeNode(0));
            map.putIfAbsent(end,new TreeNode(0));
            TreeNode startNode=map.get(start);
            TreeNode endNode=map.get(end);
            endNode.val=lens[i];
            startNode.list.add(endNode);
        }
        TreeNode root=null;
        for(TreeNode cur:map.values()){
            if(cur.val==0) {
                root = cur;
                break;
            }
        }
        dfs(root);
        return result;
        // Write your code here
    }

    //dfs算法栈溢出了
    private int dfs(TreeNode root){
        if(root==null)
            return 0;
        List<Integer> list=new ArrayList<>();
        for(TreeNode node:root.list)
            list.add(dfs(node));
        Collections.sort(list,(o1, o2) -> {return o2-o1;});
        int max1=list.size()>=1?list.get(0):0;
        int max2=list.size()>=2?list.get(1):0;
        result=Math.max(max1+max2,result);
        return max1+root.val;
    }*/
}
