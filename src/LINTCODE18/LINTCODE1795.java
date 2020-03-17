package LINTCODE18;

public class LINTCODE1795 {
    /*Description
    * 考虑一对整数，（a，b）。可以对（a，b）以任何顺序，零次或多次执行以下操作：
    * -（a，b） - >（a + b，b）
    *  -（a，b） - >（a，a + b）
    * 例如，从（1,4）开始执行操作（1 + 4, 4）以获得（5, 4）然后执行操作（5, 5 + 4）以获得（5, 9），最后执行操作（ 5, 5 + 9）得到（5, 14）。
    * 或者，第一个操作可能是（1,1 + 4）得到（1,5）等等。你需要返回一个字符串，表示你是否可以将（a，b）转换为（c，d）
    * 通过预先形成零个或多个上面指定的操作。如果可能，返回字符串Yes。否则，返回No。
    * */

    public String IsPossible(int a, int b, int c, int d) {
        if(a>c||b>d)
            return "No";
        if(c==d){
            if(c==a&&d==b)
                return "Yes";
            return "No";
        }
        if(a==c){
            return (d-b)%c==0?"Yes":"No";
        }
        if(b==d){
            return (c-a)%d==0?"Yes":"No";
        }
        if(d>c){
            return IsPossible(a,b,c,d%c);
        }
        return IsPossible(a,b,c%d,d);
        // write your code here
    }
}
