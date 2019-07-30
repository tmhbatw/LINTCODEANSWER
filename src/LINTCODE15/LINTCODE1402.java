package LINTCODE15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE1402 {
    /*Description
    * 给n个人的朋友名单，告诉你user，请找出user最可能认识的人。
    * （他和user有最多的共同好友且他不是user的朋友）
    * */

    public int recommendFriends(int[][] friends, int user) {
        HashSet<Integer>[] sets=new HashSet[friends.length];
        for(int i=0;i<sets.length;i++)
            sets[i]=new HashSet<>();
        for(int i=0;i<friends.length;i++) {
            int[] num=friends[i];
            for(int cur:num)
                sets[i].add(cur);
        }
        int userId=-1;
        int number=0;
        HashSet<Integer> curr=sets[user];
        for(int i=0;i<friends.length;i++){
            if(i==user||curr.contains(i))
                continue;
            int curFriend=0;
            for(int cur:curr){
                if(sets[i].contains(cur))
                    curFriend++;
            }
            if(curFriend>number){
                number=curFriend;
                userId=i;
            }
        }
        return userId;
        // Write your code here
    }

}
