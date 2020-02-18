package LINTCODE12;

public class LINTCODE1176 {
    /*Description
    给定一个正整数列表，相邻的整数会执行浮点数除法，例如[2, 3, 4]->2 / 3 /4。
    请在任意位置加入任意数量的括号，以此改变运算优先级。找出如何加括号能使结果最大，以字符串的形式返回表达式。注意：表达式不要包括多余的括号。
    * */

    public String optimalDivision(int[] nums) {
        if(nums.length==0)
            return null;
        if(nums.length==1)
            return String.valueOf(nums[0]);
        if(nums.length==2)
            return nums[0]+"/"+nums[1];
        StringBuilder sb=new StringBuilder(nums[0]+"/");
        sb.append("(");
        sb.append(nums[1]);
        for(int i=2;i<nums.length;i++)
            sb.append("/"+nums[i]);
        return sb.append(")").toString();
        // Write your code here
    }
}
