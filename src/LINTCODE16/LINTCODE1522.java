package LINTCODE16;

public class LINTCODE1522 {
    /*Description
    * 给定一个按升序排序的整数数组，写一个函数来搜索nums中的目标。 如果target存在，则返回其索引，否则返回-1。 但是，您不知道数组大小。
    * 您只能使用ArrayReader接口访问该数组，其中ArrayReader.get（k）返回索引为k（0-indexed）的数组元素。
    * 您可以假设数组中的所有整数都小于10000，如果您访问数组超出范围，ArrayReader.get将返回2147483647。
    * */

    static class ArrayReader{
        int[] num;
        public ArrayReader(int[] nums){
            this.num=nums;
        }

        public int get(int index){
            return index>=num.length?Integer.MAX_VALUE:num[index];
        }
    }

    public int search(ArrayReader reader, int target) {
        int left=0,right=20000;
        while(left<=right){
            int mid=left+(right-left)/2;
            int cur=reader.get(mid);
            if(cur==target)
                return mid;
            if(cur>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
        // write your code here
    }
}
