package LINTCODE9;

public class LINTCODE888 {
    /*Description
    * 给定一个单词序列，检查它是否构成一个有效单词广场。
    * 一个有效的单词广场应满足以下条件：对于满足0≤k<max(numRows numColumns)的k，第k行和第k列对应的字符串应该相同,。
    * */

    /*Solution
    * 判断是否为对称矩阵即可
    * */

    public boolean validWordSquare(String[] words) {
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[i].charAt(j)!=words[j].charAt(i))
                    return false;
            }
        }
        return true;
        // Write your code here
    }
}
