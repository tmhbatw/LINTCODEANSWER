package Interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class moni1 {

    static class Str{
        String s;
        public Str(String s){
            this.s=s;
        }

        @Override
        public boolean equals(Object a){
            String cur=((Str)a).s;
            int length=cur.length();
            while(length-->0){
                if(cur.equals(s))
                    return true;
                cur=cur.substring(1,cur.length())+cur.charAt(0);

            }
            return false;
        }

        @Override
        public int hashCode() {
            int res=0;
            for(int i=0;i<s.length();i++)
                res+=s.charAt(i)-'a';
            return res;
        }
    }

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        Set<Str> set=new HashSet<>();
        while(n-->0){
       //     System.out.println(s.next());
           set.add(new Str(s.next()));
        }
        System.out.println(set.size());
    }
}
