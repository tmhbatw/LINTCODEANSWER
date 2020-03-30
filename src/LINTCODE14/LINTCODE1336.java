package LINTCODE14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LINTCODE1336 {
    /*Description
    *有n个朋友来参加聚会，给定他们之间的邀请关系，请查询两个人之间的邀请关系。
    * */

    public List<String> findtheInvitationn(int[][] invitations, int[] inquiry) {
        //用来保存当前朋友的邀请者是谁，则必有一朋友邀请者为0；
        int[] relationship=new int[invitations.length+2];
        for(int[] cur:invitations)
            relationship[cur[1]]=cur[0];

        //用来找到第一个公共父节点的index
        int friend1=inquiry[0];
        HashSet<Integer> set=new HashSet<>();
        set.add(friend1);
        while(relationship[friend1]!=0){
            set.add(relationship[friend1]);
            friend1=relationship[friend1];
        }
        friend1=inquiry[0];
        int father=inquiry[1];
        while(!set.contains(father)){
            father=relationship[father];
        }
        List<String> result=new ArrayList<>();
        while(friend1!=father){
            result.add(friend1+" is invited by "+relationship[friend1]);
            friend1=relationship[friend1];
        }
        int size= result.size();
        int friend2=inquiry[1];
        while(father!=friend2){
            result.add(size,relationship[friend2]+" invites "+friend2);
            friend2=relationship[friend2];
        }
        return result;
        // write your code here
    }
}
