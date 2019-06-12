package LINTCODE5;

public class LINTCODE418 {
    /*Description
    *Given an integer, convert it to a roman numeral.
    * */

    /*Solution
    * 设置一个数组用来存储基本罗马数字与数值之间的关系
    * 当含有三个当前罗马数字，全部输出即可
    * 4个以及9个需要考虑将小的数摆放在前面
    * 因为数值有上限，所以可以使用贪婪算法
    * */

    public String intToRoman(int n) {
        String result="";
        int[] nums=new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] s=new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i=0;i<nums.length;i++){
            while(n>=nums[i]){
                n-=nums[i];
                result+=s[i];
            }
        }
        return result;
        // write your code here
    }
}
