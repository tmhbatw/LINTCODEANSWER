package LINTCODE8;

public class LINTCODE749 {
    /*Description
    *约翰想在他家后面的空地上建一个后花园，现在有两种砖，一种3 dm的高度，7 dm的高度。约翰想围成x dm的墙。如果约翰能做到，输出YES，否则输出NO。
    * */

    public String isBuild(int x) {
        if(x>21){
            x=x%21+21;
        }
        for(int i=0;i<6;i++){
            if(x%3==0)
                return "YES";
            x-=7;
            if(x<0)
                return "NO";
        }
        return "NO";
        // write you code here
    }
}
