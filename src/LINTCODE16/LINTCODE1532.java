package LINTCODE16;

import datastructure.DirectedGraphNode;
import datastructure.UndirectedGraphNode;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINTCODE1532 {
    /*Description
    *序列化是将一个数据结构或对象转换成比特流的过程，以便将其存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一或另一计算机环境中重建。
    * 设计一个算法来序列化和反序列化一个N叉树。一棵N叉树是一棵有根树，其中每个节点的子节点不超过N个。
    * 序列化/反序列化算法的实现方式没有限制。您只需要确保N叉树可以序列化为字符串，并且该字符串可以反序列化为原始树结构
    * */

    public class Solution {

        public String serialize(ArrayList<DirectedGraphNode> nodes) {
            if(nodes==null||nodes.isEmpty())
                return "";
            boolean[] isNotRoot=new boolean[nodes.size()];
            for(DirectedGraphNode node:nodes){
                for(int i=1;i<node.neighbors.size();i++){
                    isNotRoot[node.neighbors.get(i).label-1]=true;
                }
            }
            StringBuilder sb=new StringBuilder();
            int root=0;
            for(int i=0;i<isNotRoot.length;i++){
                if(!isNotRoot[i]){
                    root=i;
                    break;
                }
            }
            dfs(sb,nodes,root);
            System.out.println(sb.toString());
            return sb.toString();
        }

        private void dfs(StringBuilder sb,ArrayList<DirectedGraphNode> nodes,int root){
            DirectedGraphNode rootNode=nodes.get(root);

            sb.append("[").append(rootNode.label);
            List<DirectedGraphNode> list=rootNode.neighbors;
            for(int i=1;i<list.size();i++){
                dfs(sb,nodes,list.get(i).label-1);
            }
            sb.append("]");
        }
        public UndirectedGraphNode deserialize(String data) {
            if(data.length()==0)
                return null;
            return deserialize(data,0,data.length()-1);

        }
        private UndirectedGraphNode deserialize(String data,int start,int end){
            int val=0;
            int i=start+1;
            for(;i<end;i++){
                if(data.charAt(i)=='[')
                    break;
                val=val*10+data.charAt(i)-'0';
            }
            UndirectedGraphNode result=new UndirectedGraphNode(val);
            List<UndirectedGraphNode> list= result.neighbors;

            int count=0;
                for (int j = i; j < end; j++) {
                    if(data.charAt(j)=='[')
                        count++;
                    if(data.charAt(j)==']')
                        count--;
                    if(count==0){
                        list.add(deserialize(data,i,j));
                        i=j+1;
                    }
                }

            return result;
        }
    }
}
