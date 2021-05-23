package LINTCODE24;

import java.text.DecimalFormat;
import java.util.*;

public class LINTCODE2393 {
    /*Description
    * 请编写代码，我们推荐使用 Iterator 类中的相关方法来遍历 ArrayList 集合。
    * 在本题的 Solution 类中有个 traverseList 方法，该方法有一个 ArrayList 类型的参数 list，
    * list 代表传入的 ArrayList 集合。该方法要遍历传入的 ArrayList 集合，并且输出遍历后的结果。
    * 请在类名为 Solution 的 traverseList 方法中 // write your code here 下面编写你的代码。
    * */

    public HashMap<Integer, String> createHashMap(int number, String str) {
        HashMap<Integer,String> result=new HashMap<>();
        result.put(number,str);
        return result;
        // writer your code here

    }

    public void traverseList(ArrayList<String> list) {
        for(String cur:list){
            System.out.println(cur);
        }
        // write your code here
    }

    public HashSet<String> createHashSet(String str1, String str2, String str3,
                                         String str4) {
        HashSet<String> result=new HashSet<>();
        result.add(str1);
        result.add(str2);
        result.add(str3);
        result.add(str4);
        // write your code here
        return result;
    }

    public Integer[] deDuplicate(Integer[] arr) {
        Set<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for(int cur:arr){
            if(!set.contains(cur))
                list.add(cur);
            set.add(cur);
        }
        Collections.sort(list);
        return list.toArray(new Integer[0]);
        // write your code here
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=Integer.parseInt(s.nextLine());
        String[] num=s.nextLine().split(" ");
        String temp=num[0];
        num[0]=num[num.length-1];
        num[num.length-1]=temp;
        for(String cur:num)
            System.out.print(cur+" ");
        // write your code here
        // read data from console

        // output the answer to the console according to the
        // requirements of the question

    }

    public ArrayList<String> createList(String str1, String str2) {
        ArrayList<String> result=new ArrayList<>();
        result.add(str1);
        result.add(str2);
        return result;
        // write your code here
    }

    public float division(int a, int b) {
        return (float)(a*1.0/b);
        // write your code here
    }

    public double area(int radius){
        return radius*radius*Math.PI;
    }

    public Integer[] deDuplicationAndSort(Integer[] arr) {
        Set<Integer> set=new HashSet<>();
        List<Integer> result=new ArrayList<>();
        for(Integer cur:arr){
            if(!set.contains(cur)){
                set.add(cur);
                result.add(cur);
            }
        }
        Collections.sort(result);
        return result.toArray(new Integer[0]);
        // write your code here
    }

    public void printHashMap(HashMap<Integer, String> map) {
        for(Map.Entry entry:map.entrySet()){
            int key=(int)(entry.getKey());
            String val=(String)(entry.getValue());
            System.out.println("key: "+key+"; value: "+val+";");
        }
        // write your code here
    }
}
