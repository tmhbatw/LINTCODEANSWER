package LINTCODE2;

public class LINTCODE146 {
    /*Description
    * Implement an upper method to convert all characters in a string to uppercase.
    * The characters not in alphabet don't need to convert.
    * */

    /*Solution
    * 阿斯克码转化
    * */

    public String lowercaseToUppercase2(String str) {
        String result="";
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            if(curr<='z'&&curr>='a'){
                curr=(char)(curr-32);
            }
            result+=curr;
        }
        return result;
        // write your code here
    }

    public static void main(String[] args){
        String res="a23";
        char curr=res.charAt(0);
        curr= (char) (curr-32);
        System.out.println(curr);
    }


}
