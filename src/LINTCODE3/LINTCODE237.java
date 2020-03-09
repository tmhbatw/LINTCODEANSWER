package LINTCODE3;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE237 {
    /*Description
    *在数组 A 中，包含 0 到 n 的整数，其中缺失了一个数。在这一问题中，我们难以仅用一个操作审查数组 A 中的所有整数。
    * A 中的元素用二进制表示，而唯一可实现的操作是使用固定时间的操作 - "fetch the jth bit of A[i]" 。请编写代码，
    * 以查找数组中缺失的整数。你可以在 O(n) 的时间复杂度实现吗？
    * */


    static public class BitInteger {
        public static int INTEGER_SIZE = 31;
        public int fetch(int j) {
          return 0; // return 0 or 1, fetch the jth bit of this number
        }
    }

    class Solution {
        /**
         * @param array a BitInteger list
         * @return an integer
         */
        public int findMissing(ArrayList<BitInteger> array) {
            return findMissing(array, 0);
        }

        private int findMissing(List<BitInteger> array, int bitIndex) {
            if (bitIndex == BitInteger.INTEGER_SIZE) {
                return 0;
            }
            List<BitInteger> zeroBitIntegers = new ArrayList<>();
            List<BitInteger> oneBitIntegers = new ArrayList<>();

            for (BitInteger num : array) {
                if (num.fetch(bitIndex) == 1) {
                    oneBitIntegers.add(num);
                } else {
                    zeroBitIntegers.add(num);
                }
            }

            if (oneBitIntegers.size() >= zeroBitIntegers.size()) {
                return (findMissing(zeroBitIntegers, bitIndex + 1) << 1);
            } else {
                return (findMissing(oneBitIntegers, bitIndex + 1) << 1) + 1;
            }
        }
    }
}
