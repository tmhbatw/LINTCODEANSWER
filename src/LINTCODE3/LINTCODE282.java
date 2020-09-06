package LINTCODE3;

public class LINTCODE282 {
    /*Description
    * 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串太长了，于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
    * 对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，例如字符串ABCABCABC将会被压缩为[3|ABC]，
    * 现在小A收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
    * */

    public String DecompressString(String Message) {
        StringBuilder result=new StringBuilder();
        for(int i=0;i<Message.length();i++){
            char cur=Message.charAt(i);
            if(cur=='['){
                int number=0;
                char next=Message.charAt(i+1);
                while(next<='9'&&next>='0'){
                    number=number*10+next-'0';
                    i++;
                    next=Message.charAt(i+1);
                }
                i+=2;
                int time=1;
                int end=i+1;
                while(time!=0){
                    if(Message.charAt(end)=='[')
                        time++;
                    if(Message.charAt(end)==']')
                        time--;
                    end++;
                }
                String res=DecompressString(Message.substring(i,end-1));
                for(int j=0;j<number;j++)
                    result.append(res);
                i=end-1;
            }
            else
                result.append(cur);
        }
        return result.toString();
        //
    }
}
