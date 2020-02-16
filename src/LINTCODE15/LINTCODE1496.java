package LINTCODE15;

public class LINTCODE1496 {
    /*Description
    *已有方法rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10生成 1 到 10 范围内的均匀随机整数。
    * 不要使用系统的Math.random()方法
    * */

    private static int rand7(){
        return (int) Math.ceil((Math.random() * 7));
    }


    public int rand10() {
        int index=49;
        while(index>40){
            index=(rand7()-1)*7+rand7();
        }
        return index%10+1;

    }

    public static void main(String[] args){
        for(int i=0;i<49;i++)
            System.out.println(rand7());
    }
}
