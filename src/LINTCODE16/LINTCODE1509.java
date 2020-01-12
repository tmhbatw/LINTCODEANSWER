package LINTCODE16;

import java.util.HashMap;
import java.util.List;

public class LINTCODE1509 {
    /*Description
    * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
    * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
    * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
    * 注意，一开始你手头没有任何零钱。
    * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
    * */

    public boolean lemonadeChange(List<Integer> bills) {
        int number5=0;
        int number10=0;
        for(int cur:bills){
            switch (cur){
                case 5:
                    number5++;
                    break;
                case 10:
                    if(number5==0)
                        return false;
                    else {
                        number5--;
                        number10++;
                    }
                    break;
                case 20:
                    if(number10>0&&number5>0){
                        number10--;
                        number5--;
                    }else if(number5>2){
                        number5-=3;
                    }else
                        return false;
                        break;
            }
        }
        return true;
        // Write your code here.
    }
}
