package LINTCODE18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LINTCODE1786 {
    /*Description
    *发布/订阅模式是系统设计中广泛使用的模式。 在此问题中，您需要实现发布/订阅模式以支持特定频道上的用户订阅，并从订阅的频道获取通知消息。
    * 您需要实现3种方法：
    * subscribe（channel，user_id）：将给定用户订阅到给定频道。
    * unsubscribe（channel，user_id）：取消订阅给定用户的给定用户。
    * publish（channel，message）：您需要将消息发布到频道，以便在频道上订阅的每个人都会收到此消息。
    * 调用PushNotification.notify（user_id，message）将消息推送给用户。
    * */

    static class PushNotification {
        public static void notify(int user_id, String the_message){
            System.out.println("pass message");
        }
    }

    class PubSubPattern {
        Map<String, Set<Integer>> map;
        public PubSubPattern(){
            map=new HashMap<>();
            // Write your code here
        }

        /**
         * @param channel: the channel's name
         * @param user_id: the user who subscribes the channel
         * @return: nothing
         */
        public void subscribe(String channel, int user_id) {
            Set<Integer> set=map.getOrDefault(channel,new HashSet<>());
            set.add(user_id);
            map.put(channel,set);
            // Write your code here
        }

        /**
         * @param channel: the channel's name
         * @param user_id: the user who unsubscribes the channel
         * @return: nothing
         */
        public void unsubscribe(String channel, int user_id) {
            Set<Integer> set=map.getOrDefault(channel,new HashSet<>());
            set.remove(user_id);
            map.put(channel,set);
            // Write your code here
        }

        /**
         * @param channel: the channel's name
         * @param message: the message need to be delivered to the channel's subscribers
         * @return: nothing
         */
        public void publish(String channel, String message) {
            Set<Integer> set=map.getOrDefault(channel,new HashSet<>());
            for(int num:set)
                PushNotification.notify(num,message);
            // Write your code here
        }
    }
}
