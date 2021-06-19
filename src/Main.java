import datastructure.TreeNode;

import java.util.Stack;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Main {

    public class ZeroEvenOdd {
        // you can delcare any attributes here if you need
        // -- write your code here --

        int n;
        Semaphore zeroSemaphore;
        Semaphore oddSemaphore;
        Semaphore evenSemaphore;
        public ZeroEvenOdd(int n) {
            // n represents the sequence size you need to print
            // if n = 2, your code should call the following method one by one
            // printZero(0)
            // printOdd(1)
            // printZero(0)
            // printEven(2)
            // you can do any initialization you need here.
            this.n=n;
            this.zeroSemaphore= new Semaphore(1);
            this.oddSemaphore = new Semaphore(0);
            this.evenSemaphore= new Semaphore(0);
            // -- write your code here --
        }

        public void zero(IntConsumer printZero) throws InterruptedException {
            for(int i=1;i<=n;i++){
                zeroSemaphore.acquire();
                printZero.accept(0);
                if(i%2==1)
                    oddSemaphore.release();
                else
                    evenSemaphore.release();
            }
            // printZero.accept(x) outputs "x", where x is 0.
            // if x is not 0, printZero will throw exception, check the logic in Main.java

            // -- write your code here --
        }

        public void even(IntConsumer printEven) throws InterruptedException {
            for(int i=2;i<=n;i+=2){
                evenSemaphore.acquire();
                printEven.accept(i);
                zeroSemaphore.release();
            }
            // printEven.accept(x) outputs "x", where x is an even number.
            // if x is not even, printEven will throw exception, check the logic in Main.java

            // --  write your code here --
        }

        public void odd(IntConsumer printOdd) throws InterruptedException {
            for(int i=1;i<=n;i+=2){
                oddSemaphore.acquire();
                printOdd.accept(i);
                zeroSemaphore.release();
            }
            // printOdd.accept(x) outputs "x", where x is an odd number.
            // if x is not odd, printOdd will throw exception, check the logic in Main.java

            // --  write your code here --
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new Main().new ZeroEvenOdd(10);

        IntConsumer printZero = (int x) -> {
            try {
                if (x != 0) {
                    throw new Exception("passed x != 0 to printZero in thread for printing zeroes.");
                }
                System.out.print(x);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        };
        IntConsumer printEven = (int x) -> {
            try {
                if (x % 2 != 0) {
                    throw new Exception("passed odd number to printEven in thread for printing even numbers.");
                }
                System.out.print(x);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        };
        IntConsumer printOdd = (int x) -> {
            try {
                if (x % 2 != 1) {
                    throw new Exception("passed even number to printOdd in thread for printing odd numbers.");
                }
                System.out.print(x);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        };

        new Thread(() -> {
            try {
                zeroEvenOdd.zero(printZero);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(printEven);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(printOdd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

