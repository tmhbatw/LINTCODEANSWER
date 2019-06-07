package LINTCODE3;

import java.util.Stack;

public class LINTCODE227 {
    /*Description
    * 用栈模拟汉诺塔
    * */

    /*Solution
    * 经典问题
    * */

    private Stack<Integer> disks;

    public LINTCODE227(int i) {
        disks=new Stack<>();
        // create three towers
    }

    /*
     * @param d: An integer
     * @return: nothing
     */
    public void add(int d) {
        // Add a disk into this tower
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    /*
     * @param t: a tower
     * @return: nothing
     */
    public void moveTopTo(LINTCODE227 t) {
        t.add(disks.pop());
        // Move the top disk of this tower to the top of t.
    }

    /*
     * @param n: An integer
     * @param destination: a tower
     * @param buffer: a tower
     * @return: nothing
     */
    public void moveDisks(int n, LINTCODE227 destination, LINTCODE227 buffer) {
        if(n>0){
            moveDisks(n-1,buffer,destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1,destination,this);
        }
        // Move n Disks from this tower to destination by buffer tower
    }

    /*
     * @return: Disks
     */
    public Stack<Integer> getDisks() {
        // write your code here
        return disks;
    }
}
