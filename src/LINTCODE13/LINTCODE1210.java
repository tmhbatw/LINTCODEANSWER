package LINTCODE13;

import java.util.*;

public class LINTCODE1210 {
    /*Description
     * 给定一个整数数组，找到所有不同的可能的升序子序列，一个升序子序列的长度至少应为2。
     * */

    public List<List<Integer>> findSubsequences(int[] nums) {
        int length = nums.length;
        List<List<Integer>>[] result = new List[nums.length];
        Set<Integer> set=new HashSet<>();
        for (int i = length - 1; i >= 0; i--) {
            result[i] = new ArrayList<>();
            if(!set.contains(nums[i])){
                List<Integer> oneNumber=new ArrayList<>();
                oneNumber.add(nums[i]);
                set.add(nums[i]);
                result[i].add(oneNumber);
            }
            for (int j = i + 1; j < length; j++) {
                if (nums[i] <= nums[j]) {
                    for (List<Integer> cur : result[j]) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(nums[i]);
                        curr.addAll(cur);
                        result[i].add(curr);
                    }
                    if(nums[i]==nums[j]) {
                        break;
                    }
                }
            }
        }
        //Set<Integer> set=new HashSet<>();
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<length;i++) {
            res.addAll(result[i]);
        }
        for(int i=res.size()-1;i>=0;i--) {
            if (res.get(i).size() == 1)
                res.remove(i);
        }
        //removeDup(res);
        return res;
    }

    private void removeDup(List<List<Integer>> res) {
        Collections.sort(res,(o1,o2)->{
            for(int i1=0,i2=0;i1<o1.size()&&i2<o2.size();i1++,i2++){
                if(o1.get(i1)==o2.get(i2))
                    continue;
                return o1.get(i1)-o2.get(i2);
            }
            return o1.size()-o2.size();
        });
        for(int i=res.size()-1;i>=0;i--){
            List<Integer> cur=res.get(i);
            while(i>=1&&res.get(i-1).equals(cur)){
                res.remove(--i);
            }
        }
    }

}
/*    public List<List<Integer>> findSubsequences(int[] nums) {
        int length=nums.length;
        List<List<Integer>>[] result=new List[nums.length];
        for(int i=length-1;i>=0;i--){
            result[i]=new ArrayList<>();
            for(int j=length-1;j>i;j--){
                if(nums[i]<=nums[j]){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result[i].add(list);
                    for(List<Integer> cur:result[j]){
                        List<Integer> curr=new ArrayList<>();
                        curr.add(nums[i]);
                        curr.addAll(cur);
                        result[i].add(curr);
                    }
                }
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(List<List<Integer>> cur:result)
            res.addAll(cur);
        Collections.sort(res,(o1,o2)->{
            for(int i1=0,i2=0;i1<o1.size()&&i2<o2.size();i1++,i2++){
                if(o1.get(i1)==o2.get(i2))
                    continue;
                return o1.get(i1)-o2.get(i2);
            }
            return o1.size()-o2.size();
        });
        for(int i=res.size()-1;i>=0;i--){
            List<Integer> cur=res.get(i);
            while(i>=1&&res.get(i-1).equals(cur)){
                res.remove(--i);
            }
        }
        return res;
        // Write your code here
    }*/
