package LINTCODE3;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE232 {
    /*Description
    * 给出一个长网址，返回一个短网址。
    * 你需要实现两个方法：
    * longToShort(url) 把一个长网址转换成一个以http://tiny.url/开头的短网址
    * shortToLong(url) 把一个短网址转换成一个长网址
    * 你可以任意设计算法，评测只关心两件事：
    * 短网址的key的长度应该等于6 （不算域名和反斜杠）。 可以使用的字符只有 [a-zA-Z0-9]. 比如: abcD9E
    * 任意两个长的url不会对应成同一个短url，反之亦然。
    * */

    class TinyUrl {
        /*
         * @param url: a long url
         * @return: a short url starts with http://tiny.url/
         */
        Map<String,String> longToShortMap=new HashMap<>();
        Map<String,String> shortToLongMap=new HashMap<>();
        int[] keyIndex=new int[]{0,0,0,0,0,0};
        char[] key=new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m',
                                'n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J',
                                'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        private String getShortURl(){
            int curIndex=0;
            while(keyIndex[curIndex]==61){
                keyIndex[curIndex++]=0;
            }
            keyIndex[curIndex]++;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<6;i++)
                sb.append(key[keyIndex[i]]);
            return sb.toString();
        }

        public String longToShort(String url) {
            if(!longToShortMap.containsKey(url)){
                String shortURL="http://tiny.url/"+getShortURl();
                longToShortMap.put(url,shortURL);
                shortToLongMap.put(shortURL,url);
            }
            return longToShortMap.get(url);
            // write your code here
        }

        /*
         * @param url: a short url starts with http://tiny.url/
         * @return: a long url
         */
        public String shortToLong(String url) {
            return shortToLongMap.get(url);
            // write your code here
        }
    }
}
