package LINTCODE18;

public class LINTCODE1705 {
    /*Description
    * 当字符串中最小字符的出现频率小于比较字符串中最小字符的出现频率时，一个字符串严格小于另一个字符串。
    * 例如，字符串“ abcd”小于字符串“ aaa”，因为“ abcd”中的最小字符（按字典顺序）为“ a”，频率为1，
    * 而“ aaa”中的最小字符也为“ a” '，但频率为3。在另一个示例中，字符串“ a”小于字符串“ bb”，
    * 因为“ a”中的最小字符为频率为1的“ a”，而“ bb”中的最小字符 是“ b”，频率为2。
    * 编写一个函数，给定字符串A（包含N个以'，'分隔的字符串），该函数返回N个整数的数组C。
    * 对于0 <= J < N，C [J]的值指定A中的字符串数，这些数字严格小于B中的第J个比较字符串（从0开始）。
    * */

    public int[] compareStringii(String A, String B) {
        String[] a=A.split(",");
        String[] b=B.split(",");
        int[] aFrequency=new int[11];
        for(String cur:a){
            aFrequency[getFrequency(cur)]++;
        }
        for(int i=1;i<11;i++)
            aFrequency[i]+=aFrequency[i-1];
        int[] result=new int[b.length];
        for(int i=0;i<b.length;i++){
            int curFrequency=getFrequency(b[i]);
            result[i]=aFrequency[curFrequency-1];
        }
        return result;
        // write your code here
    }

    private int getFrequency(String cur){
        int[] time=new int[26];
        for(int i=0;i<cur.length();i++){
            time[cur.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(time[i]!=0)
                return time[i];
        }
        return 0;
    }
}
