package LINTCODE5;

public class LINTCODE456 {
    /*Description
    * 实现一个类 ReferenceManager 包含如下两种方法
    * 1.copyValue(Node obj) 只拷贝参数obj的权值，obj和node仍然是两个指针
    * 2.copyReference(Node obj) obj和node指向同一个地方
    * */
      class Node {
      public int val;
      public Node(int val) {
          this.val = val;
      }
  }

    class ReferenceManager {
        public Node node;

        public void copyValue(Node obj) {
            node=new Node(obj.val);
            // copy value from obj to node
        }

        public void copyReference(Node obj) {
            node=obj;
            // copy reference from obj to node
        }
    }
}
