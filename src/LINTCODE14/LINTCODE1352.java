package LINTCODE14;

import java.util.Arrays;

public class LINTCODE1352 {
    /*Description
    * 比较两个版本号version1和version2。
    * 如果version1 > version2返回1，如果version1 < version2返回-1，否则返回0。
    * 您可以认为版本字符串是非空的并且只包含数字和 . 字符。
    * 这个 '.' 字符不表示小数点，用于分隔数字序列。
    * 例如，2.5不是“两个半”或“版本三的一半”，它是第二个第一级修订的第五个二级修订。
    * */

    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        for(int i=0;i<Math.max(v1.length,v2.length);i++){
            int vv1=i>=v1.length?0:Integer.parseInt(v1[i]);
            int vv2=i>=v2.length?0:Integer.parseInt(v2[i]);
            if(vv1!=vv2)
                return vv1>vv2?1:-1;
        }
        return 0;
    // Write your code here
    }

    public static void main(String[] args){
        String cur="1";
        String[] c=cur.split("\\.");
        System.out.println(Arrays.toString(c));
    }
}
