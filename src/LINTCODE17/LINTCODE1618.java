package LINTCODE17;


import javax.xml.soap.SAAJMetaFactory;
import java.util.ArrayList;
import java.util.List;

public class LINTCODE1618 {
    /*Description
    * 给定一个csv文件，使用vector来表示，每一个string均包含m个单词，表示csv文件的某一行，
    * 现在要求将文件每一列的单词右对齐，输出新的csv文件(返回vector)
    * */

    public List<String> processingFile(List<String> a) {
        List<List<String>> list=new ArrayList<>();
        for(String cur:a){
            String[] s=cur.split(",");
            List<String> curList=new ArrayList<>();
            for(String curS:s)
                curList.add(curS);
            list.add(curList);
        }
        List<StringBuilder> res=new ArrayList<>();
        for(int i=0;i<a.size();i++)
            res.add(new StringBuilder());
        for(int i=0;i<list.get(0).size();i++){
            int length=0;
            for(int j=0;j<list.size();j++){
                length=Math.max(list.get(j).get(i).length(),length);
            }
            for(int j=0;j<list.size();j++){
                StringBuilder cur=res.get(j);
                String curr=list.get(j).get(i);
                cur.append(append(curr,length-curr.length())).append(",");
            }

        }
        List<String> result=new ArrayList<>();
        for(int i=0;i<res.size();i++){
            String cur=res.get(i).toString();
            result.add(cur.substring(0,cur.length()-1));
        }
        return result;
        // Write your code here
    }

    private String append(String cur,int length){
        for(int i=0;i<length;i++)
            cur=" "+cur;
        return cur;
    }

    public static void main(String[] args){
        List<StringBuilder> list=new ArrayList<>();
        list.add(new StringBuilder("abc"));
        System.out.println(list.get(0).toString());
        StringBuilder sb=list.get(0);
        sb.append("abc");
        System.out.println(list.get(0).toString());
    }
}
