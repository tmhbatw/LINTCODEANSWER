package LINTCODE6;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param n: a positive integer
     * @param k: a positive integer
     * @return: a Solution object
     */

    int[] num;
    List<Integer> list;
    int k;
    int n;

    public Solution(int n,int k){
        this.k = k;
        this.n = n;
        this.num= new int[n];
        this.list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
            num[i]=-1;
        }
    }
    public static Solution create(int n, int k) {
        Solution s=new Solution(n,k);
        return s;
        // Write your code here
    }

    /*
     * @param machine_id: An integer
     * @return: a list of shard ids
     */
    public List<Integer> addMachine(int machine_id) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<k;i++){
            int index= (int) (Math.random()*list.size());
            int cur = list.get(index);
            list.set(index,list.get(list.size()-1));
            list.remove(list.size()-1);
            num[cur]=machine_id;
            res.add(cur);
        }
        return res;
        // write your code here
    }

    /*
     * @param hashcode: An integer
     * @return: A machine id
     */
    public int getMachineIdByHashCode(int hashcode) {
        hashcode%=n;
        for(int i=hashcode;i<hashcode+n;i++){
            int index = i%n;
            if(num[index]!=-1)
                return num[index];
        }
        return -1;
        // write your code here
    }
}
