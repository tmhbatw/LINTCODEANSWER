package LINTCODE;

import datastructure.SVNRepo;

public class LINTCODE74 {
    /*Description
    * 代码库的版本号是从 1 到 n 的整数。某一天，有人提交了错误版本的代码，因此造成自身及之后版本的代码在单元测试中均出错。请找出第一个错误的版本号。
    * 你可以通过 isBadVersion 的接口来判断版本号 version 是否在单元测试中出错，具体接口详情和调用方法请见代码的注释部分。
    * Challenge
    * 调用 isBadVersion 的次数越少越好
    * */

    /*Solution
    *二分查找法
    * */
    public int findFirstBadVersion(int n) {
        if(!SVNRepo.isBadVersion(n-1))
            return n;
        int left=1;
        int right=n;
        while(left<=right){
            boolean temp=SVNRepo.isBadVersion((left+right)/2);
            int mid=(left+right)/2;
            if(!temp){
                left=mid+1;
                continue;
            }else if(temp&&(mid==1||!SVNRepo.isBadVersion(mid-1))){
                return mid;
            }else{
                right=mid-1;
            }

        }
        return -1;
        // write your code here
    }
}
