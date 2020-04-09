package LINTCODE6;

public class LINTCODE529 {
    /*Description
    * Geo哈希是一个著名的哈希算法，用于将坐标哈希成一个32位字符串
    * */

    static final char[] _base32="0123456789bcdefghjkmnpqrstuvwxyz".toCharArray();

    public String encode(double latitude, double longitude, int precision) {
        String lat=getRes(latitude,-90,90);
        String lon=getRes(longitude,-180,180);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<30;i++){
            sb.append(lon.charAt(i)).append(lat.charAt(i));
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<precision;i++){
            int index=getInt(sb.substring(i*5,i*5+5));
            result.append(_base32[index]);
        }
        return result.toString();
        // write your code here
    }

    private int getInt(String cur){
        return Integer.parseInt(cur,2);
    }

    private String getRes(double cur,double left,double right){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<30;i++){
            double mid=(left+right)/2;
            if(cur>mid){
                left=mid;
                sb.append('1');
            }else{
                right=mid;
                sb.append('0');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String abs="01010101";
        System.out.println(Integer.parseInt(abs,2));

    }
}
