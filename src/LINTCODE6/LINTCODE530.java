package LINTCODE6;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE530 {
    /*Description
    * 这题是 Geohash的加强版
    * 将一个字符串用Geohash的逆运算求出latitude和longitude
    * Geohash细节见帮助Geohash或者wiki GeoHash
    * */

    public double[] decode(String geohash) {
        String _base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<32;i++)
            map.put(_base32.charAt(i),i);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<geohash.length();i++)
            sb.append(getValue(map.get(geohash.charAt(i))));
        StringBuilder lonStr=new StringBuilder(),latStr=new StringBuilder();
        int length=sb.length();
        for(int i=0;i<length-1;i+=2){
            lonStr.append(sb.charAt(i));
            latStr.append(sb.charAt(i+1));
        }
        if(length%2==1)
            lonStr.append(sb.charAt(length-1));
        double leftLong=-180,rightLong=180;
        for(int i=0;i<lonStr.length();i++){
            double mid=(leftLong+rightLong)/2;
            if(lonStr.charAt(i)=='1'){
                leftLong=mid;
            }else
                rightLong=mid;
        }
        double leftLat=-90,rightLat=90;
        for(int i=0;i<latStr.length();i++){
            double mid=(leftLat+rightLat)/2;
            if(latStr.charAt(i)=='1'){
                leftLat=mid;
            }else
                rightLat=mid;
        }
        double[] result=new double[2];
        result[0]=(leftLat+rightLat)/2;
        result[1]=(leftLong+rightLong)/2;
        return result;
        // write your code here
    }

    private String getValue(int cur){
        int[] value=new int[5];
        int index=4;
        while(cur>0){
            value[index]=cur%2;
            cur/=2;
            index--;
        }
        StringBuilder res=new StringBuilder();
        for(int num:value)
            res.append(num);
        return res.toString();
    }
}
