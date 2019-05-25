package LINTCODE;

public class LINTCODE53 {
    public static String reverseWords(String s) {
        s+=" ";
        String result="";
        String[] res=s.split(" ");
        for(int i=res.length-1;i>0;i--){
            if(res[i].equals(""))
                continue;
            result+=res[i]+" ";
        }

        return result.substring(0,result.length()>0?result.length()-1:0);
    }


    public static void main(String[] args){
        String s="word";
        String[] ss=s.split(" ");
        System.out.println(ss[0]);
    }
}
