package LINTCODE20;

public class LINTCODE1900 {
    /*Description
    *给定两段基因片段 Gene1 和 Gene2 ,基因片段中由数字和"ACGT"四种字符组成。
    * 每一个字符前都会有相应的数字，这个数字是描述该字符连续出现的数量，例如："1A2C2G1T" 表示 "ACCGGT"。
    * 返回一个表示这两个基因片段的相似度的字符串，相似度字符串的定义是："相同位置上的字符相同个数" + "/" + "总字符个数"。
    * */

    int index1=0,index2=0;
    public String GeneSimilarity(String Gene1, String Gene2) {
        int sum=0;
        int common=0;

        int time1=0,time2=0;
        char cur1=' ',cur2=' ';
        int length1=Gene1.length();
        int length2=Gene2.length();
        while(true){
            if(time1==0){
                if(index1==Gene1.length())
                    break;
                time1=getTime1(Gene1);
                cur1=Gene1.charAt(index1++);
            }
            if(time2==0){
                if(index2==Gene2.length())
                    break;
                time2=getTime2(Gene2);
                cur2=Gene2.charAt(index2++);
            }
            int min=Math.min(time1,time2);
            if(cur1==cur2){
                common+=min;
            }
            sum+=min;
            time1-=min;
            time2-=min;
        }

        return (common)+"/"+(sum);
        // write your code here
    }

    private int getDivider(int time1,int time2){
        int max=Math.max(time1,time2);
        int min=Math.min(time1,time2);
        while(max%min!=0){
            int temp=max%min;
            max=min;
            min=temp;
            System.out.println(max+" "+min);
        }
        return min;
    }

    private int getTime2(String s){
        int time=0;
        char cur=s.charAt(index2);
        while(cur<='9'&&cur>='0'){
            time=time*10+cur-'0';
            cur=s.charAt(++index2);
        }
        return time;
    }

    private int getTime1(String s){
        int time=0;
        char cur=s.charAt(index1);
        while(cur<='9'&&cur>='0'){
            time=time*10+cur-'0';
            cur=s.charAt(++index1);
        }
        return time;
    }
}
