package LINTCODE12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LINTCODE1159 {
    /*Description
    *给出一个长度为n字符串数组arr，和长度为K的二元询问数组q，每次询问给出两个x,y 询问
    * arr[x],arr[y]的最长公共前缀的长度. 你需要返回一个大小为K的数组.
    * */

    public int[] queryLCP(String[] arr, int[][] query) {
        if(arr.length==0){
            return null;
        }
        if(arr.length==1){
            int[] res=new int[query.length];
            Arrays.fill(res,arr[0].length());
            return res;
        }
        Map<Integer,String> map1=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map1.put(i,arr[i]);
        }
        Map<String,Integer> map2=new HashMap<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            map2.put(arr[i],i);
        }

        int[] dp=new int[arr.length-1];
        calculateDiff(arr,dp);

        //构建一颗二叉树方便查询
        //每次获取的结果应该是从x到y-1的值
        Node root=getNode(dp,0,dp.length-1);
        int[] res=new int[query.length];

        for(int i=0;i<res.length;i++){
            int l=map2.get(map1.get(query[i][0]));
            int r=map2.get(map1.get(query[i][1]));
            if(l==r) {
                res[i] = arr[l].length();
                continue;
            }
            int min=Math.min(l,r);
            int max=Math.max(l,r)-1;
            res[i]=query(root,min,max);
        }
        return res;
        // write your code here
    }

    private int query(Node root,int left,int right){
        if(root.left>=left&&root.right<=right)
            return root.val;
        if(root.left>right||root.right<left)
            return Integer.MAX_VALUE;
        return Math.min(query(root.l,left,right),query(root.r,left,right));
    }

    private Node getNode(int[] dp,int start,int end){
        if(start==end){
            return new Node(dp[start],start,end);
        }
        Node result=new Node();
        result.left=start;
        result.right=end;
        int mid=(start+end)/2;
        result.l=getNode(dp,start,mid);
        result.r=getNode(dp,mid+1,end);
        result.val=Math.min(result.l.val,result.r.val);
        return result;
    }

    public class Node{
        int val;
        int left;
        int right;
        Node l;
        Node r;
        public Node(){

        }
        public Node(int val, int left, int right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    private void calculateDiff(String[] arr,int[] dp){
        for(int i=0;i<arr.length-1;i++){
            dp[i]=getDiff(arr[i],arr[i+1]);
        }
    }

    private int getDiff(String a, String b){
        int result=0;
        for(;result<Math.min(a.length(),b.length());result++){
            if(a.charAt(result)!=b.charAt(result))
               break;
        }
        return result;
    }
}
