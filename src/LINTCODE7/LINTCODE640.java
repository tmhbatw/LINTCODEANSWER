package LINTCODE7;

public class LINTCODE640 {

    /*Description
    * 给你两个字符串 S 和 T, 判断他们是否只差一步编辑。
    * */
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t))
            return false;
        if(s.length()<t.length()){
            String temp=s;
            s=t;
            t=temp;
        }
        if(s.length()-t.length()>=2)
            return false;
        if(s.length()==t.length()){
            boolean count=true;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=t.charAt(i)){
                    if(count)
                        count=false;
                    else
                        return false;
                }
            }
            return true;
        }
        int index=0;
        boolean res=true;
        for(int i=0;i<s.length();i++){
            if(index!=t.length()&&s.charAt(i)!=t.charAt(index)){
                if(res){
                    res=false;
                    continue;
                }else
                    return false;
            }
            index++;
        }
        return true;
        // write your code here
    }
}
