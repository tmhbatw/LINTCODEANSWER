package LINTCODE9;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE852 {
    /*Description
    * 给定一个启动IP地址ip和一些ips我们需要覆盖n，返回一个范围的表示作为CIDR块的列表（最小可能长度）。
    * CIDR块是由IP组成的字符串，后跟斜杠，然后是前缀长度。 例如：“123.45.67.89/20”。 该前缀长度“20”表示指定范围内的公共前缀位数。
    * */

    public List<String> ipToCIDR(String ip, int range) {
        long x = 0;
        String[] ips = ip.split("\\.");
        for (int i = 0; i < ips.length; ++i) {
            x = Integer.parseInt(ips[i]) + x * 256;
        }

        List<String> ans = new ArrayList<>();
        while (range > 0) {
            long step = x & -x;
            while (step > range) step /= 2;
            ans.add(function(x, (int) step));
            x += step;
            range -= step;
        }

        return ans;
    }

    private String function(long x, int step) {
        int[] ans = new int[4];
        ans[0] = (int) (x & 255);
        x >>= 8;
        ans[1] = (int) (x & 255);
        x >>= 8;
        ans[2] = (int) (x & 255);
        x >>= 8;
        ans[3] = (int) x;
        int len = 33;
        while (step > 0) {
            len--;
            step /= 2;
        }
        return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + len;
    }
}
