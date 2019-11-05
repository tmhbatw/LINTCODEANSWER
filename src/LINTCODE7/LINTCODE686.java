package LINTCODE7;

public class LINTCODE686 {
    public String removeExtra(String s) {
        char pre=' ';
        String res="";
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur!=' '||pre!=' '){
                res+=cur;
                pre=cur;
            }
        }
        if(res.equals(" ")) {
            return res;
        }
        if(res.charAt(res.length()-1)==' ')
            return res.substring(0,res.length()-1);
        return res;
        // write your code here
    }
}
