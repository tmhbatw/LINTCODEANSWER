package LINTCODE6;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE522 {
    /*Description
    * 实现一个顾客短网址，使得顾客可以创立他们自己的短网址. 也就是说, 你需要在 232. 短网址 的基础上再实现一个 createCustom.
    * 你需要实现三个方法：
    * longToShort(url) 把一个长网址转换成一个以http://tiny.url/开头的短网址
    * shortToLong(url) 把一个短网址转换成一个长网址
    * createCustom(url, key) 设定一个长网址的短网址为 http://tiny.url/ + key
    * 你可以任意设计算法，评测只关心：
    * longToShort 生成的短网址的key的长度应该等于6 （不算域名和反斜杠）。 可以使用的字符只有 [a-zA-Z0-9]. 比如: abcD9E
    * 任意两个长的url不会对应成同一个短url，反之亦然。
    * 如果 createCustom 不能完成用户期望的设定, 那么应该返回 "error", 反之如果成功将长网址与短网址对应, 应该返回这个短网址.
    * */

    public class TinyUrl2 {
        /*
         * @param long_url: a long url
         * @param key: a short key
         * @return: a short url starts with http://tiny.url/
         */
        String pre="http://tiny.url/";
        Map<String,String> longToShort=new HashMap<>();
        Map<String,String> shortToLong=new HashMap<>();
        String s="qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
        int[] index=new int[6];
        public String createCustom(String long_url, String key) {
            if(longToShort.containsKey(long_url)){
                if(longToShort.get(long_url).equals(pre+key))
                    return pre+key;
                return "error";
            }
            if(shortToLong.containsKey(pre+key)) {
                if(shortToLong.get(pre+key).equals(long_url))
                    return pre+key;
                return "error";
            }
            String res=pre+key;
            longToShort.put(long_url,res);
            shortToLong.put(res,long_url);
            return res;
            // write your code here
        }

        /*
         * @param long_url: a long url
         * @return: a short url starts with http://tiny.url/
         */
        public String longToShort(String long_url) {
            if(longToShort.containsKey(long_url))
                return longToShort.get(long_url);
            String key="";
            for(int i=0;i<6;i++)
                key+=s.charAt(index[i]);
            addIndex();
            key=pre+key;
            longToShort.put(long_url,key);
            shortToLong.put(key,long_url);
            return key;
            // write your code here
        }

        /*
         * @param short_url: a short url starts with http://tiny.url/
         * @return: a long url
         */
        public String shortToLong(String short_url) {
            return shortToLong.get(short_url);
            // write your code here
        }

        private void addIndex(){
            index[5]++;
            int i=5;
            while(index[i]==62){
                index[i]=0;
                index[--i]++;
            }
        }
    }
}
