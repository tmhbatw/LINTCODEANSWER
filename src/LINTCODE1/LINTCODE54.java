package LINTCODE1;

public class LINTCODE54 {
    /*Description
    * Implement function atoi to convert a string to an integer.
    * If no valid conversion could be performed, a zero value is returned.
    * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
    * */

    /*Solution
    注意只是输出一个合法的整数，而不是将字符串转化！
    * 将最先出现的（可以含有一个正号或符号）的连续数字字符串输入到既定的字符数组中
    * 求得该连续数字字符串数组的值并输出即可
    * */


    public int atoi(String str) {
        int[] result=new int[11];//int型可以表示的最大、最小数为10位，创建一个11位字符数组足矣
        int index=0;
        boolean positive=true;//保存该整数的符号位
        //先将不是数字以及符号的字符过滤掉,并将可能出现的符号输入到结果字符数组中
        for(;index<str.length();index++){
            char curr=str.charAt(index);
            if(curr=='+'){
                index++;
                break;
            }else if(curr=='-'){
                positive=false;
                index++;
                break;
            }
            else if(curr<='9'&&curr>='1'){
                break;
            }
        }
        //将可能出现的非数情况排除
        if(index==str.length())
            return 0;
        int num=0;
        //将数字保存到结果字符串数组中
        for(;index<str.length()&&num<=10;index++){
            char curr=str.charAt(index);
            if(curr=='0'&&num==0)
                continue;
            if(curr<='9'&&curr>='0'){
                result[num++]=curr-'0';
                continue;
            }
            break;
        }
        if(num==0)
            return 0;
        int res=0;
        for(int i=0;i<num;i++){
            if(positive&&(res > 214748364 || (res == 214748364 && result[i] >= 7))) {
                return Integer.MAX_VALUE;
            }else if(!positive&&(res > 214748364 || (res == 214748364 && result[i]  >= 8))){
                return Integer.MIN_VALUE;
            }
            res=res*10+(result[i]);

        }
        if(positive)
            return res;
        return -res;
    }

}
