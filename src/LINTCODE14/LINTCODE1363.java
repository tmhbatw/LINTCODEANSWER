package LINTCODE14;

public class LINTCODE1363 {
    /*Description
    * 给定一个字符串 s 和一个整数 numRows. 你需要把 s 排布成一个 numRows 行的 "之" 字形. 然后返回逐行阅读的结果.
    * 注意, "之" 字形是按照 下->右上->下->右上...的方向延伸的.
    * */

    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        int groupNumber=numRows*2-2;
        StringBuilder sb=new StringBuilder();
        int length=s.length();
        char[] c=s.toCharArray();
        for(int i=0;i<length;i+=groupNumber)
            sb.append(c[i]);
        for(int i=1;i<numRows-1;i++){
            for(int j=0;j<length;j+=groupNumber){
                if(j+i<length)
                    sb.append(c[j+i]);
                if(j+groupNumber-i<length)
                    sb.append(c[j+groupNumber-i]);
            }
        }
        for(int i=numRows-1;i<length;i+=groupNumber)
            sb.append(c[i]);
        return sb.toString();
        // Write your code here
    }
}
