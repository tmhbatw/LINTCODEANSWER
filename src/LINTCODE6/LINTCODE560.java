package LINTCODE6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE560 {
    /*Description
    * Support follow & unfollow, getFollowers, getFollowings.
    * Note: the results of getfollow() are sorted.
    * */

    class FriendshipService {

        Map<Integer,List<Integer>> follower;
        Map<Integer,List<Integer>> following;

        public FriendshipService() {
            follower=new HashMap<>();
            following=new HashMap<>();
            // do intialization if necessary
        }

        /*
         * @param user_id: An integer
         * @return: all followers and sort by user_id
         */
        public List<Integer> getFollowers(int user_id) {
            return follower.getOrDefault(user_id,new ArrayList<>());
            // write your code here
        }

        /*
         * @param user_id: An integer
         * @return: all followings and sort by user_id
         */
        public List<Integer> getFollowings(int user_id) {
            return following.getOrDefault(user_id,new ArrayList<>());
            // write your code here
        }

        /*
         * @param from_user_id: An integer
         * @param to_user_id: An integer
         * @return: nothing
         */
        public void follow(int to_user_id, int from_user_id) {
            List<Integer> followerList=follower.getOrDefault(to_user_id,new ArrayList<>());
            insert(followerList,from_user_id);
            follower.put(to_user_id,followerList);
            List<Integer> followingList=following.getOrDefault(from_user_id,new ArrayList<>());
            insert(followingList,to_user_id);
            following.put(from_user_id,followingList);
            // write your code here
        }

        private void insert(List<Integer> list,int cur){
            if(list.size()==0){
                list.add(cur);
                return;
            }
            if(list.contains(cur))
                return;
            int left=0,right=list.size()-1;
            int mid=0;
            while(left<=right){
                mid=left+(right-left)/2;
                if(mid==0&&list.get(mid)>cur||list.get(mid)>cur&&list.get(mid-1)<cur)
                    break;
                if(mid==list.size()-1&&list.get(mid)<cur){
                    mid=list.size();
                    break;
                }
                if(list.get(mid)<cur)
                    left=mid+1;
                else
                    right=mid-1;
            }
            list.add(mid,cur);
        }

        /*
         * @param from_user_id: An integer
         * @param to_user_id: An integer
         * @return: nothing
         */
        public void unfollow(int to_user_id, int from_user_id) {
            List<Integer> followerList=follower.getOrDefault(to_user_id,new ArrayList<>());
            if(followerList.contains(from_user_id))
                followerList.remove(new Integer(from_user_id));
            follower.put(to_user_id,followerList);
            List<Integer> followingList=following.getOrDefault(from_user_id,new ArrayList<>());
            if(followingList.contains(to_user_id))
                followingList.remove(new Integer(to_user_id));
            following.put(from_user_id,followingList);
            // write your code here
        }
    }

    public static void main(String[] args){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        System.out.println(list);
        list.add(3,1);
        System.out.println(list);
    }
}
