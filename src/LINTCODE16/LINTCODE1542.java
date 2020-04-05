package LINTCODE16;

public class LINTCODE1542 {
    /*Description
    * 给一个字符串，代表时间，如"12:34"（这是一个合法的输入数据），并找到它的下一次不重复(不存在相同的数字)的时间。
    * 如果它是最大的时间"23:59"，那么返回的答案是最小的"01:23"。如果输入是非法的，则返回-1
    * */

    public String nextTime(String time) {
        if (time == null || time.length() != 5)
            return "-1";
        if(time.charAt(2)!=':'||!isInteger(time.charAt(0))||!isInteger(time.charAt(1))||!isInteger(time.charAt(3))||!isInteger(time.charAt(4)))
            return "-1";
        if(time.equals("23:59"))
            return "01:23";
        String[] times=time.split(":");
        int hour=Integer.parseInt(times[0]);
        int minute=Integer.parseInt(times[1]);
        if(hour>=24||minute>=60)
            return "-1";
        int[] t=new int[4];
        t[0]=time.charAt(0)-'0';
        t[1]=time.charAt(1)-'0';
        t[2]=time.charAt(3)-'0';
        t[3]=time.charAt(4)-'0';
        add(t);
        while(!isDifferent(t))
            add(t);
        return t[0]+""+t[1]+":"+t[2]+""+t[3];
        // write your code here
    }

    private void add(int[] cur){
        if(cur[3]==9){
            if(cur[2]==5){
                if(cur[1]==9){
                    cur[0]++;
                    cur[1]=cur[2]=cur[3]=0;
                }else{
                    cur[1]++;
                    cur[2]=cur[3]=0;
                }
            }else{
                cur[2]++;
                cur[3]=0;
            }
        }else{
            cur[3]++;
        }
    }

    private boolean isDifferent(int[] cur){
        if(cur[0]!=cur[1]&&cur[0]!=cur[2]&&cur[0]!=cur[3]&&
            cur[1]!=cur[2]&&cur[1]!=cur[3]&&cur[2]!=cur[3])
            return true;
        return false;
    }

    private boolean isInteger(char cur){
        return cur<='9'&&cur>='0';
    }







}
