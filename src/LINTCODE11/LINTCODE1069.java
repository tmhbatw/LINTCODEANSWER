package LINTCODE11;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1069 {
    /*Description
    *删除注释
    * */

    public List<String> removeComments(String[] source) {
        List<String> result=new ArrayList<>();
        for(int i=0;i<source.length;i++){
            String cur=source[i];
            int length=cur.length();
            StringBuilder pre=new StringBuilder();
            for(int j=0;j<length;j++){
                if(cur.charAt(j)=='/'){
                    if(j<length-1&&cur.charAt(j+1)=='/'){  //证明为行注释
                        break;
                    }
                    if(j<length-1&&cur.charAt(j+1)=='*'){   //证明为块注释
                        j=j+2;
                        while(true){
                            if(j>cur.length()-2){
                                cur=source[++i];
                                length=cur.length();
                                j=0;
                                continue;
                            }
                            if(cur.substring(j,j+2).equals("*/")){
                                j+=1;
                                break;
                            }
                            j++;
                        }
                        continue;
                    }
                }
                pre.append(cur.charAt(j));
            }
            if(pre.length()!=0) {
                result.add(pre.toString());

            }
        }
        return result;
        // write your code here
    }
}
