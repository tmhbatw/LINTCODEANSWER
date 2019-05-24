package LINTCODE;

public class LINTCODE49 {
    /*Description
    *给定一个只包含字母的字符串，按照先小写字母后大写字母的顺序进行排序。
    * Challenge
    * 在原地扫描一遍完成
    * */

    /*Solution
    *设置左右两个下标，分别从左到右、从右到左遍历字符数组
    * 当左下标发现大写字母且右下标发现小写字母时，交互左右下标的值
    * */

    public static void sortLetters(char[] chars)    {
        int left=0,right=chars.length-1;
        while(left<right){
            if(chars[left]>='a'){
                left++;
                continue;
            }

            if(chars[right]<='Z'){
                right--;
                continue;
            }

            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args){
        char[] c="abAcD".toCharArray();
        sortLetters((c));
        System.out.println(c[1]<='Z');
        System.out.println(new String(c));

    }

}
