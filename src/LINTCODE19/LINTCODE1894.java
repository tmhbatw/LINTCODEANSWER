package LINTCODE19;

import java.util.*;

public class LINTCODE1894 {
    /*Description
    * 在我们的网络上购买广告的人没有足够的数据来说明广告是如何为他们的业务工作的。 他们要求我们找出哪些广告在他们的网站上产生了最多的购买量。
    * 我们的客户为我们提供了一个用户ID列表，这些客户在点击他们的广告后在登陆页面上购买了一些东西。
    * 我们的运营团队从我们的广告服务器上获取了一些原始的日志数据，这些数据显示了每次用户点击广告的情况.
    * 客户端还发送了所有用户的IP地址。
    * 编写一个函数来解析这些数据，确定每个广告被点击了多少次，然后返回广告文本，该广告的点击次数，以及这些广告点击中有多少是来自购买的用户。
    * 返回格式是一个列表，每一项是购买数/点击数 商品名称。你可以以任意顺序返回答案，但你需要返回所有输入中出现的商品。
    * */

    public List<String> adClickAnalysis(String[] completed_purchase_user_ids, String[] ad_clicks, String[] all_user_ips) {
        Map<String,String> userMap=new HashMap<>();
        for(String cur:all_user_ips){
            String[] curr=cur.split(",");
            userMap.put(curr[1],curr[0]);
        }
        Map<String,Integer> clickMap=new HashMap<>();
        Map<String,Integer> buyMap=new HashMap<>();
        Set<String> set=new HashSet<>();
        for(String cur:completed_purchase_user_ids)
            set.add(cur);
        for(String cur:ad_clicks){
            String[] curr=cur.split(",");
            clickMap.put(curr[2],clickMap.getOrDefault(curr[2],0)+1);
            int flag=set.contains(userMap.get(curr[0]))?1:0;
            buyMap.put(curr[2],buyMap.getOrDefault(curr[2],0)+flag);
        }
        List<String> list=new ArrayList<>();
        for(Map.Entry entry:clickMap.entrySet()){
            String ad= (String) entry.getKey();
            int clickTime=(int) entry.getValue();
            int buyTime=buyMap.get(ad);
            list.add(buyTime+"/"+clickTime+" "+ad);
        }
        return list;
        // write your code here
    }
}
