package LINTCODE13;

public class LINTCODE1247 {
    /*Description
    * 给定一个非空字符串，包含用英文单词对应的数字0-9，但是字母顺序是打乱的，以升序输出数字。
    * */


    /*  zero   z            1
        one    o-two        4
        two    w            2
        three  r-four       6
        four   f-five       5
        five   v            3
        six    x            7
        seven  s-six        8
        eight  g            9
        nine   n-one-seven/2
    *
    * */

    public String originalDigits(String s) {
        char[] letter=new char[26];
        for(int i=0;i<s.length();i++)
            letter[s.charAt(i)-'a']++;
        int[] number=new int[10];
        number[0]=letter['z'-'a'];
        number[2]=letter['w'-'a'];
        number[4]=letter['u'-'a'];
        number[5]=letter['f'-'a']-number[4];
        number[1]=letter['o'-'a']-number[2]-number[0]-number[4];
        number[3]=letter['r'-'a']-number[4]-number[0];
        number[6]=letter['x'-'a'];
        number[7]=letter['s'-'a']-number[6];
        number[8]=letter['g'-'a'];
        number[9]=(letter['n'-'a']-number[1]-number[7])/2;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10;i++){
            int cur=number[i];
            while(cur-->0)
                sb.append(i);
        }
        return sb.toString();
        // write  your code here
    }
}
