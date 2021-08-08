package LINTCODE3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE240 {
    /*Description
    * 有一种编程语言，只有以下五种命令，每种命令最多有两个参数，请检查给定的程序是否 可能 无限循环。
    * 这些命令分别是：
    * label <string>：声明一个标签，参数是一个字符串，且每个标签只声明一次。
    * goto <string>：跳转到一个标签，并从标签处开始按顺序执行程序。
    * halt：停机，程序终止。
    * print <string>：打印一个字符串，并执行下一个命令。
    * gotorand <label1> <label2>：随机跳转到两个标签中的一个，并从标签处开始按顺序执行程序。
    * 当程序执行完最后一句，且没有跳转时，程序终止。
    * */

    boolean result = false;
    Map<String,Integer> map=new HashMap<>();
    public boolean check(List<String> commands) {
        for(int i=0;i<commands.size();i++){
            if(commands.get(i).length()>=5&&commands.get(i).substring(0,5).equals("label")){
                String command = commands.get(i).substring(6);
                map.put(command,i);
            }
        }
        boolean[] reached=new boolean[commands.size()];
        dfs(commands,reached,0);
        return result;
        // write your code here.
    }


    private void dfs(List<String> commands, boolean[] reached, int index){
        if(result)
            return;
        for(int i=index;i<commands.size();i++){
            if(reached[i]){
                result=true;
                return;
            }
            reached[i]=true;
            String command=commands.get(i);
            if(command.equals("halt"))
                return;
            if(command.length()>=8&& command.startsWith("gotorand")){
                String[] c=command.split(" ");
                boolean[] curReached=reached.clone();
                dfs(commands,curReached,map.get(c[1]));
                dfs(commands,reached,map.get(c[2]));
                return;
            }
            if(command.length()>=4&&command.startsWith("goto")){
                String[] c=command.split(" ");
                dfs(commands,reached,map.get(c[1]));
                return ;
            }
        }
    }
}
