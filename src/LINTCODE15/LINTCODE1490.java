package LINTCODE15;

import java.util.*;

public class LINTCODE1490 {
    /*Description
    * 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
    * 给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
    * */

    class Node{
        char[] cur;
        int index;
        public Node(char[] cur,int index){
            this.cur=cur;
            this.index=index;
        }
    }

    public int kSimilarity(String A, String B) {
        if(!isEquals(A,B))
            return -1;
        Set<String> set=new HashSet<>();
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(A.toCharArray(),0));
        int length=A.length();
        int dis=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++) {
                Node cur = q.poll();
                char[] c=cur.cur;
                int index=cur.index;
                for(;index<length;index++){
                    if(c[index]!=B.charAt(index)){
                        char target=B.charAt(index);
                        for(int j=index+1;j<length;j++){
                            if(c[j]==target){
                                char[] cc=c.clone();
                                cc[j]=cc[index];
                                cc[index]=target;
                                if(set.contains(new String(cc)))
                                    continue;
                                set.add(new String(cc));
                                q.add(new Node(cc,index+1));
                            }
                        }
                        break;
                    }
                }
                if(index==length)
                    return dis;
            }
            dis++;
        }
        return -1;
        // Write your code here
    }

    private boolean isEquals(String a, String b){
        char[] A=a.toCharArray(), B=b.toCharArray();
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<A.length;i++){
            if(A[i]!=B[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        String A="cdebcdeadedaaaebfbcf";
        String B="baaddacfedebefdabecc";
        System.out.println(new LINTCODE1490().kSimilarity(A,B));
    }

}
