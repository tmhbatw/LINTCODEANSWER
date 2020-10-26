package LINTCODE3;

public class LINTCODE244 {
    /*Description
    * 给定一个字符串str，现在要对该字符串进行删除操作，保留字符串中的k个字符
    * 且相对位置不变，并且使它的字典序最小，返回这个子串。
    * */

    public String deleteChar(String str, int k) {
        char[] s=str.toCharArray();
        int length=s.length;
        StringBuilder sb=new StringBuilder();
        int index=0;
        for(int i=length-k;i<length;i++){
            char min=s[i];
            int curIndex=i;
            for(int j=i-1;j>=index;j--){
                if(s[j]<=min){
                    min=s[j];
                    curIndex=j;
                }
            }
            sb.append(min);
            index=curIndex+1;
        }
        return sb.toString();
        // Write your code here.
    }



    //此方法为从源字符串进行减字符操作的方法，超时
/*    public String deleteChar(String str, int k) {
        int cut=str.length()-k;  //设为需要删除的字符个数
        StringBuilder result=new StringBuilder();
        getResult(str,cut,result);
        return result.toString();
        // Write your code here.
    }

    private void getResult(String str,int cut,StringBuilder sb){
        if(str.length()==cut){
            return;
        }
        int index=0;
        char min=str.charAt(0);
        if(min=='a'){
            sb.append('a');
            getResult(str.substring(1),cut,sb);
            return;
        }
        for(int i=1;i<cut+1;i++){
            if(str.charAt(i)<min){
                index=i;
                min=str.charAt(i);
                if(min=='a'){
                    break;
                }
            }
        }
        getResult(str.substring(index+1),cut-index,sb.append(min));
    }*/
}
