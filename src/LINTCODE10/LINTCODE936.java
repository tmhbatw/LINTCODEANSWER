package LINTCODE10;

public class LINTCODE936 {

    /*DescDescription *
    *输入一个英文句子，将每个单词的第一个字母改成大写字母
    **/

    public String capitalizesFirst(String s) {
        if(s.length()==0)
            return s;
        StringBuilder result= new StringBuilder();
        if(s.charAt(0)<='z'&&s.charAt(0)>='a'){
            result.append((char) (s.charAt(0) - 32));
        }else{
            result.append(s.charAt(0));
        }
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)==' '&&s.charAt(i)<='z'&&s.charAt(i)>='a'){
                result.append((char) (s.charAt(i) - 32));
            }else{
                result.append(s.charAt(i));
            }
        }
        return result.toString();
        // Write your code here
    }



}
