package LINTCODE17;

public class LINTCODE1602 {
    /*Description
    * 给定一个编码字符串 S。为了找出解码字符串并将其写入磁带，从编码字符串中每次读取一个字符，并采取以下步骤：
    * 如果所读的字符是字母，则将该字母写在磁带上。
    * 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
    * 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
    * */

    public String decodeAtIndex(String S, int K) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<S.length();i++){
            char cur=S.charAt(i);
            if(cur<='9'&&cur>='0'){
                int curr=cur-'0';
                StringBuilder curSb=new StringBuilder(sb);
                while(--curr>0){
                    sb.append(curSb);
                }
            }else
                sb.append(cur);
            if(sb.length()>=K)
                return sb.charAt(K-1)+"";
        }
        return sb.charAt(K-1)+"";
        // Write your code here.
    }
}
