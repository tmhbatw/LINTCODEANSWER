package LINTCODE16;

public class LINTCODE1519 {

    /*Description
    * 在霍格沃茨魔法学校里面，有一个简单的时间魔法，可以将当前的时间转换到最大的时间，但是只能修改几个固定的位置。最长时间是23:59，最短时间是00:00，表示时间的格式为hh:mm
    * 例如：现在是"2?:2?"，那么可以转换的最大时间为"23:29"
    * */

    /*Solution
    * 分类讨论
    * */

    public char[] timeMagic(char[] newTime) {
        if(newTime[4]=='?')
            newTime[4]='9';
        if(newTime[3]=='?')
            newTime[3]='5';
        if(newTime[0]=='?'&&newTime[1]=='?'){
            newTime[0]='2';
            newTime[1]='3';
        }
        if(newTime[1]=='?'){
            if(newTime[0]=='2')
                newTime[1]='3';
            else
                newTime[1]='9';
        }
        if(newTime[0]=='?'){
            if(newTime[1]<='3')
                newTime[0]='2';
            else
                newTime[0]='1';
        }
        //
        return newTime;
    }
}
