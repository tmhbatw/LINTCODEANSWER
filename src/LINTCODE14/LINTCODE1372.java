package LINTCODE14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE1372 {
    /*Description
    * 我们有一些二维坐标，如"(1, 3)"或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
    * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001",
    * "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
    * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
    * */

    public List ambiguousCoordinates(String S) {
        List<String> res=new ArrayList<>();
        int length=S.length();
        for(int i=1;i<=length-1;i++){
            String cur1=S.substring(0,i);
            String cur2=S.substring(i,length);
            if(cur1.length()!=1&&Integer.parseInt(cur1)==0||
                cur2.length()!=1&&Integer.parseInt(cur2)==0)
                continue;
            List<String> resCur1=getCurList(cur1);
            List<String> resCur2=getCurList(cur2);
            for(int j=0;j<resCur1.size();j++){
                String curr=resCur1.get(j);
                for(int k=0;k<resCur2.size();k++){
                    res.add(transformFormat(curr,resCur2.get(k)));
                }
            }

        }
        return res;
        //
    }

    private List<String> getCurList(String cur){
        List<String> res=new ArrayList<>();
        if(cur.length()==1){
            res.add(cur);
            return res;
        }
        int curLength=cur.length();
        if(cur.charAt(curLength-1)=='0') {
            if(cur.charAt(0)=='0')
                return res;
            res.add(cur);
            return res;
        }
        if(cur.charAt(0)=='0'){
            res.add(0+"."+cur.substring(1));
            return res;
        }
        res.add(cur);
        for(int i=1;i<curLength;i++){
            res.add(cur.substring(0,i)+'.'+cur.substring(i));
        }
        return res;
    }

    private String transformFormat(String cur1,String cur2){
        return "("+cur1+", "+cur2+")";
    }

    public static void main(String[] args){
        List res=new LINTCODE1372().ambiguousCoordinates("00011");
        for(Object cur:res)
            System.out.println(cur);
    }
}
