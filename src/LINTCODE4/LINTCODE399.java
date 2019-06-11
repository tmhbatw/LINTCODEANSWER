package LINTCODE4;

import static com.sun.xml.internal.ws.util.VersionUtil.compare;

public class LINTCODE399 {
    /*Description
    * 给定一组 n 个不同大小的 nuts 和 n 个不同大小的 bolts. nuts 和 bolts 一一匹配.
    * 不允许将 nut 之间互相比较, 也不允许将 bolt 之间互相比较. 也就是说, 只许将 nut 与 bolt 进行比较, 或将 bolt 与 nut 进行比较. 我们会提供一个比较函数, 用于nut和bolt的比较
    * 利用我们提供的函数, 你需要将 nuts 或者 bolts 重新排列, 使得它们按照顺序一一匹配.
    * */

    /*Solution
    * 暴力遍历试一下
    * c测试用例过了???
    * 简化可能可以快速排序试一下，但是每一次快排要进行两次（对nuts、bolts进行快排），特殊情况可能会增加复杂度
    * */

    class NBComparator {
        public int cmp(String a, String b) {
            return 0;
        }
    }

    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        for(int i=0;i<nuts.length;i++){
            for(int j=i;j<bolts.length;j++){
                if(compare.cmp(nuts[i],bolts[j])==0){
                    String temp=bolts[i];
                    bolts[i]=bolts[j];
                    bolts[j]=temp;
                    break;
                }
            }
        }
        // write your code here
    }
}
