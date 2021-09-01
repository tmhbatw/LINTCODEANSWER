package LINTCODE6;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LINTCODE523 {
    /*Description
    *解析html页面，提取其中的url。
    * */

    public List<String> parseUrls(String content) {
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("href\\s*=\\s*[\"|']([^\"'>\\s]+)",Pattern.CASE_INSENSITIVE)
                .matcher(content);
        while (m.find()) {
            //allMatches.add(m.group(0));
            String url = m.group(1);
            if (url.length() == 0 || url.startsWith("#"))
                continue;
            allMatches.add(url);
        }
        return allMatches;
    }
}
