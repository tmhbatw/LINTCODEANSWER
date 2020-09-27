package LINTCODE16;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1587 {
    /*Description
    * 现在有一个字符串，首字符代表一级分隔符，分隔不同的键值对key-value；第二个字符代表二级分隔符，
    * 分隔key和value；后面的字符串表示待处理的字符串。请给出所有的有效键值对。
    * */

    public List<List<String>> StringSeg(char[] str) {
        int length=str.length;
        char separator1=str[0],separator2=str[1];
        List<String> list=new ArrayList<>();
        List<List<String>> result=new ArrayList<>();
        for(int i=2;i<length;i++){
            if(str[i]!=separator1){
                if(str[i]==separator2){
                    while(i<length-1&&str[i+1]!=separator1){
                        i++;
                    }
                    continue;
                }
                StringBuilder sb1=new StringBuilder();
                sb1.append(str[i]);
                StringBuilder sb2=new StringBuilder();
                while(i<length-1&&str[i+1]!=separator1){
                    if(str[i+1]==separator2){
                        sb2=sb1;
                        sb1=new StringBuilder();
                        i++;
                        continue;
                    }
                    sb1.append(str[++i]);
                }
                if(sb1.length()!=0&&sb2.length()!=0){
                    List<String> res=new ArrayList<>();
                    res.add(sb2.toString());
                    res.add(sb1.toString());
                    result.add(res);
                }
            }
        }
        return result;
        //
    }

}
