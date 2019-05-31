package LINTCODE2;

public class LINTCODE128 {
    /*Description
    * 在数据结构中，哈希函数是用来将一个字符串（或任何其他类型）转化为小于哈希表大小且大于等于零的整数。一个好的哈希函数可以尽可能少地产生冲突。一种广泛使用的哈希函数算法是使用数值33，假设任何字符串都是基于33的一个大整数，比如：
hashcode("abcd") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE
                              = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE
                              = 3595978 % HASH_SIZE
其中HASH_SIZE表示哈希表的大小(可以假设一个哈希表就是一个索引0 ~ HASH_SIZE-1的数组)。
给出一个字符串作为key和一个哈希表的大小，返回这个字符串的哈希值。
    * */

    /*Solution
    * 根据题目要求编写哈希函数即可
    * 需要注意的是结果需要用long表示
    * 且每一次循环就要取一次余数不然会溢出
    * */

    public int hashCode(char[] key, int HASH_SIZE) {
        long result=0;
        for(int i=0;i<key.length;i++) {
            result =  (result*33+key[i])%HASH_SIZE;
        }
        return (int) result;
        // write your code here
    }

}
