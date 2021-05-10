package LINTCODE3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LINTCODE262 {
    /*Description
    * 请设计一个继承人树的数据结构 MyTreeNode，需要有以下方法：
    * addNode(MyTreeNode, val)： 给某一个人下面增加一个编号为val的继承人。
    * deleteNode(MyTreeNode)：取消一个人的继承资格（但是不影响他的继承人的继承资格）
    * traverse(MyTreeNode)：查询一个人下的继承顺位情况。继承顺位采用先序遍历，即对于每个节点，先是其本身，然后按照从先到后的顺序遍历他的每个继承人。
    * 同时，你需要完成该类的一个仅接收
    * val构造函数，我们将使用其构造一个
    * val=1的节点当做继承人树的根。
    * */

    public class MyTreeNode {
        /**
         * @param val: the val of the node
         * @return: a MyTreeNode Object
         */
        boolean isDelete;
        List<MyTreeNode> list;
        int val;
        MyTreeNode(int val) {
            this.val=val;
            this.list=new ArrayList<>();
            this.isDelete=false;
            // write your code here
        }

        /**
         * @param root: the root treenode
         * @return: get the traverse of the treenode
         */
        public ArrayList<Integer> traverse(MyTreeNode root) {
            ArrayList<Integer> result=new ArrayList<>();
            Stack<MyTreeNode> stack=new Stack<>();
            stack.add(root);
            while(!stack.isEmpty()){
                MyTreeNode node=stack.pop();

                if(!isDelete) {
                    result.add(node.val);
                }
                List<MyTreeNode> list=node.list;
                for(MyTreeNode cur:list)
                    System.out.println(cur.val);
                for(int i=list.size()-1;i>=0;i--){
                    stack.add(list.get(i));
                }
            }
            return result;
            // write your code here
        }

        /**
         * @param root: the node where added
         * @param value: the added node's value
         * @return: add a node, return the node
         */
        public MyTreeNode addNode(MyTreeNode root, int value) {
            root.list.add(new MyTreeNode(value));
            return root;
            // write your code here
        }

        /**
         * @param root: the deleted node
         * @return: nothing
         */
        public void deleteNode(MyTreeNode root) {
            root.isDelete=true;
            // write your code here
        }
    }
}
