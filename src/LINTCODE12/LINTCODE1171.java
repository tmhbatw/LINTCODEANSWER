package LINTCODE12;

public class LINTCODE1171 {
    /*Description
    * 给定整数n，找出最接近n（不包括自身）的回文整数。最接近是指绝对值差最小。
    * */

    public String nearestPalindromic(String n) {
        if(n.equals("0"))
            return "1";
        String big=getBig(n);
        String small=getSmall(n);
        System.out.println(big+" "+small);
        if(Long.parseLong(big)-Long.parseLong(n)<Long.parseLong(n)-Long.parseLong(small))
            return big;
        return small;
        // Write your code here
    }

    private String getSmall(String n){
        int length=n.length();
        boolean preBig = isPreBig(n,true);
        StringBuilder sb=new StringBuilder();
        if(!preBig){
            //拷贝一份前半部分的副本
            String pre=n.substring(0,length/2);
            sb.append(pre);
            if(length%2==1)
                sb.append(n.charAt(length/2));
            sb.append(new StringBuilder(pre).reverse());
        }else{
           if(isSmallSpecial(n))
               return smallSpecial(n);
           String pre=n.substring(0,(length+1)/2);
           String smallOne=smallOne(pre);
            nextOne(length, sb, pre, smallOne);
        }
        return sb.toString();
    }

    private String smallOne(String n){
        return (Long.parseLong(n)-1)+"";
    }

    private String getBig(String n){
        int length=n.length();
        boolean preBig=isPreBig(n,false);
        StringBuilder sb=new StringBuilder();
        if(preBig){
            //拷贝一份前半部分的副本
            String pre=n.substring(0,length/2);
            sb.append(pre);
            if(length%2==1)
                sb.append(n.charAt(length/2));
            sb.append(new StringBuilder(pre).reverse());
        }else{
            //可能存在的特殊情况（全9）
            if(isAddSpecial(n))
                return addSpecial(n);
            //前半部分与中间位需要加1
            String pre=n.substring(0,(length+1)/2);
            String addOne=addOne(pre);
            nextOne(length, sb, pre, addOne);
        }
        return sb.toString();
    }

    private void nextOne(int length, StringBuilder sb, String pre, String addOne) {
        sb.append(addOne);
        int start=length%2==1?pre.length()-1:pre.length();
        for(int i=start-1;i>=0;i--){
            sb.append(addOne.charAt(i));
        }
    }

    private String smallSpecial(String n){
        int nineLength=n.length()-1;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<nineLength;i++){
            sb.append("9");
        }
        return sb.toString();
    }

    private boolean isSmallSpecial(String n){
        if(n.charAt(0)!='1'||n.length()==1)
            return false;
        for(int i=1;i<(n.length()+1)/2;i++){
            if(n.charAt(i)!='0')
                return false;
        }
        return true;
    }

    private String addSpecial(String n){
        int zeroLength=n.length()-1;
        StringBuilder sb=new StringBuilder();
        sb.append("1");
        for(int i=0;i<zeroLength;i++)
            sb.append("0");
        sb.append("1");
        return sb.toString();
    }

    private boolean isAddSpecial(String n){
        for(int i=0;i<(n.length()+1)/2;i++){
            if(n.charAt(i)!='9')
                return false;
        }
        return true;
    }

    private boolean isPreBig(String n, boolean getBigOne){
        int preLength=n.length()/2;
        for(int j=preLength-1;j>=0;j--){
            char post=n.charAt(n.length()-1-j);
            char pre=n.charAt(j);
            if(post>pre){
                return false;
            }
            if(post<pre)
                return true;
        }
        return getBigOne;
    }

    private String addOne(String n){
        StringBuilder sb=new StringBuilder();
        int add=1;
        for(int j=n.length()-1;j>=0;j--){
            int cur=n.charAt(j)-'0'+add;
            add=cur/10;
            cur%=10;
            sb.append(cur);
        }
        if(add==1)
            sb.append(add);
        return sb.reverse().toString();
    }


    public static void main(String[] args){
        String test="88";
        System.out.println(new LINTCODE1171().nearestPalindromic(test));
    }
}
