package LINTCODE13;

public class LINTCODE1248 {
    /*Description
    *给定一个非空数组，a0，a1，a2，…，an-1，其中 0 ≤ ai < 2^31。
    *找出 ai XOR aj的最大结果，其中 0 ≤ i, j < n。
    * */

/*    public int findMaximumXOR(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                result=Math.max(nums[i]^nums[j],result);
            }
        }
        return result;
        // Write your code here
    }*/

    public int findMaximumXOR(int[] nums) {
        TrieNode root=new TrieNode();
        for(int cur:nums){
            //构建一颗字典树
            insert(root,cur);
        }
        int result=0;
        for(int cur:nums){
            //判断每个数的最大值
            result=Math.max(result,getVal(root,cur));
        }
        return result;
    }

    private int getVal(TrieNode root,int cur){
        int result=0;
        for(int i=30;i>=0;i--){
            int index=(1-((cur>>i)&1));
            if(root.trieNodes[index]!=null){
                result+=1<<i;
                root=root.trieNodes[index];
            }else{
                root=root.trieNodes[1-index];
            }
        }
        return result;
    }

    private void insert(TrieNode root,int cur){
        for(int i=30;i>=0;i--){
            int index=(cur>>i)&1;
            if(root.trieNodes[index]==null)
                root.trieNodes[index]=new TrieNode();
            root=root.trieNodes[index];
        }
    }

    public class TrieNode{
        TrieNode[] trieNodes=new TrieNode[2];
    }
}
