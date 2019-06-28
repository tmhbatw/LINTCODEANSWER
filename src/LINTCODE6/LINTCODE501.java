package LINTCODE6;

import datastructure.Tweet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LINTCODE501 {
    /*Description
    * 实现一个迷你的推特，支持下列几种方法
    * postTweet(user_id, tweet_text). 发布一条推特.
    * getTimeline(user_id). 获得给定用户最新发布的十条推特，按照发布时间从最近的到之前排序
    * getNewsFeed(user_id). 获得给定用户的朋友或者他自己发布的最新十条推特，从发布时间最近到之前排序
    * follow(from_user_id, to_user_id). from_user_id 关注 to_user_id.
    * unfollow(from_user_id, to_user_id). from_user_id 取消关注 to_user_id.
    * */

    /*Solution
    * 可以使用一个hashmap保留关注与非关注的关系
    *通过一个list保留所有的tweet信息（可以优化）
    * */

    HashMap<Integer,ArrayList<Integer>> follow=new HashMap<>();
    List<Tweet> list=new ArrayList<>();

    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */


    public Tweet postTweet(int user_id, String tweet_text) {
        Tweet curr=Tweet.create(user_id,tweet_text);
        list.add(curr);
        return curr;
        // write your code here
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        List<Tweet> result=new ArrayList<>();
        ArrayList<Integer> num=follow.get(user_id);
        for(int j=list.size()-1;j>=0;j--){
            int id=list.get(j).user_id;
            if(id==user_id|| num!=null&&num.contains(id)){
                result.add(list.get(j));
            }
            if(result.size()==10)
                return result;
        }
        return result;

        // write your code here
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        List<Tweet> result=new ArrayList<Tweet>();
        for(int j=list.size()-1;j>=0;j--){
            Tweet cur=list.get(j);
            if(cur.user_id==user_id){
                result.add(cur);
            }
            if(result.size()==10)
                return result;
        }
        return result;
        // write your code here
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        if(!follow.containsKey(from_user_id)){
            follow.put(from_user_id,new ArrayList<Integer>());
        }
        ArrayList<Integer> cur=follow.get(from_user_id);
        cur.add(to_user_id);
        follow.put(from_user_id,cur);
        // write your code here
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        if(!follow.containsKey(from_user_id))
            return;
        ArrayList<Integer> cur=follow.get(from_user_id);
        cur.remove(new Integer(to_user_id));
        follow.put(from_user_id,cur);
        // write your code here
    }

}