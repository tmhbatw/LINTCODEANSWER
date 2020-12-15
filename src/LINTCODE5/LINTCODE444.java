package LINTCODE5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LINTCODE444 {
    /*Description
    *请你设计一个数据结构，支持以下两种操作：
    * void addEdge(int a, int b)：在编号为a的点和编号为b的点之间链接一条边。保证不会出现自环和重边。
    * bool isValidTree()：判断当前已经出现的点和边是否能形成一棵树。
    * */

    Map<Integer,Integer> map=new HashMap<>();
    Set<Integer> groupID=new HashSet<>();
    boolean noLoop=true;
    public void addEdge(int a, int b) {
        if(!map.containsKey(a))
            map.put(a,a);
        if(!map.containsKey(b))
            map.put(b,b);
        a=getGroup(a);
        b=getGroup(b);
        groupID.add(a);
        groupID.add(b);
        if(a==b){
            noLoop=false;
        }
        else {
            map.put(b, a);
            groupID.remove(b);
        }
        // write your code here
    }

    private int getGroup(int a){
        if(map.get(a)!=a)
            return getGroup(map.get(a));
        return a;
    }

    /**
     * @return: check whether these edges make up a valid tree
     */
    public boolean isValidTree() {
        return noLoop&&groupID.size()==1;
        // write your code here
    }
}
