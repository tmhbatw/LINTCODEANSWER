package LINTCODE5;

public class LINTCODE417 {
    /*Description
    *Validate if a given string is numeric.
    * */

    /*Solution
    *判断是否能转化为一个daouble类型浮点数即可，如果不能则获取该异常并返回false;
    * */

    public boolean isNumber(String s) {
        try {
            Double d = Double.parseDouble(s);
        } catch (Exception e){
            return false;
        }
        return true;
        // write your code here
    }
}
