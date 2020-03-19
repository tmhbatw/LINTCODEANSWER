package LINTCODE3;

public class LINTCODE224 {
    /*Description
    * 用一个数组实现三个栈。你可以假设这三个栈都一样大并且足够大。你不需要担心如果一个栈满了之后怎么办。
    * */

    class ThreeStacks {
        /*
         * @param size: An integer
         */
        int[] num;
        int startOne;
        int oneIndex;
        int startTwo;
        int twoIndex;
        int startThree;
        int threeIndex;
        public ThreeStacks(int size) {
            num=new int[size*3];
            startOne=oneIndex=0;
            startTwo=twoIndex=size;
            startThree=threeIndex=size*2;
            // do intialization if necessary
        }

        /*
         * @param stackNum: An integer
         * @param value: An integer
         * @return: nothing
         */
        public void push(int stackNum, int value) {
            switch (stackNum){
                case 0:
                    num[oneIndex++]=value;
                    break;
                case 1:
                    num[twoIndex++]=value;
                    break;
                default:
                    num[threeIndex++]=value;
            }
            // Push value into stackNum stack
        }

        /*
         * @param stackNum: An integer
         * @return: the top element
         */
        public int pop(int stackNum) {
            switch ((stackNum)){
                case 0:
                    return num[--oneIndex];
                case 1:
                    return num[--twoIndex];
                default:
                    return num[--threeIndex];
            }
            // Pop and return the top element from stackNum stack
        }

        /*
         * @param stackNum: An integer
         * @return: the top element
         */
        public int peek(int stackNum) {
            switch (stackNum){
                case 0:
                    return num[oneIndex-1];
                case 1:
                    return num[twoIndex-1];
                default:
                    return num[threeIndex-1];
            }
            // Return the top element
        }

        /*
         * @param stackNum: An integer
         * @return: true if the stack is empty else false
         */
        public boolean isEmpty(int stackNum) {
            switch (stackNum){
                case 0:
                    return oneIndex==startOne;
                case 1:
                    return twoIndex==startTwo;
                default:
                    return threeIndex==startThree;
            }
            // write your code here
        }
    }
}
