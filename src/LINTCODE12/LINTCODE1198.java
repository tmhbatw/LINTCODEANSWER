package LINTCODE12;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1198 {
    /*Description
    * 给定一颗树的根，请找到的出现频率最高的子树和。 节点的子树和被定义为由以该节点为根的子树（包括节点本身）
    * 形成的所有节点值的总和。 那么最常见的子树和值是多少？ 如果存在平局，则以任何顺序返回频率最高的所有值。
    * */

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map=new HashMap<>();
        getSum(root,map);
        List<Integer> res=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(Map.Entry entry:map.entrySet()){
            int time= (int) entry.getValue();
            if(max<time){
                max=time;
                res=new ArrayList<>();
                res.add((int)entry.getKey());
            }
            else if(max==time)
                res.add((int)entry.getKey());
        }
        int[] result=new int[res.size()];
        for(int i=0;i<res.size();i++)
            result[i]=res.get(i);
        return result;
        // Write your code here
    }

    private int getSum(TreeNode root, Map<Integer,Integer> map){
        if(root==null)
            return 0;
        int curVal=root.val;
        curVal+=getSum(root.left,map)+getSum(root.right,map);
        map.put(curVal,map.getOrDefault(curVal,0)+1);
        return curVal;
    }
}
