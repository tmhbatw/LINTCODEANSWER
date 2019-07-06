package LINTCODE4;

import java.util.ArrayList;

public class LINTCODE385 {

    /*Description
    * y用ArrayList实现一些操作
    * */

    /**
     * @param n: You should generate an array list of n elements.
     * @return: The array list your just created.
     */
    public static ArrayList<Integer> create(int n) {
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<=n-1;i++){
            result.add(i);
        }
        return result;
        // Write your code here
    }

    /**
     * @param list: The list you need to clone
     * @return: A deep copyed array list from the given list
     */
    public static ArrayList<Integer> clone(ArrayList<Integer> list) {
        ArrayList<Integer> result=new ArrayList<>();
        result.addAll(list);
        return result;
        // Write your code here
    }

    /**
     * @param list: The array list to find the kth element
     * @param k: Find the kth element
     * @return: The kth element
     */
    public static int get(ArrayList<Integer> list, int k) {
        return list.get(k);
        // Write your code here
    }

    /**
     * @param list: The array list
     * @param k: Find the kth element, set it to val
     * @param val: Find the kth element, set it to val
     */
    public static void set(ArrayList<Integer> list, int k, int val) {
        list.remove(k);
        list.set(k,val);
        // write your code here
    }

    /**
     * @param list: The array list to remove the kth element
     * @param k: Remove the kth element
     */
    public static void remove(ArrayList<Integer> list, int k) {
        list.remove(k);
        // write tour code here
    }

    /**
     * @param list: The array list.
     * @param val: Get the index of the first element that equals to val
     * @return: Return the index of that element
     */
    public static int indexOf(ArrayList<Integer> list, int val) {
        return list.indexOf(new Integer(val));
        // Write your code here
    }
}
