package LINTCODE12;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1186 {
    /*Description
    *TinyURL是一种URL简化服务，比如：当你输入一个URL https://lintcode.com/problems/design-tinyurl 时，
    * 它将返回一个简化的URL http://tinyurl.com/4e9iAk.
    * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。
    * 你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
    * */

    private int index=0;
    private List<String> list=new ArrayList<>();


    public String encode(String longUrl) {
        list.add(longUrl);
        return String.valueOf(index++);
        // Encodes a URL to a shortened URL.
    }


    public String decode(String shortUrl) {
        return list.get(Integer.parseInt(shortUrl));
        // Decodes a shortened URL to its original URL.
    }
}
