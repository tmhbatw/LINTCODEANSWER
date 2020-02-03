package LINTCODE11;

public class LINTCODE1017 {
    /*Description
    *在本题中，每个大写字母代表从“0”到“f”的一些十六进制数字。
    * 红绿蓝三元色#AABBCC可以简写为#ABC。 例如，#15c是颜色#1155cc的简写。
    * 现在，假设两种颜色#ABCDEF和#UVWXYZ之间的相似性是-(AB - UV) ^ 2 - (CD - WX) ^ 2 - (EF - YZ) ^ 2。
    * 给定颜色#ABCDEF，返回与#ABCDEF最相似且含有一个简写的7字符颜色（也就是说，它可以用类似#XYZ的形式表示）
    * */

    /*Solution
    * AA,BB等都是17的倍数，那么我们只需要找到最接近的17的倍数的一个数即可
    * */

    public static String similarRGB(String color) {
        String res= "#" + getNumber(color.substring(1, 3)) + getNumber(color.substring(3, 5)) + getNumber(color.substring(5, 7));
        System.out.println(res);
        return res;
        // Write your code here
    }

    private static String getNumber(String color){
        int res=0;
        char index1=color.charAt(1);
        if(index1<='9'&&index1>='0'){
            res+=index1-'0';
        }else{
            res+=index1-'a'+10;
        }
        System.out.println(res);
        char index2=color.charAt(0);
        if(index2<='9'&&index2>='0'){
            res+=(index2-'0')*16;
        }else
            res+=(index2-'a'+10)*16;
        System.out.println(res);
        int temp=res/17;
        int cur=res-temp*17;
        if(cur>=9)
            temp+=1;
        char result;
        if(temp>=10)
            result= (char) ('a'+temp-10);
        else
            result=(char)(temp+'0');
        System.out.println(res);
        return result+""+result;
    }

    public static void main(String[] args){
        System.out.println(getNumber("d0"));
    }
}
