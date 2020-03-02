package LINTCODE13;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1235 {
    /*Description
    * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
    * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
    * 编码的字符串应尽可能紧凑。
    * 注意： 不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
    * */

    class Solution {
        public String serialize(TreeNode root) {
            StringBuilder sb=new StringBuilder();
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode cur=queue.poll();
                if(cur==null)
                    sb.append("#,");
                else{
                    sb.append(cur.val+",");
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
            return sb.toString().substring(0,sb.length()-1);
        }


        public TreeNode deserialize(String data) {
            if(data.length()<=2)
                return null;
            String[] res=data.split(",");
            TreeNode result=new TreeNode(Integer.parseInt(res[0]));
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(result);
            int index=1;
            while(!queue.isEmpty()){
                TreeNode cur=queue.poll();
                if(res[index].equals("#")) {
                    cur.left = null;
                    index++;
                }else{
                    cur.left=new TreeNode(Integer.parseInt(res[index++]));
                    queue.add(cur.left);
                }
                if(res[index].equals("#")){
                    cur.right=null;
                    index++;
                }else{
                    cur.right=new TreeNode(Integer.parseInt(res[index++]));
                    queue.add(cur.right);
                }
            }
            return result;
        }
    }
}
