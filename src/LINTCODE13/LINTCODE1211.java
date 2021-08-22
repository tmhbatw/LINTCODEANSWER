package LINTCODE13;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1211 {
    /*Description
    * 这是一个祖玛游戏。
    * 一行球放在桌面上，球被涂上了红（R）、黄（Y）、蓝（B）、绿（G）和白（W）这么几种颜色，同时你也拥有几个球。
    * 每一次，从你拥有的球当中拿出一个，插入到当前行当中（包括最左边和最右边）。
    * 然后，如果有三个或更多的同色球挨在一起，然后就消除这几个球。一直这么做直到没有更多的球可以消除。
    * 找到最少的需要插入的球的数量，使得所有的球都可以被删除。如果不能删除所有的球，那么就返回-1。
    * */

    int result=Integer.MIN_VALUE;
    public int findMinStep(String board, String hand) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<hand.length();i++){
            map.put(hand.charAt(i),map.getOrDefault(hand.charAt(i),0)+1);
        }
        dfs(board,map);
        return result==Integer.MIN_VALUE?-1:hand.length()-result;
        // Write your code here
    }

    private void dfs(String board,Map<Character,Integer> map){
        if(board.length()==0){
            System.out.println(map);
            int res=0;
            for(Map.Entry<Character,Integer> entry:map.entrySet()){
                res+=entry.getValue();
            }
            result=Math.max(res,result);
            return;
        }
        int length=board.length();
        for(int i=0;i<board.length();i++){
            char cur=board.charAt(i);
            int time=1;
            while(i<length-1&& board.charAt(i+1)==cur){
                i++;
                time++;
            }
            int left=3-time;
            if(map.getOrDefault(cur,0)<left){
                continue;
            }
            map.put(cur,map.get(cur)-left);
            dfs(delete(board.substring(0,i-time+1)+board.substring(i+1)),map);
            map.put(cur,map.get(cur)+left);
        }
    }

    private String delete(String board){
        int length=board.length();
        for(int i=0;i<length;i++){
            char cur=board.charAt(i);
            int start=i;
            while(i<length-1&&board.charAt(i+1)==cur){
                i++;
            }
            if(i-start+1>=3){
                return delete(board.substring(0,start)+board.substring(i+1));
            }
        }
        return board;
    }
}
