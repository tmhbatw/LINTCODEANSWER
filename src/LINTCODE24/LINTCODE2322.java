package LINTCODE24;

public class LINTCODE2322 {
    /*Description
    *请编写代码，使用 StringBuffer 类中的相关方法来删除字符串中指定位置的内容。
    * 在本题的 Solution 类中有个 deleteString 方法，该方法有一个 String 类型的参数 str
    * 和两个 int 类型的参数 indexStart， indexEnding。str 代表原始字符串，indexStart 代表需要删除内容的开始位置，
    * indexEnding 代表需要删除内容的结束位置。该方法要删除原始字符串中指定位置的内容，并返回删除指定内容之后的字符串，返回值为 StringBuffer 类型。
    * 请在类名为 Solution 的 deleteString 方法中 // write your code here 下面编写你的代码。
    * */

    public StringBuffer deleteString(String str, int indexStart,
                                     int indexEnding) {
        StringBuffer sb=new StringBuffer(str.substring(0,indexStart)+str.substring(indexEnding));
        return sb;
        // write your code here

    }

    public void printCharacter(PropertyEnum s) {
        switch (s) {
            case PlumBlossoms:
                System.out.println(
                        "PlumBlossoms: A noble man who explores the waves and the snow");
                break;

            case Orchid:
                System.out.println(
                        "Orchid: A sage of the world, the fragrance of the deep valley");
                break;

            case Bamboo:
                System.out.println("Bamboo: A gentleman of modesty and elegance");
                break;

            case Chrysanthemum:
                System.out.println("Chrysanthemum: A hermit of the world");
                break;
        }
    }

    public void textCharacter() {
        printCharacter(PropertyEnum.PlumBlossoms);
        printCharacter(PropertyEnum.Orchid);
        printCharacter(PropertyEnum.Bamboo);
        printCharacter(PropertyEnum.Chrysanthemum);
        // write your code here
    }

    public enum PropertyEnum {
        PlumBlossoms,
        Orchid,
        Bamboo,
        Chrysanthemum;
    }
}
