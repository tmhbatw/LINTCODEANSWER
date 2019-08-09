package LINTCODE7;

public class LINTCODE688 {

    /*Description
    * 给一个非负整数 n, 用单词打印数字
    * */

    static String twenty[]={"","one","two","three","four","five","six",
            "seven","eight","nine","ten","eleven","twelf","thirteen","fourteen",
            "fifteen","sixteen","seventeen","eighteen","ninteen"};
    static String hundred[]={"","ten","twenty","thirty","forty","fifty",
            "sixty","seventy","eighty","ninety"};
    static String bit[]={" hundred "," thousand "," million "," billion "};


    public String convertWords(int number) {
        if(number==0)
            return "zero";
        String res=getString(number);
        return res.charAt(res.length()-1)==' '?res.substring(0,res.length()-1):res;
        // Write your code here
    }

    private String getString(int num){
        if(num>=Math.pow(10,9)){
            return getString((int) (num/Math.pow(10,9)))+bit[3]+getString((int) (num%Math.pow(10,9)));
        }
        if(num>=Math.pow(10,6)){
            return getString((int)(num/Math.pow(10,6)))+bit[2]+getString((int) (num%Math.pow(10,6)));
        }
        if(num>=Math.pow(10,3)){
            return getString((int)(num/Math.pow(10,3)))+bit[1]+getString((int)(num%Math.pow(10,3)));
        }
        if(num>=Math.pow(10,2)){
            return getString((int)(num/Math.pow(10,2)))+bit[0]+getString((int)(num%Math.pow(10,2)));
        }
        if(num>=20){
            return hundred[num/10]+" "+getString(num%10);
        }
        return twenty[num];
    }
}
