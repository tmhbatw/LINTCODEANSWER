package LINTCODE6;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE526 {
    /*Description
    * 为网站实现一个负载均衡器，提供如下的 3 个功能：
    * 添加一台新的服务器到整个集群中 => add(server_id)。
    * 从集群中删除一个服务器 => remove(server_id)。
    * 在集群中随机（等概率）选择一个有效的服务器 => pick()。
    * 最开始时，集群中一台服务器都没有。每次 pick() 调用你需要在集群中随机返回一个 server_id。
    * */

    /*Description
    * 可以使用一个arraylist来保存网站服务器的id
    * */

    public LINTCODE526(){

    }

    List<Integer> container=new ArrayList<>();

    public void add(int server_id) {
        container.add(server_id);
        // write your code here
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        container.remove(new Integer(server_id));
        // write your code here
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        return container.get((int) (Math.random()*container.size()));
        // write your code here
    }

}
