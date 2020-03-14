package LINTCODE15;

public class LINTCODE1452 {
    /*Description
    * 我们有一个由小写字母构成的字符串S和一个整数数组shifts。
    * 定义shift位移，使该字母变为在字母表中的下一个字母，（'z'的下一个字母为'a'）。
    * 例如，shift（'a'）='b'，shift（'t'）='u'，shift（'z'）='a'。
    * 现在对于每个 shifts[i] = x，我们想要shift位移S的前i + 1个字母，x次。
    * 在应用所有这些转换到S之后返回最后一个字符串。
    * */

    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder sb=new StringBuilder();
        for(int j=shifts.length-2;j>=0;j--){
            shifts[j]=(shifts[j]+shifts[j+1])%26;
        }
        for(int i=0;i<S.length();i++){
            char cur=S.charAt(i);
            int curNumber=(cur-'a'+shifts[i])%26;
            sb.append((char)(curNumber+'a'));
        }
        return sb.toString();
        // Write your code here.
    }
}
