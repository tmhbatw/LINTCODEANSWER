import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Exercise {

    //获取log2 a/b 的值
    public double getResult(int a,int b){
        return Math.log(a*1.0/b)/Math.log(2);
    }

    public static void main(String[] args){
        Set set=new HashSet<>();
        String uuid=UUID.randomUUID().toString().toUpperCase();
        System.out.println(uuid);
    }


}
