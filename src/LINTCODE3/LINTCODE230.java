package LINTCODE3;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE230 {
    /*Description
    * 在一个宠物避难所里，仅有狗和猫两种动物可供领养，且领养时严格执行“先进先出”的规则。如果有人想要从避难所领养动物，
    * 他只有两种选择：要么选择领养所有动物中最资深的一只（根据到达避难所的时间，越早到的越资深），要么选择领养猫或狗（同样，也只能领养最资深的一只）。
    * 也就是说，领养者不能随意选择某一指定动物。请建立一个数据结构，使得它可以运行以上规则，并可实现 enqueue, dequeueAny, dequeueDog， 和 dequeueCat 操作。
    * 建议使用 LinkedList 作为数据结构实现。
    * */

    public class AnimalShelter {
        /*
         * @param name: a string
         * @param type: an integer, 1 if Animal is dog or 0
         * @return: nothing
         */
        int index=0;
        class Dog{
            String name;
            int index;
            public Dog(String name,int index){
                this.name = name;
                this.index = index;
            }
        }
        class Cat{
            String name;
            int index;
            public Cat(String name, int index){
                this.name = name;
                this.index = index;
            }
        }
        Queue<Dog> dogs = new LinkedList<>();
        Queue<Cat> cats = new LinkedList<>();

        public void enqueue(String name, int type) {
            if(type == 1){
                Dog dog=new Dog(name,index++);
                dogs.add(dog);
            }else{
                Cat cat =new Cat(name, index++);
                cats.add(cat);
            }
            // write your code here
        }

        /*
         * @return: A string
         */
        public String dequeueAny() {
            if(dogs.isEmpty()&&cats.isEmpty())
                return null;
            if(dogs.isEmpty())
                return cats.poll().name;
            if(cats.isEmpty())
                return dogs.poll().name;
            if(cats.peek().index<dogs.peek().index)
                return cats.poll().name;
            return dogs.poll().name;
            // write your code here
        }

        /*
         * @return: A string
         */
        public String dequeueDog() {
            if(dogs.isEmpty())
                return null;
            return dogs.poll().name;
            // write your code here
        }

        /*
         * @return: A string
         */
        public String dequeueCat() {
            if(cats.isEmpty())
                return null;
            return cats.poll().name;
            // write your code here
        }
    }
}
