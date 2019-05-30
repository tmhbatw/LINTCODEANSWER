package LINTCODE1;

public class LINTCODE12{
    /*Description
    实现一个栈, 支持以下操作:
    push(val) 将 val 压入栈
    pop() 将栈顶元素弹出, 并返回这个弹出的元素
    min() 返回栈中元素的最小值
    要求 O(1) 开销.
    * */

    /*Solution
    * 在对象中创建一个数组用来保存所有的数字，一个最小值标识栈中的最小值
    * 需要注意的是当最小值被弹出后需要重新确定数组中的最小值
    * 如下方法可以超越90%以上的算法
    * */

    int[] nums=new int[100];//存储数据
    int min=Integer.MAX_VALUE;//存储最小值
    int flag=0;//存储此时数组的下标
    public LINTCODE12() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        nums[flag++]=number;
        min=Math.min(min,number);
        // write your code here
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if(min==nums[flag-1]) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < flag - 1; i++) {
                min = Math.min(min, nums[i]);
            }
        }
        return nums[--flag];
        // write your code here
    }

    /*
     * @return: An integer
     */
    public int min() {
        return min;
        // write your code here
    }
}
